package pets.shalter.com.ahimals_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pets.shalter.com.ahimals_shelter.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByName(String name);
    Pet save(Pet pet);
    List<Pet> findByType(String type);
}