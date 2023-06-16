package com.example.AlmacenamientoLaptops.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Laptop{

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricante;
    private String modelo;
    private String procesador;
    private Integer memoriaRamGB;
    private Integer almacenamientoGB;
    private LocalDate fechaDeFabricado;


    // Constructores

    public Laptop() {}

    public Laptop(String fabricante, String modelo, String procesador,
                  Integer memoriaRamGB, Integer almacenamientoGB, LocalDate fechaDeFabricado) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.procesador = procesador;
        this.memoriaRamGB = memoriaRamGB;
        this.almacenamientoGB = almacenamientoGB;
        this.fechaDeFabricado = fechaDeFabricado;
    }


    // Getters y Setters

    public Long getId(){
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getMemoriaRamGB() {
        return memoriaRamGB;
    }

    public void setMemoriaRamGB(Integer memoriaRam) {
        this.memoriaRamGB = memoriaRam;
    }

    public Integer getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(Integer almacenamiento) {
        this.almacenamientoGB = almacenamiento;
    }

    public LocalDate getFechaDeFabricado() {
        return fechaDeFabricado;
    }

    public void setFechaDeFabricado(LocalDate fechaDeFabricado) {
        this.fechaDeFabricado = fechaDeFabricado;
    }
}
