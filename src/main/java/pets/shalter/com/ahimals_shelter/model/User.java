package pets.shalter.com.ahimals_shelter.model;

import jakarta.persistence.*;
/**
 * Класс, представляющий пользователя системы.
 * Он содержит информацию о пользователе, такой как номер чата, имя и email.
 * @params id, name, chatId, contact
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatId;

    private String name;

    private String contact;

    public User() {}
    public User(Long chatId, String name, String contact) {
        this.chatId = chatId;
        this.name = name;
        this.contact = contact;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
