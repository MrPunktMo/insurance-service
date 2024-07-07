package org.triplem.insurancedataservice.imports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.triplem.insurancedataservice.imports.components.starter.ProcessStarter;
import org.triplem.insurancedataservice.imports.util.ImportData;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ProcessStarterTests {

    @Autowired
    ProcessStarter processStarter;

    private File importFile;

    @BeforeEach
    void init() {
        importFile = new File(Paths.get("src", "test", "resources", "region_test.csv").toString());
    }
    @Test
    @DisplayName("Import a test file via Processstarter")
    void testImporTestFile() {
        assertDoesNotThrow(() -> processStarter.startProcess(new ImportData("region", Files.readAllBytes(importFile.toPath()))));
    }

}
