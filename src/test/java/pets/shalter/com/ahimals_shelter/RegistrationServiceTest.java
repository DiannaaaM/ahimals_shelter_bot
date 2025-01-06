package pets.shalter.com.ahimals_shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pets.shalter.com.ahimals_shelter.service.RegistrationService;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        registrationService = new RegistrationService();
    }

    @Test
    void testStartRegistration() {
        Long chatId = 1L;

        registrationService.startRegistration(chatId);

        assertTrue(registrationService.isInRegistration(chatId), "Registration should be in progress.");
    }

    @Test
    void testProcessRegistrationValidData() {
        Long chatId = 1L;
        String messageText = "John Doe,johndoe@example.com";

        registrationService.startRegistration(chatId);
        registrationService.processRegistration(chatId, messageText);

        assertFalse(registrationService.isInRegistration(chatId), "Registration should not be in progress after completion.");
    }

    @Test
    void testProcessRegistrationInvalidData() {
        Long chatId = 1L;
        String messageText = "InvalidData";

        registrationService.startRegistration(chatId);
        registrationService.processRegistration(chatId, messageText);

        assertTrue(registrationService.isInRegistration(chatId), "Registration should still be in progress for invalid data.");
    }

    @Test
    void testCompleteRegistration() {
        Long chatId = 1L;

        registrationService.startRegistration(chatId);
        registrationService.completeRegistration(chatId);

        assertFalse(registrationService.isInRegistration(chatId), "Registration should be completed.");
    }

    @Test
    void testStartRegistrationAlreadyInProgress() {
        Long chatId = 1L;

        registrationService.startRegistration(chatId);
        registrationService.startRegistration(chatId); // Should not change anything

        assertTrue(registrationService.isInRegistration(chatId), "Registration should still be in progress.");
    }
}
