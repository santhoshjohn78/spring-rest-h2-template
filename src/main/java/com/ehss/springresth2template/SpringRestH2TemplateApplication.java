package com.ehss.springresth2template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringRestH2TemplateApplication {

    @Value("${app.name}")
    String appName;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestH2TemplateApplication.class, args);
    }

    @Bean
    HealthIndicator healthIndicator(){
        return () -> Health.status("I "+appName+" am running...").build();

    }

    @Bean
    CommandLineRunner runner(SampleEntityRepository ser) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<String> str = Arrays.asList("dsdskj,sdsds,sdsewe,sdsww".split(","));
                str.forEach(s -> ser.save(new SampleEntity(s)));


                ser.findAll().forEach(s->System.out.println(s));

                ser.findByValue("dsdskj").forEach(s->System.out.println("findByValue:::"+s));
            }
        };
    }


}
