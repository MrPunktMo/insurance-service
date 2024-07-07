package org.triplem.insurancedataservice.imports.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.triplem.insurancedataservice.data.imports.service.MetaDataService;
import org.triplem.insurancedataservice.imports.components.metaconfig.ConfigHandlerImpl;
import org.triplem.insurancedataservice.imports.components.metaconfig.ConfigHandlerProxy;
import org.triplem.insurancedataservice.util.file.FileService;

@Configuration
public class ImportConfig {

    @Bean
    @Autowired
    public ConfigHandlerProxy configHandler(FileService fileService, MetaDataService metaDataService) {
        return new ConfigHandlerProxy(new ConfigHandlerImpl(fileService, metaDataService));
    }
}
