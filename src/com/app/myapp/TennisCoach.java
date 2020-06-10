package com.app.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * - We are using @Component annotation here.
 * - We are passing the bean ID as the parameter. 
 * - The bean ID will be used while retrieving the bean.
 * - If we do not specify the bean ID, the default bean ID will be name of class with 
 * 	 a lower-case first letter. That means in this example --> tennisCoach will be ID.
 * @author Piyush Dangre
 *
 */
@Component("myTennisCoach") 
public class TennisCoach implements Coach {
	
	/**
	 * - This is reading the properties file setup in applicationContext.xml
	 * - We can also pass on any random string here.
	 */
	@Value("${sport.club}")
	private String teamName;  // This is to display property injection
	
	/**
	 * This is no-arg constructor which is necessary.
	 */
	public TennisCoach() {
		
	}
	
	/**
	 *	In this class, we see 4 types of dependency injection
	 * - Constructor
	 * - Setter
	 * - Method
	 * - Field 
	 * Choose one style which is suitable to your project and stay consistent.
	 */
	
	/**** FIELD TYPE INJECTION
	 * - No need to write constructor or setter.
	 * - Spring uses Reflection API to bind appropriate implementation of the
	 *   interface here. 
	 * - Most easiest form.  
	 * - If there are more than one implementations use, @Qualifier and pass on name of desired type.
	 */
	@Autowired
	@Qualifier("clothingServiceImpl") // In this case we just have one implementation so this is not required.
	private ClothingService clothingService;  
	
	/*********	AUTOWIRED ANNOTATION
	 * *** CONSTRUCTOR INJECTION
	 * - This is constructor dependency injection using @Autowired annotation.
	 * - An appropriate implementation of ClothingService interface is automatically injected.
	 * - If there are multiple implementations of the ClothingService interface, then 
	 * 	 @Qualifier needs to be used. Otherwise spring throws NoUniqueBeanDefinitionException.
	 * - Pass on name of desired implementation in the @Qualifier annotation.
	 * - In case of constructor, the @Qualifier needs to be passed along with the parameter (Odd case).
	 * - In newer versions of spring, even writing @Autowired is optional. It considers 
	 * 	 implicitly over the constructor if the target bean only defines one constructor.
	 * - If several constructor are there, at least one must be defined with @Autowired
	 * 
	 * @param clothingService
	 */
	@Autowired
	public TennisCoach( @Qualifier("clothingServiceImpl") ClothingService clothingService) {
		this.clothingService = clothingService;
	}
	
	/**** SETTER INJECTION
	 * - This is dependency injection using Setter method.
	 * - This is redundant with respect to above constructor injection.
	 * - Spring will automatically detect the implementing class of ClothingService and inject here.
	 * @param clothingService
	 */
	@Autowired
	public void setClothingService(ClothingService clothingService) {
		this.clothingService = clothingService;
	}
	
	/*** METHOD INJECTION
	 * @Autowired can be used for dependency injection on any method. 
	 * - This method is executed even before bean startup phase. (See console)
	 * - An instance of clothingService is passed automatically.
	 */
	@Autowired
	public void crazyMethod(ClothingService clothingService) {
		System.out.println("This is crazy method injection method");
		clothingService.provideClothes();
	}
	
	@Override
	public void run() {
		System.out.println("This is tennis Coach");

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
	
	public void getClothes() {
		this.clothingService.provideClothes();
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
