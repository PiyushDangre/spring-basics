package com.app.annotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
	
		public static void main(String[] args) {
			
			/**
			 * - Use AnnotationConfigApplicationContext when @Configuration has been used instead of XML.
			 */
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportConfig.class);
			Coach swimCoach = ctx.getBean("swimCoach", Coach.class);
			swimCoach.run();
			swimCoach.getCostume();
			String teamName = swimCoach.getTeamName();
			System.out.println(teamName);
		}
}
