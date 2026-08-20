# Estudo-API-SOAP

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/aae6a31e-d1b0-4aec-88a1-069124446822" />

Projeto de estudo sobre a criação e o consumo de Web Services SOAP no Spring Boot utilizando a abordagem Contract-First com schemas XSD e geração de POJOs via JAXB.

- **URL base:** `http://localhost:8080/ws`
- **WSDL Carros:** `http://localhost:8080/ws/carros.wsdl`
- **WSDL Pessoas:** `http://localhost:8080/ws/pessoas.wsdl`

## Construção:
- Java + Spring Boot (Spring-WS)
- Abordagem Contract-First com XSD (XML Schema Definition)
- JAXB 2 Maven Plugin para geração automática dos POJOs a partir do XSD
- Mapeamento de rotas e payloads via anotações @Endpoint e @PayloadRoot
