package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Volunteer;
import pets.shalter.com.ahimals_shelter.service.VolunteerService;

/**
 * Контроллер для управления волонтерами системы.
 *
 * Этот контроллер обрабатывает HTTP-запросы для регистрации новых волонтеров в системе.
 */
@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {
    private VolunteerService volunteerService = new VolunteerService();

    /**
     * Обрабатывает добавление нового волонтера в систему.
     *
     * @param volunteer объект волонтера, который необходимо зарегистрировать.
     */
    public void handleVolunteer(Volunteer volunteer) {
        volunteerService.registerVolunteer(volunteer);
    }

    /**
     * Регистрирует нового волонтера на основе переданных данных.
     *
     * @param volunteer объект волонтера, который необходимо создать.
     * @return созданный объект волонтера.
     */
    @PostMapping
    public Volunteer createUser(@RequestBody Volunteer volunteer) {
        return volunteerService.registerVolunteer(volunteer);
    }
}
