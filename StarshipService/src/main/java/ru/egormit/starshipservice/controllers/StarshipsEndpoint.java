package ru.egormit.starshipservice.controllers;

import com.baeldung.springsoap.gen.AddMarineToStarship;
import com.baeldung.springsoap.gen.CleanStarship;
import com.baeldung.springsoap.gen.CreateStarship;
import com.baeldung.springsoap.gen.GetAllStarships;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.egormit.starshipservice.service.StarshipService;
import ru.egormit.starshipservice.utils.ModelMapper;

import java.util.stream.Collectors;

@Endpoint
@RequiredArgsConstructor
public class StarshipsEndpoint {

    private final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    private final ModelMapper modelMapper;

    private final StarshipService starshipService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createStarship")
    @ResponsePayload
    public void createStarship(@RequestPayload CreateStarship request) {
        starshipService.createStarship(modelMapper.map(request));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStarships")
    @ResponsePayload
    public GetAllStarships getAllStarships() {
        GetAllStarships getAllStarships = new GetAllStarships();
        getAllStarships.setDtos(starshipService.getAllStarships()
                .stream()
                .map(modelMapper::mapToXml)
                .collect(Collectors.toList()));
        return getAllStarships;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMarineToStarship")
    @ResponsePayload
    public void addMarineToStarship(@RequestPayload AddMarineToStarship request) {
        starshipService.addMarineToStarship(request.getSpacemarineId(), request.getStarshipId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "cleanStarship")
    @ResponsePayload
    public void cleanStarship(@RequestPayload CleanStarship request) {
        starshipService.cleanStarship(request.getId());
    }

}
