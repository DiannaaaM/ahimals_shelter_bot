package pets.shalter.com.ahimals_shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pets.shalter.com.ahimals_shelter.controller.PetController;
import pets.shalter.com.ahimals_shelter.model.Pet;
import pets.shalter.com.ahimals_shelter.service.PetService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetControllerTest {

    @InjectMocks
    private PetController petController;

    @Mock
    private PetService petService;

    private Pet pet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pet = new Pet();
        pet.setAge("1 year");
        pet.setName("Tyzik");
    }

    @Test
    void testCreateUser() {
        when(petService.addPet(any(Pet.class))).thenReturn(pet);

        Pet createdPet = petController.createUser(pet);

        assertNotNull(createdPet);
        assertEquals(pet.getAge(), "1 year");
        assertEquals(pet.getName(), "Tyzik");
        verify(petService).addPet(pet);
    }

    @Test
    void testGetPetType() {
        when(petService.findPet("Dog")).thenReturn(List.of(pet));

        List<Pet> foundPets = petController.getPetType("Dog");

        assertNotNull(foundPets);
        assertEquals(1, foundPets.size());
    }
}
