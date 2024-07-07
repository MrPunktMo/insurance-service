package org.triplem.insurancedataservice.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.triplem.insurancedataservice.imports.components.starter.ProcessStarter;
import org.triplem.insurancedataservice.imports.util.ImportData;
import org.triplem.insurancedataservice.imports.util.ProcessStatus;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ImportApiImpl implements ImportApi {

    private final ProcessStarter processStarter;

    @Override
    public ResponseEntity<Void> postImportRegion(@Valid byte[] regionFile) {

        if(Objects.isNull(regionFile) || regionFile.length == 0)
            return ResponseEntity.badRequest().build();

        ProcessStatus status = processStarter.startProcess(new ImportData("region", regionFile));

        if(status.equals(ProcessStatus.RUNNING))
            return ResponseEntity.unprocessableEntity().build();
        else
            return ResponseEntity.ok().build();

    }

}
