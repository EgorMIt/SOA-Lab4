package ru.egormit.starshipservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.egormit.starshipservice.service.StarshipService;

/**
 * Обработчик запросов.
 *
 * @author Egor Mitrofanov.
 */
@RestController
@RequiredArgsConstructor
public class StarshipController {

    private final StarshipService starshipService;

//    @PostMapping(value = Endpoints.CREATE_STARSHIP)
//    public ResponseEntity<Object> createStarship(@RequestBody StarShipRequest request) {
//        starshipService.createStarship(request);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping(value = Endpoints.GET_ALL_STARSHIPS)
//    public ResponseEntity<List<StarShipDto>> getAllStarships() {
//        return new ResponseEntity<>(starshipService.getAllStarships(), HttpStatus.OK);
//    }

//    @PutMapping(value = Endpoints.ADD_MARINE_TO_STARSHIP)
//    public ResponseEntity<Object> addMarineToStarship(@PathVariable("spacemarine-id") Long spacemarineId,
//                                                      @PathVariable("starship-id") Long starshipId) {
//        starshipService.addMarineToStarship(spacemarineId, starshipId);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping(value = Endpoints.CLEAN_STARSHIP)
//    public ResponseEntity<Object> cleanStarship(@PathVariable Long id) {
//        starshipService.cleanStarship(id);
//        return ResponseEntity.ok().build();
//    }

}
