package ru.egormit.gateway.utils;


import com.baeldung.springsoap.gen.CoordinatesXml;
import com.baeldung.springsoap.gen.CreateStarship;
import com.baeldung.springsoap.gen.StarshipXml;
import org.springframework.stereotype.Component;
import ru.egormit.library.Coordinates;
import ru.egormit.library.StarShipDto;
import ru.egormit.library.StarShipRequest;

/**
 * Маппер моделей.
 *
 * @author Egor Mitrofanov.
 */
@Component
public class ModelMapper {

    public StarShipDto map(StarshipXml xml) {
        StarShipDto dto = new StarShipDto();
        dto.setId(xml.getId());
        dto.setName(xml.getName());
        dto.setFleet(xml.getFleet());
        dto.setHealth(xml.getHealth());
        dto.setMarinesCount(xml.getMarinesCount());

        dto.setCoordinates(Coordinates.of(xml.getCoordinates().getX(), xml.getCoordinates().getY()));
        return dto;
    }

    public CreateStarship map(StarShipRequest request) {
        CreateStarship xml = new CreateStarship();
        xml.setName(request.getName());
        xml.setFleet(request.getFleet());

        CoordinatesXml coordinatesXml = new CoordinatesXml();
        coordinatesXml.setX(request.getCoordinates().getX());
        coordinatesXml.setY(request.getCoordinates().getY());

        xml.setCoordinates(coordinatesXml);
        return xml;
    }

}
