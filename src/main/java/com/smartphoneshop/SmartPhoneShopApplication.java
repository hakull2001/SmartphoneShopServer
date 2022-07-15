package com.smartphoneshop;

import com.smartphoneshop.configs.MailInfoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties({MailInfoProperties.class})
public class SmartPhoneShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartPhoneShopApplication.class, args);
    }

}
