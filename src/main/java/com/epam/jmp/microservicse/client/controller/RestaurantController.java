package com.epam.jmp.microservicse.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.jmp.FoodDelivery;
import com.epam.jmp.Menu;
import com.epam.jmp.Restaurant;

@RestController
public class RestaurantController {

	@Autowired
	private FoodDelivery foodDelivery;

	@Value("${server.port}")
	private Integer serverPort;

	@RequestMapping(value = "/restaurants", produces = "application/json")
	public List<Restaurant> search(@RequestParam(value = "type", required = false) String type) {
		return type == null ? foodDelivery.getRestaurants() : foodDelivery.findForType(Restaurant.Type.valueOf(type
				.toUpperCase()));
	}

	@RequestMapping(value = "/restaurants/{restaurantId}", produces = "application/json")
	public Restaurant restaurantById(@PathVariable("restaurantId") int restaurantId) {
		return foodDelivery.findById(restaurantId);
	}

	@RequestMapping(value = "/restaurants/{restaurantId}/menu", produces = "application/json")
	public Menu restaurantMenu(@PathVariable("restaurantId") int restaurantId) {
		Restaurant r = foodDelivery.findById(restaurantId);
		return r == null ? null : r.getMenu();
	}

	@RequestMapping(value = "/config/server-port")
	public Integer getServerPortFromConfigServer() {
		return serverPort;
	}
}
