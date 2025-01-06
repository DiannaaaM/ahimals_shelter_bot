package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * Класс, представляющий отчет о состоянии животного в приюте.
 *
 * Этот класс содержит информацию о животных, относящуюся к их рациону, состоянию и
 * изменениям в поведении. Отчеты создаются пользователями или волонтерами для
 * мониторинга здоровья и благополучия животных в приюте.
 * @params petId, photo, diet, conditions, behaviorChanges, userId, reviewed
 */
@Component
@Data
@Entity
public class Report {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long petId;
    private String photo;
    private String diet;
    private String condition;
    private String behaviorChanges;
    private String userId;
    private boolean reviewed;

}
