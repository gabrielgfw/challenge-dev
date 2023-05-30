package com.example.demo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Veterinario {
    @NotNull
    private String nomeVeterinario;
    @NotNull
    private Double valorTotalConsultas;
    @NotNull
    @Valid
    private List<Consulta> consultas;

    public Veterinario(String nomeVeterinario, Double valorTotalConsultas, List<Consulta> consultas) {
        this.nomeVeterinario = nomeVeterinario;
        this.valorTotalConsultas = valorTotalConsultas;
        this.consultas = consultas;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public Double getValorTotalConsultas() {
        return valorTotalConsultas;
    }

    public void setValorTotalConsultas(Double valorTotalConsultas) {
        this.valorTotalConsultas = valorTotalConsultas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
