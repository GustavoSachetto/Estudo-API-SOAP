package com.gsachetto.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig implements WsConfigurer {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // WSDL de Carros: http://localhost:8080/ws/carros.wsdl
    @Bean(name = "carros")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema carroSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CarrosPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://gsachetto.com/soap/entity/carro");
        wsdl.setSchema(carroSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema carroSchema() {
        return new SimpleXsdSchema(new ClassPathResource("carro.xsd"));
    }

    // WSDL de Pessoas: http://localhost:8080/ws/pessoas.wsdl
    @Bean(name = "pessoas")
    public DefaultWsdl11Definition pessoaWsdl(XsdSchema pessoaSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("PessoasPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://gsachetto.com/soap/entity/pessoa");
        wsdl.setSchema(pessoaSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema pessoaSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pessoa.xsd"));
    }
}