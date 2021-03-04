package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Predicate;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEncryptableProperties
@PropertySource("classpath:application.properties")
@Configuration
@EnableSwagger2
public class Config {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	/*public class SpringFoxConfig {                                    
	    @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())              
	          .paths((Predicate<String>) PathSelectors.any())                          
	          .build();                                           
	    }
	}*/
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
}
