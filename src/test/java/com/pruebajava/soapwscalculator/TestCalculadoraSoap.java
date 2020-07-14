package com.pruebajava.soapwscalculator;



import org.junit.jupiter.api.Test;

import com.pruebajava.soap_ws_calculator.Operacion;
import com.pruebajava.webservice.CalculadoraService;

import junit.framework.TestCase;

class TestCalculadoraSoap extends TestCase{
	
	
	private CalculadoraService calculadoraServ= new CalculadoraService();
	
	public  TestCalculadoraSoap() {
		calculadoraServ.init();
	}

	@Test
	void testSumar() {
		
		double esperado=Math.round(2.3+4.1);
		
		double resultado=Math.round(calculadoraServ.calcular(2.3, 4.1, Operacion.SUMAR).getResultado());
		assertEquals(esperado, resultado);
	}
	
	@Test
	void testRestar() {
		double esperado=Math.round(2.3-4.1);
		
		double resultado=Math.round(calculadoraServ.calcular(2.3, 4.1, Operacion.RESTAR).getResultado());
		assertEquals(esperado, resultado);
	}
	
	@Test
	void testMultiplicar() {
		double esperado=Math.round(2.3*4.1);
		
		double resultado=Math.round(calculadoraServ.calcular(2.3, 4.1, Operacion.MULTIPLICAR).getResultado());
		assertEquals(esperado, resultado);
	}
	
	@Test
	void testDividir() {
		double esperado=Math.round(2.3/4.1);
		
		double resultado=Math.round(calculadoraServ.calcular(2.3, 4.1, Operacion.DIVIDIR).getResultado());
		assertEquals(esperado, resultado);
	}




}
