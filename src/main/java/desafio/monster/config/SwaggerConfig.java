package desafio.monster.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                                .title("Backend Challenge (Java): API de Monstruos")
                                .version("1.0.0")
                                .description("👻 Tema: ¡Desarrolla una API para la gestión de monstruos en una base de datos de criaturas de Halloween! 👻\n" +
                                        "Detalles: El reto consiste en crear una API RESTful utilizando Java. La API debe permitir la creación, lectura, actualización y eliminación de monstruos en una base de datos de criaturas.")
                );
    }
}
