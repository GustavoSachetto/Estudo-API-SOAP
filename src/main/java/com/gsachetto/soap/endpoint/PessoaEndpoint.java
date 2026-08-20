package com.gsachetto.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gsachetto.soap.entity.pessoa.GetPessoaRequest;
import com.gsachetto.soap.entity.pessoa.GetPessoaResponse;

@Endpoint
public class PessoaEndpoint {

    private static final String NAMESPACE_URI = "http://gsachetto.com/soap/entity/pessoa";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPessoaRequest")
    @ResponsePayload
    public GetPessoaResponse getPessoa(@RequestPayload GetPessoaRequest request) {
        GetPessoaResponse response = new GetPessoaResponse();
        response.getNome().add("Gustavo Sachetto");
        return response;
    }
}