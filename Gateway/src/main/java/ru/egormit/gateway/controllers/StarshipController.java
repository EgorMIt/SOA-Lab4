package ru.egormit.gateway.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.egormit.gateway.integration.StarshipClient;
import ru.egormit.gateway.common.Endpoints;
import ru.egormit.library.StarShipDto;
import ru.egormit.library.StarShipRequest;

import java.util.List;

/**
 * Обработчик запросов.
 *
 * @author Egor Mitrofanov.
 */
@RestController
@RequiredArgsConstructor
public class StarshipController {

    private final StarshipClient starshipClient;

    @PostMapping(value = Endpoints.CREATE_STARSHIP)
    public ResponseEntity<Object> createStarship(@RequestBody StarShipRequest request) {
        starshipClient.createStarship(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = Endpoints.GET_ALL_STARSHIPS)
    public ResponseEntity<List<StarShipDto>> getAllStarships() {
        return new ResponseEntity<>(starshipClient.getAllStarships(), HttpStatus.OK);
    }

    @PutMapping(value = Endpoints.ADD_MARINE_TO_STARSHIP)
    public ResponseEntity<Object> addMarineToStarship(@PathVariable("spacemarine-id") Long spacemarineId,
                                                      @PathVariable("starship-id") Long starshipId) {
        starshipClient.loadToStarship(starshipId, spacemarineId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = Endpoints.CLEAN_STARSHIP)
    public ResponseEntity<Object> cleanStarship(@PathVariable Long id) {
        starshipClient.unloadStarship(id);
        return ResponseEntity.ok().build();
    }

}
