package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.Shelter;
import pets.shalter.com.ahimals_shelter.repository.ShelterRepository;

/**
 * Сервис для работы с приютами.
 *
 * @property ShelterRepository репозиторий для работы с приютами.
 */
@Service
public class ShelterService {
    private ShelterRepository shelterRepository;

    public Shelter addShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

}