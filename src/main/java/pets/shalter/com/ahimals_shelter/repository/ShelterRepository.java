package pets.shalter.com.ahimals_shelter.repository;

import pets.shalter.com.ahimals_shelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    Optional<Shelter> findByName(String name);
    Shelter findById(long id);
}