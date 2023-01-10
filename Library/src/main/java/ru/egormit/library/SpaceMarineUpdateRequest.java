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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "dtos"
})
@XmlRootElement(name = "getAllStarships")
public class SpaceMarineUpdateRequest {

    /**
     * Идентификатор.
     */
    @XmlElement(required = true)
    private Long id;

    /**
     * Имя.
     */
    @XmlElement(required = true)
    private String name;

    /**
     * Координаты.
     */
    @XmlElement(required = true)
    private Coordinates coordinates;

    /**
     * Дата создания.
     */
    @XmlElement(required = true)
    private ZonedDateTime creationDate;

    /**
     * Количество здоровья.
     */
    @XmlElement(required = true)
    private Long health;

    /**
     * Класс персонажа.
     */
    @XmlElement(required = true)
    private AstartesCategory category;

    /**
     * Тип оружия.
     */
    @XmlElement(required = true)
    private Weapon weaponType;

    /**
     * Тип оружия ближнего боя.
     */
    @XmlElement(required = true)
    private MeleeWeapon meleeWeapon;

    /**
     * Корабль.
     */
    @XmlElement
    private StarShipDto starShip;

}
