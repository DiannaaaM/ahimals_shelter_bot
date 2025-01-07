package pets.shalter.com.ahimals_shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pets.shalter.com.ahimals_shelter.model.Pet;
import pets.shalter.com.ahimals_shelter.repository.PetRepository;
import pets.shalter.com.ahimals_shelter.service.PetService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    @InjectMocks
    private PetService petService;

    @Mock
    private PetRepository petRepository;

    private Pet pet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pet = new Pet();
        pet.setType("Dog");
        pet.setName("Bob");
        pet.setBreed( "beagle" );
    }

    @Test
    void testAddPet() {
        when(petRepository.save(any(Pet.class))).thenReturn(pet);

        Pet createdPet = petService.addPet(pet);

        assertNotNull(createdPet);
        assertEquals(pet.getType(), "Dog");
        assertEquals(pet.getName(), "Bob");
        assertEquals(pet.getBreed(), "beagle");
        verify(petRepository).save(pet);
    }

    @Test
    void testFindPet() {
        when(petRepository.findByType("Dog")).thenReturn(List.of(pet));

        List<Pet> foundPets = petService.findPet("Dog");

        assertNotNull(foundPets);
        assertEquals(1, foundPets.size());
        assertEquals("Dog", foundPets.get(0).getType());
    }
}
