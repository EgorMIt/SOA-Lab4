package ru.egormit.starshipservice.integration;

import com.baeldung.springsoap.gen.GetSpacemarine;
import com.baeldung.springsoap.gen.GetSpacemarineResponse;
import com.baeldung.springsoap.gen.UpdateSpacemarine;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import ru.egormit.starshipservice.configuration.SoapFeignConfiguration;


@FeignClient(name = "first-service", url = "${service.first-service.url}", configuration = SoapFeignConfiguration.class)
public interface SoapFeignClient {

    @RequestLine("POST")
    @Headers({"Content-Type: text/xml;charset=UTF-8"})
    GetSpacemarineResponse getSpacemarineWithSoap(@RequestBody GetSpacemarine request);

    @RequestLine("POST")
    @Headers({"Content-Type: text/xml;charset=UTF-8"})
    void updateSpacemarineWithSoap(@RequestBody UpdateSpacemarine request);

}
