package pl.edu.wfiis.agh.kamilturek.notification.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableDiscoveryClient
@EnableSwagger2
public class NotificationServiceConfiguration {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .apis(RequestHandlerSelectors.basePackage("pl.edu.wfiis.agh.kamilturek.notification.controller"))
                                                      .paths(PathSelectors.any())
                                                      .build()
                                                      .apiInfo(
                                                              new ApiInfoBuilder().version("1.0")
                                                                                  .title("Notification API")
                                                                                  .description("Documentation of Notification API v1.0")
                                                                                  .build()
                                                      );
    }
}