package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

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

    public Report() {}
    public Report(Long petId, String photo, String diet, String condition, String behaviorChanges, String userId) {
        this.petId = petId;
        this.photo = photo;
        this.diet = diet;
        this.condition = condition;
        this.behaviorChanges = behaviorChanges;
        this.userId = userId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public String getBehaviorChanges() {
        return behaviorChanges;
    }

    public void setBehaviorChanges(String behaviorChanges) {
        this.behaviorChanges = behaviorChanges;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
