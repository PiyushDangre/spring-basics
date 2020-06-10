package com.app.myapp;

public class AthleteCoach implements Coach{
	
	private EquipmentService equipmentService;
	
	public AthleteCoach(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

	

	@Override
	public void run() {
		System.out.println("Reach there first");
	}



	@Override
	public String getEquipments() {
		// TODO Auto-generated method stub
		return this.equipmentService.getEquipments();
	}



	@Override
	public void getCoachDetails() {
		// TODO Auto-generated method stub
		
	}

}
