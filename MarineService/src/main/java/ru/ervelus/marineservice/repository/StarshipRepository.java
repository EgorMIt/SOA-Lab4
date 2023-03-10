package ru.ervelus.marineservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egormit.library.StarShip;

/**
 * Репозиторий доступа к сущности {@link StarShip}.
 *
 * @author Egor Mitrofanov.
 */
public interface StarshipRepository extends JpaRepository<StarShip, Long> {

}
