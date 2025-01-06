package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Volunteer;
import pets.shalter.com.ahimals_shelter.service.VolunteerService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {
    private VolunteerService volunteerService = new VolunteerService();

    public void handleVolunteer(Volunteer volunteer) {
        volunteerService.registerVolunteer(volunteer);
    }

    @PostMapping
    public Volunteer createUser(@RequestBody Volunteer volunteer ) {
        return volunteerService.registerVolunteer(volunteer);
    }
}
