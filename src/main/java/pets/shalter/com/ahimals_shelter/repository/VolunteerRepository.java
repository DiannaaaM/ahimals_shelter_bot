package pets.shalter.com.ahimals_shelter.repository;

import pets.shalter.com.ahimals_shelter.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByTelegramUsername(String telegramUsername);
    Volunteer save(Volunteer volunteer);
}