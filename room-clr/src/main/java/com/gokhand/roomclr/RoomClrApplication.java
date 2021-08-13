package com.gokhand.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomClrApplication {

    private static final Logger LOG = LoggerFactory.getLogger(RoomClrApplication.class);
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            LOG.info("Starting CLR application");
            for(var i=1; i<=100; i++) {
                if(i%3==0 && i%5==0) {
                    System.out.println("fizbuzz: "+i);
                } else {
                    if(i%3==0) {
                        System.out.println("fiz: "+i);
                    }else if(i%5==0) {
                        System.out.println("buz: "+i);
                    } else {
                        System.out.println(i);
                    }
                }

            }

            LOG.info("finishing CLR application");
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

}
