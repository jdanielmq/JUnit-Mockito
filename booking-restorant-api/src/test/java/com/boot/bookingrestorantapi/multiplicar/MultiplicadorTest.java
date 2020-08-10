package com.boot.bookingrestorantapi.multiplicar;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MultiplicadorTest {
	
	Multiplicador multiplicar = null;
	
	@Before
	public void before() {
		this.multiplicar = new Multiplicador();
	}
	
	@Test
	public void multiplicarTest() {
		System.out.println("test de Multiplicar");
		int x = multiplicar.multiplicar(5);
		int esperado = 25;
		assertEquals(esperado, x);
	}
}
