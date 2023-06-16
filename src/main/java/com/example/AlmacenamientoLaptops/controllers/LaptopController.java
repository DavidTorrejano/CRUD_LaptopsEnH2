package com.example.AlmacenamientoLaptops.controllers;

import com.example.AlmacenamientoLaptops.entities.Laptop;
import com.example.AlmacenamientoLaptops.repositories.LaptopRepository;
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
    @GetMapping("/api/laptops")
    public List<Laptop> buscarTodo (){
        return laptopRepository.findAll();
    }

    // Recupera una laptop por el ID
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> buscarPorID (@PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        return laptopOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crea una laptop en DB
    @PostMapping("/api/laptops")
    public Laptop guardarLaptop (@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

    // Edita una laptop en DB
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
    @DeleteMapping("/api/laptops/{id}")
    public void eliminarLaptop(@PathVariable Long id){
        Optional <Laptop> laptopOptional = laptopRepository.findById(id);
        if (laptopOptional.isPresent()){
            laptopRepository.deleteById(id);
        }
    }
}
