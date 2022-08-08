package com.smartphoneshop;

import com.smartphoneshop.configs.MailInfoProperties;
import com.smartphoneshop.configs.StorageProperties;
import com.smartphoneshop.services.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j  
@EnableConfigurationProperties({MailInfoProperties.class, StorageProperties.class, MailInfoProperties.class})
public class SmartPhoneShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartPhoneShopApplication.class, args);
    }

    @Bean
    CommandLineRunner init(IStorageService storageService) {
        return (args -> {
            storageService.init();
        });
    }
}
