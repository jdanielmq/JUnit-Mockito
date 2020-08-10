package com.example.demo;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalculadoraTest {
	
	@Mock
	ApiGoogle apiGoogle;
	
	
	@InjectMocks
	Calculadora calculadora;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		when(apiGoogle.sumar(5,5)).thenReturn(10);
	}
	
	@Test
	public void sumaNuestraTest() {
		assertEquals(10, calculadora.sumaNuestra(5, 5));
	}
	
	

}
