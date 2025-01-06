package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.User;
import pets.shalter.com.ahimals_shelter.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService = new UserService();

    public void handleUser(Long chatId, String name, String contact) {
        User user = new User();
        user.setChatId(chatId);
        user.setName(name);
        user.setContact(contact);
        userService.registerUser(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}
