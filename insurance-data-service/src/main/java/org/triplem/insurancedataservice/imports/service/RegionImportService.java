package org.triplem.insurancedataservice.imports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.region.model.RegionDAO;
import org.triplem.insurancedataservice.data.region.repository.RegionRepository;
import org.triplem.insurancedataservice.imports.util.ImportDataPreparator;
import org.triplem.insurancedataservice.imports.util.ImportService;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;

import java.util.List;


@Service
public class RegionImportService extends ImportService<RegionDAO> {

    private final RegionRepository regionRepository;

    @Autowired
    protected RegionImportService(ImportDataPreparator<RegionDAO> importDataPreparator, RegionRepository regionRepository ) {
        super(importDataPreparator);
        this.regionRepository = regionRepository;
    }

    @Override
    protected String getImportTableName() {
        return "region";
    }

    @Override
    protected boolean startImport(ImportData importData) {
        return super.importData(importData, this);
    }

    @Override
    protected RegionDAO initImportObject() {
        return new RegionDAO();
    }

    @Override
    protected void saveImportData(List<RegionDAO> importData) {
        regionRepository.saveAll(importData);
        regionRepository.flush();
    }

    @Override
    protected void truncateTable() {
        regionRepository.truncate();
    }

}
