package com.pruebajava.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pruebajava.soap_ws_calculator.GetCalculadoraRequest;
import com.pruebajava.soap_ws_calculator.GetCalculadoraResponse;

@Endpoint
public class CalculadoraEndpoint {
	private static final String NAMESPACE_URI = "http://pruebajava.com/soap-ws-calculator";

	private CalculadoraService calcService;

	private static final Logger log = LoggerFactory.getLogger(CalculadoraEndpoint.class);

	@Autowired
	public CalculadoraEndpoint(CalculadoraService calcService) {
		this.calcService = calcService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCalculadoraRequest")
	@ResponsePayload
	public GetCalculadoraResponse getCalculadora(@RequestPayload GetCalculadoraRequest request) {
		GetCalculadoraResponse response = new GetCalculadoraResponse();
		try {
			response.setCalculadora(calcService.calcular(request.getNum1(), request.getNum2(), request.getOperacion()));
		} catch (Exception e) {
			log.error("Error EndPoint", e);
		}
		return response;
	}

}
