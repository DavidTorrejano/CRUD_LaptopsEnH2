package com.example.AlmacenamientoLaptops.controllers;

import com.example.AlmacenamientoLaptops.entities.Laptop;
import com.example.AlmacenamientoLaptops.repositories.LaptopRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // Atributos
    LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // Lista todas las laptops guardadas
    @Operation(summary = "Obtener todas las laptops en BD")
    @GetMapping("/api/laptops")
    public List<Laptop> buscarTodo (){
        return laptopRepository.findAll();
    }

    // Recupera una laptop por el ID
    @Operation(summary = "Obtener una laptop de la base de datos usando ID")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> buscarPorID (@PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        return laptopOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crea una laptop en DB
    @Operation(summary = "Crear una laptop en BD")
    @PostMapping("/api/laptops")
    public Laptop crearLaptop(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

    // Edita una laptop en DB
    @Operation(summary = "Actualiza la información de una laptop en BD")
    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> editarLaptop (@PathVariable Long id, @RequestBody Laptop laptop){
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        if (laptopOptional.isPresent() && id.equals(laptop.getId())){
            laptopRepository.save(laptop);
            return ResponseEntity.ok(laptopOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Elimina una laptop de DB usando el ID
    @Operation(summary = "Elimina una laptop usando como indicador el ID")
    @DeleteMapping("/api/laptops/{id}")
    public void eliminarLaptop(@PathVariable Long id){
        Optional <Laptop> laptopOptional = laptopRepository.findById(id);
        if (laptopOptional.isPresent()){
            laptopRepository.deleteById(id);
        }
    }

    // Eliminar todas las laptos de DB
    @Operation(summary = "Elimina todas las laptops de BD")
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> eliminarTodo(){
        int laptopCount = laptopRepository.findAll().size();
        if (laptopCount < 1){
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteAll();
        return ResponseEntity.accepted().build();
    }
}
