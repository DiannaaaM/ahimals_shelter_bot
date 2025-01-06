package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Shelter;
import pets.shalter.com.ahimals_shelter.service.ShelterService;


@RestController
@RequestMapping("/api/shelters")
public class ShelterController {
    private ShelterService shelterService = new ShelterService();

    public void handleShelter(Shelter shelter) {
        shelterService.addShelter(shelter);
    }

    @PostMapping
    public Shelter createUser(@RequestBody Shelter shelter) {
        return shelterService.addShelter(shelter);
    }
}
