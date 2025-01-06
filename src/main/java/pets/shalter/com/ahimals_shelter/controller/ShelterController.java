package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Shelter;
import pets.shalter.com.ahimals_shelter.service.ShelterService;

/**
 * Контроллер для управления приютами для животных.
 *
 * Этот контроллер обрабатывает HTTP-запросы для создания новых приютов в системе.
 */
@RestController
@RequestMapping("/api/shelters")
public class ShelterController {
    private ShelterService shelterService = new ShelterService();

    /**
     * Обрабатывает добавление нового приюта в систему.
     *
     * @param shelter объект приюта, который необходимо создать.
     */
    public void handleShelter(Shelter shelter) {
        shelterService.addShelter(shelter);
    }

    /**
     * Создает новый приют на основе переданных данных.
     *
     * @param shelter объект приюта, который необходимо создать.
     * @return созданный объект приюта.
     */
    @PostMapping
    public Shelter createUser(@RequestBody Shelter shelter) {
        return shelterService.addShelter(shelter);
    }
}
