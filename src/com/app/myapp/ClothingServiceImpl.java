package com.app.myapp;

import org.springframework.stereotype.Component;

@Component
public class ClothingServiceImpl implements ClothingService {

	@Override
	public void provideClothes() {
		System.out.println("I provide clothes to the players");	
	}

}
