package com.app.annotationConfig;

import org.springframework.beans.factory.annotation.Value;


/**
 * - Notice that @Component has not been used here, because we will be 
 * 	 defining the beans manually in class with @configuration annotation.
 * @author user
 *
 */
public class SwimCoach implements Coach {
	
	/**
	 * Using @Value is possible only because we have setup the 
	 * @propertySource annotation in class with @Configuration annotation.
	 */
	@Value("${sport.club}")
	private String teamName;
	
	/**
	 * This will need to be injected using @Configuration class.
	 *  - Notice that @Autowired has not been used here, because we will be 
	 *    injecting the beans manually in class with @configuration annotation.
	 */
	private CostumeService costumeService;
	
	
	/**
	 * This constructor will be used to inject the costumeService dependency
	 * later on in class with @configuration annotation.
	 * @param costumeService
	 */
	public SwimCoach(CostumeService costumeService) {
		this.costumeService = costumeService ;
	}
	
	@Override
	public void run() {
		System.out.println("Start Swimming");
	}

	@Override
	public String getEquipments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCoachDetails() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void getCostume() {
		this.costumeService.buyCostume();
	}
	
	@Override
	public String getTeamName() {
		return teamName;
	}


}
