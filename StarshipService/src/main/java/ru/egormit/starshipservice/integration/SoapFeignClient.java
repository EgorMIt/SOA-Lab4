package ru.egormit.starshipservice.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.egormit.library.SpaceMarineResponse;
import ru.egormit.library.SpaceMarineUpdateRequest;
import ru.egormit.starshipservice.configuration.SoapFeignConfiguration;

/**
 * Запросы к первому сервису.
 *
 * @author Egor Mitrofanov.
 */
@FeignClient(name = "first-service", url = "${service.first-service.url}", configuration = SoapFeignConfiguration.class)
public interface SoapFeignClient {

    /**
     * Получение Spacemarine по ID
     *
     * @param id идентификатор
     * @return модель Spacemarine
     */
    @GetMapping(value = EndpointsFirstService.GET_SPACEMARINE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    SpaceMarineResponse getSpacemarine(@PathVariable Long id);


//    @PostMapping(value = "", consumes = MediaType.TEXT_XML, produces = MediaType.TEXT_XML)
//    SpaceMarineResponse getSpacemarineWithSoap(@RequestBody Add addRequest);


    /**
     * Изменение Spacemarine по ID
     *
     * @param id             идентификатор
     * @param spaceMarineDto новая модель
     */
    @PutMapping(value = EndpointsFirstService.UPDATE_SPACEMARINE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateSpacemarine(@PathVariable Long id, @RequestBody SpaceMarineUpdateRequest spaceMarineDto);

}
