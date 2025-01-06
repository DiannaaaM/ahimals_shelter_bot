package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.*;
import pets.shalter.com.ahimals_shelter.model.Pet;
import pets.shalter.com.ahimals_shelter.service.PetService;

import java.util.List;

/**
 * Контроллер для управления животными в системе.
 *
 * Этот контроллер обрабатывает HTTP-запросы для добавления новых животных и получения информации
 * о животных по типу.
 */
@RestController
@RequestMapping("/api/pets")
public class PetController {
    private PetService petService = new PetService();

    /**
     * Обрабатывает добавление нового животного в систему.
     *
     * @param pet объект животного, который необходимо добавить.
     */
    public void handlePet(Pet pet) {
        petService.addPet(pet);
    }

    /**
     * Создает нового питомца на основе переданных данных.
     *
     * @param pet объект животного, который необходимо создать.
     * @return созданный объект животного.
     */
    @PostMapping
    public Pet createUser(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    /**
     * Получает список животных по указанному типу.
     *
     * @param petType тип животного для фильтрации списка.
     * @return список животных указанного типа.
     */
    @GetMapping
    public List<Pet> getPetType(@RequestParam String petType) {
        return petService.findPet( petType );
    }
}
