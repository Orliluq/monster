package desafio.monster.service;

import desafio.monster.dto.MonsterDTO;
import desafio.monster.model.Monster;
import desafio.monster.repository.MonsterRepository;
import desafio.monster.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonsterService {

    private final MonsterRepository monsterRepository;

    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    // Convertir Monster a MonsterDTO
    private MonsterDTO convertToDTO(Monster monster) {
        MonsterDTO dto = new MonsterDTO();
        dto.setId(monster.getId());
        dto.setName(monster.getName());
        dto.setType(monster.getType());
        dto.setScareLevel(monster.getScareLevel());
        return dto;
    }

    // Convertir MonsterDTO a Monster
    private Monster convertToEntity(MonsterDTO dto) {
        Monster monster = new Monster();
        monster.setId(dto.getId());
        monster.setName(dto.getName());
        monster.setType(dto.getType());
        monster.setScareLevel(dto.getScareLevel());
        return monster;
    }

    // Obtener todos los monstruos
    public List<MonsterDTO> getAllMonsters() {
        return monsterRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener un monstruo por ID
    public MonsterDTO getMonsterById(Long id) {
        Monster monster = monsterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found with id " + id));
        return convertToDTO(monster);
    }

    // Crear un nuevo monstruo
    public MonsterDTO createMonster(MonsterDTO monsterDTO) {
        validateInput(monsterDTO);
        Monster monster = convertToEntity(monsterDTO);
        Monster savedMonster = monsterRepository.save(monster);
        return convertToDTO(savedMonster);
    }

    // Actualizar un monstruo existente
    public MonsterDTO updateMonster(Long id, MonsterDTO monsterDTO) {
        // Verificar si el monstruo existe
        Monster existingMonster = monsterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found with id " + id));

        // Actualizar los campos del monstruo existente
        existingMonster.setName(monsterDTO.getName());
        existingMonster.setType(monsterDTO.getType());
        existingMonster.setScareLevel(monsterDTO.getScareLevel());

        // Guardar el monstruo actualizado y devolver el DTO
        Monster updatedMonster = monsterRepository.save(existingMonster);
        return convertToDTO(updatedMonster);
    }

    // Eliminar un monstruo
    public void deleteMonster(Long id) {
        Optional<Monster> monster = monsterRepository.findById(id);
        if (monster.isPresent()) {
            monsterRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Monster not found with id " + id);
        }
    }

    // Validar la entrada del DTO
    private void validateInput(MonsterDTO monsterDTO) {
        if (monsterDTO.getName() == null || monsterDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Monster name is required");
        }
        if (monsterDTO.getType() == null || monsterDTO.getType().isEmpty()) {
            throw new IllegalArgumentException("Monster type is required");
        }
        if (monsterDTO.getScareLevel() <= 0) {
            throw new IllegalArgumentException("Scare level must be greater than zero");
        }
    }
}