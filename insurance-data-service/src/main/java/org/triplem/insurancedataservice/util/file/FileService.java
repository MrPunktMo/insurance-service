package org.triplem.insurancedataservice.util.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.util.logging.Logging;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class FileService {

    public boolean isDuplicatesOnFileLevel(String fileName, String inputDirProc) {
        File duplicate = new File(getInputDirWithFileSeparator(inputDirProc) + fileName);
        if (duplicate.exists()) {
            log.error(Logging.DUPLICATE_FILE_ERROR.toString(), duplicate.getPath());
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfFileExists(File checkFile) {
        if (checkFile.exists()) {
            return true;
        } else {
            log.error(Logging.FILE_MISSING_ERROR.toString(), checkFile.getPath());
            return false;
        }
    }

    public boolean checkDirectoryOnReadAndWrite(String directory) {
        boolean success = true;
        File file = new File(directory);
        if (!file.isDirectory()) {
            log.error(Logging.INVALID_DIRECTORY_ERROR.toString(), directory);
            return false;
        } else if (file.canRead() && file.canWrite()) {
            return success;
        } else {
            log.error(Logging.PERMISSION_DIRECTORY_ERROR.toString(), directory);
            return false;
        }
    }

    public boolean moveFile(File source, String directory) {
        boolean success = true;
        String destination = getInputDirWithFileSeparator(directory) + source.getName();

        try {
            Files.move(source.toPath(), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            log.warn(Logging.FILE_CANNOT_BE_MOVED_ERROR.toString(), source.getAbsolutePath(), destination);
            success = false;
        }
        return success;
    }

    public boolean deleteFile(File file) {
        return file.delete();
    }

    public File getFile(String filePath) {
        return new File(filePath);
    }

    public List<File> getFiles(String filePath) {

        List<File> files;

        if(Files.exists(Paths.get(filePath))) {
            try {
                files = Files.list(Paths.get(filePath)).map(Path::toFile).collect(Collectors.toList());
            } catch (IOException ex) {
                log.error(Logging.FILES_NOT_READABLE.toString(), filePath);
                files = new ArrayList<>();
            }
        } else
            files = new ArrayList<>();

        return files;
    }

    public boolean validateImportFileName(File inFile, String filePattern) {
        return validateImportFileName(inFile, new ImportFileNameFilter(filePattern));
    }

    private boolean validateImportFileName(File inFile, FilenameFilter fileNameFilter) {
        String fileName = inFile.getName();
        boolean sucessStatus = true;
        File inFilePath = new File(inFile.getParent());
        String[] allFiles = inFilePath.list(fileNameFilter);
        assert allFiles != null;
        List<String> validFileList = Arrays.asList(allFiles);
        if (!validFileList.contains(fileName)) {
            sucessStatus = false;
        }

        return sucessStatus;
    }

    public String[] getAllLinesFromFile(File file, boolean skipHeader, FileEncoding fileEncoding) {
        String[] lines = null;
        List<String> tempList = new ArrayList<>();
        boolean isFirstLine = true;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName(removeBomFromFileEncoding(fileEncoding))));

            try {
                String line;
                while((line = br.readLine()) != null) {

                    if(isFirstLine && fileEncoding.isBomEncoding()) {
                        line = removeBomFromLine(fileEncoding, line);
                        isFirstLine = false;
                    }

                    if (!skipHeader) {
                        tempList.add(line);
                    } else {
                        skipHeader = false;
                    }
                }

                lines = tempList.toArray(new String[0]);
            } catch (Throwable var9) {
                try {
                    br.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            br.close();
        } catch (IOException var10) {
            log.error(Logging.FILE_READING_ERROR.toString(), file.getName());
        }

        return lines;
    }

    private String removeBomFromFileEncoding(FileEncoding fileEncoding) {
        return fileEncoding.getEncoding().replace(FileEncoding.BOM_PLACEHOLDER.getEncoding(), "");
    }

    private String removeBomFromLine(FileEncoding fileEncoding, String line) {
        switch (fileEncoding) {
            case UTF_8:
                return line.substring(1);
            default:
                return line.substring(1);
        }
    }

    /**
     * Getting the probable file encoding of a file
     * @param inputFile {@link File}
     * @return fileEncoding {@link String}
     */
    public FileEncoding getFileEncodingForImport(File inputFile) {

        FileEncoding fileEncoding;

        try {

            fileEncoding = getFileEncoding(inputFile);

            if (fileEncoding != null) {
                log.info(Logging.FILE_ENCODING.toString(), fileEncoding.getEncoding());
            }

        } catch (IOException exception) {
            log.error(Logging.FILE_MISSING_ERROR.toString(), exception.getMessage());
            fileEncoding = FileEncoding.getFileEncodingFromName(Constants.CHARSET_UTF_8);
        }

        return fileEncoding;
    }

    private FileEncoding getFileEncoding(File inputFile) throws IOException {

        FileEncoding fileEncoding;
        byte[] buf = new byte[4096];
        InputStream fis = new FileInputStream(inputFile);

        UniversalDetector detector = new UniversalDetector();

        int nread;
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }

        detector.dataEnd();
        fileEncoding = FileEncoding.getFileEncodingFromName(detector.getDetectedCharset());
        detector.reset();

        /*Use UTF_8 instead of ASCII*/
        if(fileEncoding.equals(FileEncoding.US_ASCII))
            fileEncoding = FileEncoding.UTF_8;

        /*Check whether its UTF-8 BOM file*/
        if(fileEncoding.equals(FileEncoding.UTF_8))
            fileEncoding = checkAndGetForBom(inputFile);

        return fileEncoding;
    }

    private void logEncodingWarning(String fileEncoding) {
        log.warn(Logging.FILE_ENCODING_WARNING.toString(), fileEncoding);
    }

    private FileEncoding checkAndGetForBom(File inputFile) {

        FileEncoding fileEncoding;

        if(isUTF8BOM(inputFile)) {
            fileEncoding = FileEncoding.UTF_8_BOM;
        } else {
            fileEncoding = FileEncoding.UTF_8;
        }
        return  fileEncoding;
    }

    private boolean isUTF8BOM(File inputFile) {
        boolean isUTF8BOM;

        byte[] bom = new byte[3];
        try(InputStream is = new FileInputStream(inputFile)){

            // read first 3 bytes of a file.
            is.read(bom);

            // BOM encoded as ef bb bf
            String content = new String(Hex.encode(bom));
            isUTF8BOM = "efbbbf".equalsIgnoreCase(content);
        } catch (IOException exception) {
            isUTF8BOM = false;
        }

        return isUTF8BOM;
    }

    public String getAuditErrorFileExtension() {
        return new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
    }

    static class ImportFileNameFilter implements FilenameFilter {

        String pattern;
        public ImportFileNameFilter(String pattern) { this.pattern = pattern; }

        @Override
        public boolean accept(File dir, String name)
        {
            return isCorrectName(name, pattern);
        }

        protected boolean isCorrectName(String filename, String namePattern)
        {
            return Pattern.compile(namePattern, Pattern.CASE_INSENSITIVE).matcher(filename).matches();
        }
    }

    private String getInputDirWithFileSeparator(String inputDir){
        if(inputDir.endsWith(File.separator)){
            return inputDir;
        }else{
            return inputDir + File.separator;
        }
    }
}
