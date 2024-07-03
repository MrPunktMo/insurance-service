package org.triplem.insurancedataservice.imports.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;

@Component
@NoArgsConstructor
public class ImportServiceChain {

    private ImportService<?> first;
    private ImportService<?> last;

    public void append(ImportService<?> importService) {
        if(this.first == null)
            this.first =importService;
        else
            this.last.setNext(importService);
        this.last = importService;
    }

    public boolean process(ImportData importData) {
        return importData != null && this.first != null && this.first.processImport(importData);
    }
}
