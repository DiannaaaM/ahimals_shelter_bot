package pets.shalter.com.ahimals_shelter.repository;

import pets.shalter.com.ahimals_shelter.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByPetId(Long petId);
    Report save(Report report);

}