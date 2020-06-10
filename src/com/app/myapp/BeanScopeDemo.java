package com.app.myapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean scope by default is singleton.
 * We can specify scope using scope attribute in application context xml
 * @author Piyush Dangre
 *
 */
public class BeanScopeDemo {
	
	public static void main(String[] args) {
		
			ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("bean-scope-applicationContext.xml");
			Coach c1 = ctx.getBean("getCoach", Coach.class);
			Coach c2 = ctx.getBean("getCoach", Coach.class);
			
			System.out.println(c1 == c2); // This prints out false. As the bean has been defined with prototype scope.
			// So new instance is returned everytime it is requested.
			
			/**
			 *  This bean has been declared with @Component annotation
			 */
			TennisCoach tennisCoach = ctx.getBean("myTennisCoach", TennisCoach.class); 
			tennisCoach.run(); // Prints "This is tennis Coach"
			tennisCoach.getClothes(); // This has been provided with dependency using constructor injection.
			String teamName = tennisCoach.getTeamName();
			System.out.println(teamName); // This displays team name using property injection
			// Close context
			ctx.close();
	}
}
