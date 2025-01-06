package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.Volunteer;
import pets.shalter.com.ahimals_shelter.repository.VolunteerRepository;

/**
 * Сервис для работы с волонтерами.
 *
 * @property VolunteerRepository репозиторий для работы с волонтерами.
 */
@Service
public class VolunteerService {
    private VolunteerRepository volunteerRepository;

    public Volunteer registerVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }
}
