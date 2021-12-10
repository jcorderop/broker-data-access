package org.broker.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@RefreshScope
@ComponentScan(
        basePackages = {
                "org.broker.dataaccess"
        },
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.broker.dataaccess.database.config.*")
)
public class DataAccessManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAccessManagerApplication.class, args);
    }

}
