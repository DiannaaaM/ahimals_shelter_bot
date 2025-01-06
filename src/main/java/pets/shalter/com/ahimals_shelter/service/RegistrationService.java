package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Сервис для управления регистрацией пользователей в системе.
 *
 * Этот сервис отвечает за начало и обработку процессов регистрации,
 * а также за проверку статуса регистрации пользователя по его идентификатору чата.
 */
@Service
public class RegistrationService {

    private Set<Long> registrations = new HashSet<>();
    private Set<User> registeredUsers = new HashSet<>();

    /**
     * Начинает процесс регистрации для указанного идентификатора чата.
     *
     * @param chatId уникальный идентификатор чата, для которого начинается регистрация.
     */
    public void startRegistration(Long chatId) {
        if (!registrations.contains(chatId)) {
            registrations.add(chatId);
            sendMessage(chatId, "Регистрация начата. Пожалуйста, введите ваше имя и email, разделенные запятой.");
        } else {
            sendMessage(chatId, "Вы уже находитесь в процессе регистрации.");
        }
    }

    /**
     * Обрабатывает данные регистрации, переданные пользователем.
     *
     * @param chatId уникальный идентификатор чата, для которого обрабатываются данные.
     * @param messageText текст сообщения, содержащий данные для регистрации.
     */
    public void processRegistration(Long chatId, String messageText) {
        if (registrations.contains(chatId)) {
            String[] parts = messageText.split(",");
            if (parts.length == 2) {
                String name = parts[0].trim();
                String email = parts[1].trim();

                User newUser = new User(chatId, name, email);
                registeredUsers.add(newUser);

                completeRegistration(chatId);

                sendMessage(chatId, "Регистрация успешно завершена! Добро пожаловать, " + name + "!");
            } else {
                sendMessage(chatId, "Пожалуйста, введите корректные данные в формате: имя, email.");
            }
        } else {
            sendMessage(chatId, "Вы не находитесь в процессе регистрации. Пожалуйста, начните регистрацию.");
        }
    }

    /**
     * Проверяет, находится ли указанный идентификатор чата в процессе регистрации.
     *
     * @param chatId уникальный идентификатор чата.
     * @return true, если идентификатор чата находится в процессе регистрации, иначе false.
     */
    public boolean isInRegistration(Long chatId) {
        return registrations.contains(chatId);
    }

    /**
     * Завершает процесс регистрации для указанного идентификатора чата.
     *
     * @param chatId уникальный идентификатор чата, для которого завершается регистрация.
     */
    public void completeRegistration(Long chatId) {
        if (registrations.remove(chatId)) {
            sendMessage(chatId, "Ваш процесс регистрации был завершен.");
        }
    }

    /**
     * Метод для отправки сообщения пользователю.
     *
     * @param chatId уникальный идентификатор чата, куда будет отправлено сообщение.
     * @param message текст сообщения для отправки.
     */
    private void sendMessage(Long chatId, String message) {
        System.out.println("Отправка сообщения в чат " + chatId + ": " + message);
    }
}
