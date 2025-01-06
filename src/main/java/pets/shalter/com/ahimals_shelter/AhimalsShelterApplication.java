package pets.shalter.com.ahimals_shelter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class AhimalsShelterApplication {

    public static void main(String[] args) {
        SpringApplication.run( AhimalsShelterApplication.class, args );
    }

}
