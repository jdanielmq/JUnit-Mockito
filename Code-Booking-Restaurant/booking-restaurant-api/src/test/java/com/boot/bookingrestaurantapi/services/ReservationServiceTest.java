package com.boot.bookingrestaurantapi.services;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.NotFountException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.repositories.ReservationRespository;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.services.impl.ReservationServiceImpl;

public class ReservationServiceTest {

	private static final Reservation RESERVATION = new Reservation();
	private static final Optional<Reservation> OPTIONAL_RESERVATION = Optional.of(RESERVATION);
	private static final Optional<Reservation> OPTIONAL_RESERVATION_EMPATY = Optional.empty();
	
	
	/* DATA DE RESTAURANT */
	private static final Restaurant RESTAURANT = new Restaurant();
	private static final Long RESTAURANT_ID = 1L;
	private static final String NAME = "Burger";
	private static final String DESCRIPTION = "Todo tipo de hambuergesa";
	private static final String DIRECCION = "Carlos Dittborn 500";
	private static final String URL_IMAGEN = "https://localhost:8080/imagen";
	private static final Optional<Restaurant> OPTIONAL_RESTAURANT = Optional.of(RESTAURANT);

	private static final Turn TURN = new Turn();
	private static final String TURN_NAME = "Turno 1";
	private static final Long TURN_ID = 1L;
	private static final List<Turn> TURN_LIST = new ArrayList<>();
	private static final Optional<Turn> OPTIONAL_TURN = Optional.of(TURN);
	
	
	

	/* Data de ingreso */
	CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();
	private static final Long RESERVATION_ID = 1L;
	private static final Long PERSON_ID = 1L;
	private static final Date DATE = new Date();
	private static final String LOCATOR = "BURGER 2";
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Mock
	private RestaurantRepository restaurantRepository;

	@Mock
	private TurnRepository turnRepository;

	@Mock
	ReservationRespository reservationRespository;

	@InjectMocks
	ReservationServiceImpl reservationServiceImpl;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);
		
		TURN.setId(TURN_ID);
		TURN.setName(TURN_NAME);
		TURN.setRestaurant(RESTAURANT);
		

		RESTAURANT.setName(NAME);
		RESTAURANT.setDescription(DESCRIPTION);
		RESTAURANT.setAddress(DIRECCION);
		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setImage(URL_IMAGEN);
		RESTAURANT.setTurns(TURN_LIST);

		CREATE_RESERVATION_REST.setDate(DATE);
		CREATE_RESERVATION_REST.setPerson(PERSON_ID);
		CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
		CREATE_RESERVATION_REST.setTurnId(TURN_ID);
		

		RESERVATION.setDate(DATE);
		RESERVATION.setId(RESERVATION_ID);
		RESERVATION.setLocator(LOCATOR);
		RESERVATION.setPerson(PERSON_ID);
		RESERVATION.setTurn(TURN_NAME);
		RESERVATION.setRestaurant(RESTAURANT);

	}

	@Test
	public void createReservationTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		Mockito.when(reservationRespository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
										   .thenReturn(OPTIONAL_RESERVATION_EMPATY);
		Mockito.when(reservationRespository.save(Mockito.any(Reservation.class))).thenReturn(new Reservation());
		
		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);

	}
	
	@Test(expected = BookingException.class)
	public void createReservationTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		Mockito.when(reservationRespository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
										   .thenReturn(OPTIONAL_RESERVATION_EMPATY);
		Mockito.when(reservationRespository.save(Mockito.any(Reservation.class))).thenReturn(new Reservation());
		
		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
		thrown.expect(BookingException.class);


	}
	

	
	
	
	

	/* metodo cuando consulto por algun ID */
	@Test
	public void getReservationTest() throws BookingException {
		Mockito.when(reservationRespository.findById(RESERVATION_ID)).thenReturn(OPTIONAL_RESERVATION);
		reservationServiceImpl.getReservation(RESERVATION_ID);

	}

	@Test(expected = BookingException.class)
	public void getReservationTestError() throws BookingException {
		Mockito.when(reservationRespository.findById(RESERVATION_ID)).thenReturn(Optional.empty());
		reservationServiceImpl.getReservation(RESERVATION_ID);
		fail();

	}

}
