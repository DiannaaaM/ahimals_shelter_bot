package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.User;
import pets.shalter.com.ahimals_shelter.service.UserService;

/**
 * Контроллер для управления пользователями системы.
 *
 * Этот контроллер обрабатывает HTTP-запросы для регистрации новых пользователей в системе.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService = new UserService();

    /**
     * Обрабатывает добавление нового пользователя в систему.
     *
     * @param chatId уникальный идентификатор чата для пользователя.
     * @param name имя пользователя.
     * @param contact контактная информация пользователя.
     */
    public void handleUser(Long chatId, String name, String contact) {
        User user = new User();
        user.setChatId(chatId);
        user.setName(name);
        user.setContact(contact);
        userService.registerUser(user);
    }

    /**
     * Регистрирует нового пользователя на основе переданных данных.
     *
     * @param user объект пользователя, который необходимо создать.
     * @return созданный объект пользователя.
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
