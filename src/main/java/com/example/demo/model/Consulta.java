package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Consulta {
    @NotNull
    private String nomeAnimal;
    @NotNull
    private String especie;
    @NotNull
    private Double valorConsulta;
    @NotNull
    private String nomeVeterinario;

    Consulta(String nomeAnimal, String especie, Double valorConsulta, String nomeVeterinario) {
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.valorConsulta = valorConsulta;
        this.nomeVeterinario = nomeVeterinario;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }
}
