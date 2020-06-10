package com.app.myapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	 public static void main(String[] args) {
		
		// load spring config file
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 // get bean from spring container
		 Coach coach = ctx.getBean("getCoach", Coach.class); // We get a fully assembled object here along with the dependency injected already.
		
		 //call methods on bean
		 coach.run();
		 
		 // We will be getting result as dependency have already injected by spring container.
		 System.out.println(coach.getEquipments());
		 
		 coach.getCoachDetails();
		 
		 /**
		  * This is setter injection. Refer applicationContext.xml
		  * Due to <property> tag in applicationContext.xml, Spring calls the setters in the 
		  * background. Means, it injects the dependency using setter.
		  */
		 Coach basketBallCoach = ctx.getBean("myBasketBallCoach", Coach.class);
		 basketBallCoach.run();
		 System.out.println(basketBallCoach.getEquipments());
		 
		 // close context
		 ctx.close();
		 
		 
	}
}
