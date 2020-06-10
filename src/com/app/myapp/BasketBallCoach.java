package com.app.myapp;

public class BasketBallCoach implements Coach {

	public EquipmentService equipmentService;
	
	/**
	 * No-Arg constructor is necessary as because the setter injection is being used. SO,
	 * Spring will first create the object internally and then call upon the setter. Hence,
	 * No arg constructor becomes necessary to initiate object first.
	 */
	public BasketBallCoach() {
		
	}
	
	
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}


	@Override
	public void run() {
	System.out.println("Basketball dump in basket");
	}

	@Override
	public String getEquipments() {
		return "I have ball and baskets as equipments";
	}


	@Override
	public void getCoachDetails() {
		// TODO Auto-generated method stub
		
	}

}
