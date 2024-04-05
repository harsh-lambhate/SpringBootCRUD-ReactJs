package net.javaguides.springboot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
@Configuration
public class SwaggerConfig {
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Tech Guru API")
	              .description("tech guru application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("https://www.datatemplate.com/")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Coder Documentation")
	              .url("https://www.datatemplate.com/"));
	  }
	
}
