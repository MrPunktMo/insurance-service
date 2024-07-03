package org.triplem.insurancedataservice.util.file;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

@Component
public class FileWriter {

    public boolean writeUTF8File(FileChannel fileChannel, ByteBuffer byteBuffer, String s) throws IOException {

        boolean isWritten = false;

        if (s != null) {
            byteBuffer.clear();
            byteBuffer.put(s.getBytes(StandardCharsets.UTF_8));
            byteBuffer.flip();
            isWritten = (fileChannel.write(byteBuffer) > 0);
        }

        return isWritten;
    }
}

