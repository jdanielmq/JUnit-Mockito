package com.boot.bookingrestaurantapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.controllers.RestaurantController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.jsons.TurnRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

public class RestaurantControllerTest {

	private static final Long RESTAURANT_ID = 1L;
	private static final String NAME = "Burger";
	private static final String DESCRIPTION = "Todo tipo de hambuergesa";
	private static final String DIRECCION = "Carlos Dittborn 500";
	private static final String URL_IMAGEN = "https://localhost:8080/imagen";

	private static final String SUCCES_STATUS = "Succes";
	private static final String SUCCES_CODE = "200 OK";
	private static final String OK = "OK";

	private static final List<TurnRest> TURN_LIST = new ArrayList<>();
	private static final List<RestaurantRest> LIST_RESTAURANTS = new ArrayList<>();
	private static final RestaurantRest RESTAURANT_REST = new RestaurantRest();

	@Mock
	RestaurantService restaurantService;

	@InjectMocks
	RestaurantController restaurantController;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);

		RESTAURANT_REST.setName(NAME);
		RESTAURANT_REST.setDescription(DESCRIPTION);
		RESTAURANT_REST.setAddress(DIRECCION);
		RESTAURANT_REST.setId(RESTAURANT_ID);
		RESTAURANT_REST.setImage(URL_IMAGEN);
		RESTAURANT_REST.setTurns(TURN_LIST);

		when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);

	}

	@Test
	public void getRestaurantByIdTest() throws BookingException {
		final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID); // metodo
																												// para
																												// las
																												// consulta

		assertEquals(response.getStatus(), SUCCES_STATUS); // respuestas de estatus
		assertEquals(response.getCode(), SUCCES_CODE); // codigo de la respuesta
		assertEquals(response.getMessage(), OK); // codigo por si salio todo bien
		assertEquals(response.getData(), RESTAURANT_REST); // falta el objetos

	}
	
	@Test
	public void getRestaurantsTest() throws BookingException {
		final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurants();
		
		assertEquals(response.getStatus(), SUCCES_STATUS); // respuestas de estatus
		assertEquals(response.getCode(), SUCCES_CODE); // codigo de la respuesta
		assertEquals(response.getMessage(), OK); // codigo por si salio todo bien
		assertEquals(response.getData(), LIST_RESTAURANTS);// se compara con el resultado real
		
		
	}

}
