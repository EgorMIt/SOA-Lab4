package ru.egormit.starshipservice.utils;


import com.baeldung.springsoap.gen.CoordinatesXml;
import com.baeldung.springsoap.gen.CreateStarship;
import com.baeldung.springsoap.gen.StarshipXml;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.egormit.library.Coordinates;
import ru.egormit.library.SpaceMarine;
import ru.egormit.library.SpaceMarineResponse;
import ru.egormit.library.SpaceMarineUpdateRequest;
import ru.egormit.library.StarShip;
import ru.egormit.library.StarShipDto;
import ru.egormit.library.StarShipRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер моделей.
 *
 * @author Egor Mitrofanov.
 */
@Component
@RequiredArgsConstructor
public class ModelMapper {

    public StarShipDto map(StarShip starShip) {
        StarShipDto dto = new StarShipDto();
        dto.setId(starShip.getId());
        dto.setName(starShip.getName());
        dto.setFleet(starShip.getFleet());
        long health = 0L;
        long marinesCount = 0L;
        List<Long> spaceMarines = new ArrayList<>();
        for (SpaceMarine spaceMarine : starShip.getSpaceMarines()) {
            spaceMarines.add(spaceMarine.getId());
            health += spaceMarine.getHealth();
            marinesCount++;
        }
        dto.setHealth(health);
        dto.setMarinesCount(marinesCount);
        dto.setSpaceMarines(spaceMarines);
        dto.setCoordinates(Coordinates.of(starShip.getCoordinateX(), starShip.getCoordinateY()));
        return dto;
    }

    public StarshipXml map(StarShipDto dto) {
        StarshipXml xml = new StarshipXml();
        xml.setId(dto.getId());
        xml.setName(dto.getName());
        xml.setFleet(dto.getFleet());
        xml.setHealth(dto.getHealth());
        xml.setMarinesCount(dto.getMarinesCount());
        CoordinatesXml coordinatesXml = new CoordinatesXml();
        coordinatesXml.setX(dto.getCoordinates().getX());
        coordinatesXml.setY(dto.getCoordinates().getY());
        xml.setCoordinates(coordinatesXml);
        return xml;
    }

    public StarShipRequest map(CreateStarship xml) {
        StarShipRequest request = new StarShipRequest();
        request.setName(xml.getName());
        request.setFleet(xml.getFleet());
        request.setCoordinates(Coordinates.of(xml.getCoordinates().getX(), xml.getCoordinates().getY()));
        return request;
    }

    public SpaceMarineUpdateRequest map(SpaceMarineResponse response) {
        SpaceMarineUpdateRequest request = new SpaceMarineUpdateRequest();
        request.setId(response.getId());
        request.setName(response.getName());
        request.setCoordinates(response.getCoordinates());
        request.setCategory(response.getCategory());
        request.setWeaponType(response.getWeaponType());
        request.setMeleeWeapon(response.getMeleeWeapon());
        request.setCreationDate(response.getCreationDate());
        request.setHealth(response.getHealth());
        return request;
    }

}
