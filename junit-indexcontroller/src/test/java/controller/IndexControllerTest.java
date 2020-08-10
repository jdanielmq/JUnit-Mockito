package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.example.demo.controller.IndexController;

public class IndexControllerTest {
	
	@Test
	public void welcomeTest() {
		IndexController indexController = new IndexController();
		
		String[] paramArray  = null;
		String resulActual = "El array viene vacio";
		String resulReal = indexController.welcome(paramArray);
		assertEquals(resulActual, resulReal);
		
	}
	@Test
	public void arraySinDatosTest() {
		IndexController indexController = new IndexController();
		
		String[] paramArray  = new String[3];
		String resulActual = "param[0]null\n" + "param[1]null\n" + "param[2]null\n" ;
		String resulReal = indexController.welcome(paramArray);
		assertEquals(resulActual, resulReal);
		
	}
	
	@Test
	public void arrayConDatosTest() {
		IndexController indexController = new IndexController();
		
		String[] paramArray  = new String[] {"java","desde","0"};
		String resulActual = "param[0]null\n" + "param[1]null\n" + "param[2]null\n" ;
		String resulReal = indexController.welcome(paramArray);
		assertEquals(resulActual, resulReal);
		
	}
	
}
