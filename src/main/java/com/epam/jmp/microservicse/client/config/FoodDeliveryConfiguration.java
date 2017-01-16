package com.epam.jmp.microservicse.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.jmp.FoodDelivery;
import com.epam.jmp.Item;
import com.epam.jmp.Location;
import com.epam.jmp.Menu;
import com.epam.jmp.MenuException;
import com.epam.jmp.Restaurant;

@Configuration
public class FoodDeliveryConfiguration {

	@Bean
	public FoodDelivery foodDelivery() throws MenuException {
		FoodDelivery fd = new FoodDelivery();

		// add some restaurants for test
		Menu indianMenu = new Menu();
		indianMenu.add(new Item("chicken", "$10", "good"));
		indianMenu.add(new Item("lamp", "$12", "hot"));
		fd.addRestaurant(new Restaurant(1, "January India", Restaurant.Type.INDIAN, new Location(1, 1), indianMenu));

		Menu chinesMenu = new Menu();
		chinesMenu.add(new Item("chicken", "$10", "good"));
		chinesMenu.add(new Item("beef", "$12", "better"));
		chinesMenu.add(new Item("pork", "$15", "best"));
		fd.addRestaurant(new Restaurant(2, "February China", Restaurant.Type.CHINESE, new Location(2, 2), chinesMenu));

		return fd;
	}

}
