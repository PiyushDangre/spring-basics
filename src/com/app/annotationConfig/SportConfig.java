package com.app.annotationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The third type of application configuration is using JAVA SOURCE
 * - This is to completely get rid of XML configuration.
 * - This configuration class takes place of XML applicationContext file.
 * - All beans are defined here and dependencies are injected.
 * - Even componentScan is not required here, if the beans are to be defined 
 * 	 manually using @Bean annotation.
 * - We are just creating objects from classes here within different method.
 * @author Piyush D
 *
 */
@Configuration
@ComponentScan("com.app.annotationConfig")  // This will be handy only if beans are defined using @Component annotation.
public class SportConfig {
	
	/**
	 * - First define the dependency bean for Swimcoach bean.
	 * - Bean ID will be the method name.
	 */
	@Bean
	public CostumeService costumeService() {
		return new CostumeServiceImpl();
	}
	
	/**
	 * Then define bean for SwimCoach.
	 * Manually inject costumeService dependency
	 */
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(costumeService());
	}
}
