package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * Класс, представляющий приют для животных.
 * Он содержит информацию о приюте, такую как имя, контакты и адрес.
 * @params id, name, location, schedule, contactDetails
 */
@Component
@Data
@Entity
public class Shelter {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String schedule;
    private String contactDetails;
}
