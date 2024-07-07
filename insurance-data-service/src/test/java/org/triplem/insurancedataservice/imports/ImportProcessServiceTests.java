package org.triplem.insurancedataservice.imports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.triplem.insurancedataservice.imports.service.ImportProcessService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ImportProcessServiceTests {

    @Autowired
    ImportProcessService importProcessService;

    private File importFile;

    @BeforeEach
    void init() {
        importFile = new File(Paths.get("src", "test", "resources", "region_test.csv").toString());
    }

    @Test
    @DisplayName("Import region file")
    void testImportRegionFile() {
        assertDoesNotThrow(() -> importProcessService.startImport(Files.readAllBytes(importFile.toPath()), "region"));
    }


}
