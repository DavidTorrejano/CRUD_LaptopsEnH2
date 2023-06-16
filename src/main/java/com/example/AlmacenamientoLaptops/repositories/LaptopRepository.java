package com.example.AlmacenamientoLaptops.repositories;

import com.example.AlmacenamientoLaptops.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
