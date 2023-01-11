package ru.egormit.gateway.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.egormit.gateway.utils.ModelMapper;

@Configuration
public class StarshipClientConfig {

    @Value("${service.second-service.url}")
    private String url;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.baeldung.springsoap.gen");
        return marshaller;
    }

    @Bean
    public StarshipClient countryClient(Jaxb2Marshaller marshaller) {
        StarshipClient client = new StarshipClient();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMapper(new ModelMapper());
        return client;
    }

}
