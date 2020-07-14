package com.pruebajava.webservice;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pruebajava.soap_ws_calculator.Calculadora;
import com.pruebajava.soap_ws_calculator.Operacion;


@Component
public class CalculadoraService {

	private Calculadora calculadora;
	
	private static final Logger log = LoggerFactory.getLogger(CalculadoraService.class);

	@PostConstruct
	public void init() {
		calculadora = new Calculadora();

	}

	public Calculadora calcular(Double num1, Double num2, Operacion operacion) {
		
		calculadora.setNum1(num1);
		calculadora.setNum2(num2);
		calculadora.setOperacion(operacion);
		switch (operacion) {
		case SUMAR: {
			calculadora.setResultado(num1 + num2);
			log.info("Se realizó suma");
		}

			break;
		case RESTAR: {
			calculadora.setResultado(num1 - num2);
			log.info("Se realizó resta");
		}

			break;
		case MULTIPLICAR: {
			calculadora.setResultado(num1 * num2);
			log.info("Se realizó multiplicación");
		}

			break;
		case DIVIDIR: {
		
			calculadora.setResultado(num1 / num2);
			log.info("Se realizó división");
		}
		default:{
			log.info("No es una operación válida");
		}
			break;
	
		}
		
		return calculadora;
	}
}
