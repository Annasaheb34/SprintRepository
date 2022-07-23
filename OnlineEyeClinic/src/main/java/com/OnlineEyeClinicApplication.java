package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableSwagger2
public class OnlineEyeClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEyeClinicApplication.class, args);
		System.out.println("Connect to database");
	}
//	@Bean
//	   public Docket productApi() {
//	      return new Docket(DocumentationType.SWAGGER_2).select()
//	         .apis(RequestHandlerSelectors.basePackage("com")).build();
//	   }
	
	//http://localhost:9090/swagger-ui/index.html

}
