package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * Класс, представляющий волонтера.
 * Он связывает пользователя с приютом, в котором волонтер работает.
 * @params id, name, telegramUsername
 */
@Component
@Data
@Entity
public class Volunteer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String telegramUsername;
}
