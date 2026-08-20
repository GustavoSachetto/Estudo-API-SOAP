package com.gsachetto.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gsachetto.soap.entity.carro.Carro;
import com.gsachetto.soap.entity.carro.Carroceria;
import com.gsachetto.soap.entity.carro.GetCarroRequest;
import com.gsachetto.soap.entity.carro.GetCarroResponse;

@Endpoint
public class CarroEndpoint {

    private static final String NAMESPACE_URI = "http://gsachetto.com/soap/entity/carro";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarroRequest")
    @ResponsePayload
    public GetCarroResponse getCarros(@RequestPayload GetCarroRequest request) {
        GetCarroResponse response = new GetCarroResponse();
        Carroceria tipo = request.getCarroceria();

        Carro c = new Carro();
        c.setMarca("Toyota");
        c.setModelo("Corolla");
        c.setCarroceria(tipo);

        response.getCarro().add(c);
        return response;
    }
}