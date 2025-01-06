package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.Pet;
import pets.shalter.com.ahimals_shelter.repository.PetRepository;

import java.util.List;

/**
 * Сервис для работы с животными
 *
 * @property PetRepository репозиторий для работы с животными.
 */
@Service
public class PetService {
    private PetRepository petRepository;

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }
    public List<Pet> findPet(String type) {
        return petRepository.findByType(type);
    }
}
