package ru.egormit.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.egormit.library.enums.AstartesCategory;
import ru.egormit.library.enums.MeleeWeapon;
import ru.egormit.library.enums.Weapon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.ZonedDateTime;

/**
 * Модель Space Marine.
 *
 * @author Egor Mitrofanov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineUpdateRequest {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Имя.
     */
    private String name;

    /**
     * Координаты.
     */
    private Coordinates coordinates;

    /**
     * Дата создания.
     */
    private ZonedDateTime creationDate;

    /**
     * Количество здоровья.
     */
    private Long health;

    /**
     * Класс персонажа.
     */
    private AstartesCategory category;

    /**
     * Тип оружия.
     */
    private Weapon weaponType;

    /**
     * Тип оружия ближнего боя.
     */
    private MeleeWeapon meleeWeapon;

    /**
     * Корабль.
     */
    private Long starShipId;

}
