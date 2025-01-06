package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * Класс, представляющий животное в приюте.
 * Он содержит информацию о животном, такую как имя, тип, возраст и порода.
 * @params id, name, type, breed, age
 */
@Component
@Data
@Entity
public class Pet {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String breed;
    private String age;

}
