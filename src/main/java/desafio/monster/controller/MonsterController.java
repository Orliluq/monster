package desafio.monster.controller;

import desafio.monster.dto.MonsterDTO;
import desafio.monster.exception.ResourceNotFoundException;
import desafio.monster.service.MonsterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public ResponseEntity<List<MonsterDTO>> getAllMonsters() {
        List<MonsterDTO> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonsterDTO> getMonsterById(@PathVariable Long id) {
        try {
            MonsterDTO monster = monsterService.getMonsterById(id);
            return ResponseEntity.ok(monster);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MonsterDTO> createMonster(@RequestBody @Valid MonsterDTO monsterDTO) {
        try {
            MonsterDTO createdMonster = monsterService.createMonster(monsterDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMonster);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonsterDTO> updateMonster(@PathVariable Long id, @RequestBody @Valid MonsterDTO monsterDTO) {
        try {
            MonsterDTO updatedMonster = monsterService.updateMonster(id, monsterDTO);
            return ResponseEntity.ok(updatedMonster);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable Long id) {
        try {
            monsterService.deleteMonster(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}