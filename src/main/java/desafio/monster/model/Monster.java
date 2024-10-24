package desafio.monster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Monster {
    // Clave primaria generada automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;

    private String name; // Nombre del monstruo
    private String type; // Tipo de monstruo
    private int scareLevel; // Nivel de susto del monstruo
}
