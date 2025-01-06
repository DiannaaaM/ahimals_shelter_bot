package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.*;
import pets.shalter.com.ahimals_shelter.model.Pet;
import pets.shalter.com.ahimals_shelter.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private PetService petService = new PetService();

    public void handlePet(Pet pet) {
        petService.addPet(pet);
    }

    @PostMapping
    public Pet createUser(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @GetMapping
    public List<Pet> getPetType(@RequestParam String petType) {
        return petService.findPet( petType );
    }
}
