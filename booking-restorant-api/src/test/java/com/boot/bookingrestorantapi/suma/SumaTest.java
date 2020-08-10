package com.boot.bookingrestorantapi.suma;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumaTest {
	
	Suma sum = new Suma();
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@Test
	public void sumaTest() {
		System.out.println("SumaTest");
		int sumTest = sum.suma(2, 2);
		int esperado = 4;
		assertEquals(esperado, sumTest);
	}
	
	@After
	public void after() {
		System.out.println("after");
	}

}
