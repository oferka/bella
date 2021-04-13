package org.ok.bella;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.ok.bella.data.sample.SampleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.helpers.LaunchUtil;

@SpringBootApplication(scanBasePackages = "org.ok.bella")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Bean
    public CommandLineRunner runJob(@Autowired SampleEmployeeService sampleEmployeeService) {
        return args -> {
            sampleEmployeeService.load();
        };
    }

    @Bean
    public OpenAPI employeeAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI().info(
                new Info()
                        .title("Bella API")
                        .version(appVersion)
                        .description("Bella server created using springdocs - a library for OpenAPI 3 with spring boot.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("http://springdoc.org")
                        )
        );
    }
}
