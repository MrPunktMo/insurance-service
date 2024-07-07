package org.triplem.insurancedataservice.imports.components.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.triplem.insurancedataservice.imports.service.ImportProcessService;

@Configuration
public class ProcessStarterConfig {

    @Bean
    @Autowired
    public ProcessStarterProxy processStarterProxy(ImportProcessService importProcessService) {
        return new ProcessStarterProxy(importProcessService);
    }

}
