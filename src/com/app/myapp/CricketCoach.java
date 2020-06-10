package com.app.myapp;

public class CricketCoach implements Coach{
	
	private EquipmentService equipmentService;
		
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

	/**
	 * For injecting literal values - Create properties and setters.
	 * These properties will be set in the applicationContext.xml file.
	 */
	private String teamName;
	private String salary;
	private String club;
			
	public void setClub(String club) {
		this.club = club;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


	public CricketCoach(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}


	@Override
	public void run() {
		System.out.println("Count runs");
		
	}


	@Override
	public String getEquipments() {
		
		return "From cricket coach : "+this.equipmentService.getEquipments();
	}
	
	public void getCoachDetails() {
		System.out.println("Details are= "+this.salary+" and "+this.teamName+" and club is "+this.club);
	}
	
	/**
	 * This method cannot accept any parameter.
	 * - It has to be no-arg method. As this is wired as 
	 * 	 init-method in annotationConotext.XML
	 */
	public void onStartup() {
		System.out.println("Bean Startup");
	}
	
	/**
	 * 	This method cannot accept any parameter.
	 * - It has to be no-arg method. As this is wired as 
	 * 	 destroy-method in annotationConotext.XML
	 */
	public void onDestroy() {
		System.out.println("Bean is being destroyed");
	}

}
