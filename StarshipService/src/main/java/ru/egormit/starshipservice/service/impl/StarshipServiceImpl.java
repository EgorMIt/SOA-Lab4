package ru.egormit.starshipservice.service.impl;

import com.baeldung.springsoap.gen.GetSpacemarine;
import com.baeldung.springsoap.gen.GetSpacemarineResponse;
import com.baeldung.springsoap.gen.UpdateSpacemarine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import ru.egormit.library.SpaceMarine;
import ru.egormit.library.StarShip;
import ru.egormit.library.StarShipDto;
import ru.egormit.library.StarShipRequest;
import ru.egormit.starshipservice.domain.StarshipRepository;
import ru.egormit.starshipservice.error.ErrorDescriptions;
import ru.egormit.starshipservice.integration.SoapFeignClient;
import ru.egormit.starshipservice.service.StarshipService;
import ru.egormit.starshipservice.utils.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация сервиса работы с starship.
 *
 * @author Egor Mitrofanov.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StarshipServiceImpl implements StarshipService {

    /**
     * {@link SoapFeignClient}.
     */
    private final SoapFeignClient firstService;

    /**
     * {@link StarshipRepository}.
     */
    private final StarshipRepository starshipRepository;

    /**
     * {@link ModelMapper}.
     */
    private final ModelMapper modelMapper;

    /**
     * Создание корабля
     *
     * @param request модель корабля
     */
    @Override
    public void createStarship(StarShipRequest request) {
        StarShip starShip = new StarShip();
        starShip.setName(request.getName());
        starShip.setFleet(request.getFleet());
        starShip.setCoordinateX(request.getCoordinates().getX());
        starShip.setCoordinateY(request.getCoordinates().getY());

        starshipRepository.save(starShip);
    }

    /**
     * Получение списка кораблей
     *
     * @return список всех кораблей
     */
    @Override
    public List<StarShipDto> getAllStarships() {
        return starshipRepository.findAll()
                .stream()
                .map(modelMapper::map)
                .collect(Collectors.toList());
    }

    /**
     * Добавление десантника к кораблю
     *
     * @param spaceMarineId идентификатор десантника
     * @param starShipId    идентификатор корабля
     */
    @Override
    public void addMarineToStarship(Long spaceMarineId, Long starShipId) {
        GetSpacemarine getSpacemarine = new GetSpacemarine();
        getSpacemarine.setId(spaceMarineId);
        GetSpacemarineResponse spaceMarine = firstService.getSpacemarineWithSoap(getSpacemarine);
        ErrorDescriptions.SPACEMACS_IS_BUSY.throwIfFalse(ObjectUtils.isEmpty(spaceMarine.getStarShipId()));

        UpdateSpacemarine request = modelMapper.mapToXml(spaceMarine);

        StarShip starShip = starshipRepository.findById(starShipId)
                .orElseThrow(ErrorDescriptions.STARSHIP_NOT_FOUND::exception);

        request.setStarShip(modelMapper.mapToXml(modelMapper.map(starShip)));
        request.setId(spaceMarineId);

        firstService.updateSpacemarineWithSoap(request);
    }

    /**
     * Выгрузка всех десантников с корабля
     *
     * @param starShipId идентификатор корабля
     */
    @Override
    public void cleanStarship(Long starShipId) {
        StarShip starShip = starshipRepository.findById(starShipId)
                .orElseThrow(ErrorDescriptions.STARSHIP_NOT_FOUND::exception);

        ErrorDescriptions.STARSHIP_IS_EMPTY.throwIfTrue(starShip.getSpaceMarines().isEmpty());

        for (SpaceMarine spaceMarine : starShip.getSpaceMarines()) {
            GetSpacemarine getSpacemarine = new GetSpacemarine();
            getSpacemarine.setId(spaceMarine.getId());
            GetSpacemarineResponse spaceMarineDto = firstService.getSpacemarineWithSoap(getSpacemarine);

            UpdateSpacemarine request = modelMapper.mapToXml(spaceMarineDto);

            request.setStarShip(null);
            request.setId(spaceMarineDto.getId());

            firstService.updateSpacemarineWithSoap(request);
        }
    }

}
