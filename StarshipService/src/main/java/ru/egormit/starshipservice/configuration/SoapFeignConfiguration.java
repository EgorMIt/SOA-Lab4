package ru.egormit.starshipservice.configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapFeignConfiguration {

    private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
            .withMarshallerJAXBEncoding("UTF-8")
            .withMarshallerSchemaLocation("http://apihost http://apihost/schema.xsd")
            .build();

    @Bean
    public Encoder feignEncoder() {
        return new SOAPEncoder(jaxbFactory);
    }
    @Bean
    public Decoder feignDecoder() {
        return new SOAPDecoder(jaxbFactory);
    }

}
