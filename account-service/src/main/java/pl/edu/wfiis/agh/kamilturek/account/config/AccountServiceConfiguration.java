package pl.edu.wfiis.agh.kamilturek.account.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients(basePackages = "pl.edu.wfiis.agh.kamilturek.account")
@EnableSwagger2
public class AccountServiceConfiguration {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .apis(RequestHandlerSelectors.basePackage("pl.edu.wfiis.agh.kamilturek.account.controller"))
                                                      .paths(PathSelectors.any())
                                                      .build()
                                                      .apiInfo(
                                                              new ApiInfoBuilder().version("1.0")
                                                                                  .title("Account API")
                                                                                  .description("Documentation of Account API v1.0")
                                                                                  .build()
                                                      );
    }
}
