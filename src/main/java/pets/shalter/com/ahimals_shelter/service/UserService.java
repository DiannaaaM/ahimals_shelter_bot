package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.User;
import pets.shalter.com.ahimals_shelter.repository.UserRepository;

/**
 * Сервис для работы с пользователями.
 *
 * @property userRepository репозиторий для работы с пользователями.
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

}
