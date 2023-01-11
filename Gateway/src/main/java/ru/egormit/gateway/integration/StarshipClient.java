package ru.egormit.gateway.integration;

import lombok.Setter;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.egormit.gateway.utils.ModelMapper;
import com.baeldung.springsoap.gen.AddMarineToStarship;
import com.baeldung.springsoap.gen.CleanStarship;
import com.baeldung.springsoap.gen.GetAllStarships;
import ru.egormit.library.StarShipDto;
import ru.egormit.library.StarShipRequest;

import java.util.List;
import java.util.stream.Collectors;

public class StarshipClient extends WebServiceGatewaySupport {

    @Setter
    private ModelMapper mapper;

    public void createStarship(StarShipRequest request) {
        getWebServiceTemplate().marshalSendAndReceive(mapper.map(request));
    }

    public List<StarShipDto> getAllStarships() {
        GetAllStarships request = new GetAllStarships();
        GetAllStarships response = (GetAllStarships) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getDtos().stream().map(mapper::map).collect(Collectors.toList());
    }

    public void loadToStarship(Long starShipId, Long spaceMarineId) {
        AddMarineToStarship request = new AddMarineToStarship();
        request.setStarshipId(starShipId);
        request.setSpacemarineId(spaceMarineId);

        getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public void unloadStarship(Long starShipId) {
        CleanStarship request = new CleanStarship();
        request.setId(starShipId);

        getWebServiceTemplate().marshalSendAndReceive(request);
    }

}
