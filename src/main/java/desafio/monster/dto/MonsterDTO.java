package desafio.monster.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MonsterDTO {

    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Type cannot be null")
    @Size(min = 3, max = 20, message = "Type must be between 3 and 20 characters")
    private String type;

    @NotNull(message = "Scare level cannot be null")
    private int scareLevel;

}