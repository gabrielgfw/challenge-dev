package com.example.demo.controller;

import com.example.demo.model.Consulta;
import com.example.demo.model.Veterinario;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
public class ConsultaController {

    @PostMapping("/agruparConsultas")
    public List<Veterinario> agruparConsultasPorVeterinario(@Valid @RequestBody List<Consulta> consultas) {
        ArrayList<Veterinario> consultasAgrupadas = new ArrayList<>();

        for(int i = 0; i < consultas.size(); i++) {
            Consulta consultaAtual = consultas.get(i);
            Double valorConsultas = consultaAtual.getValorConsulta();
            ArrayList<Consulta> consultasVeterinario = new ArrayList<>();
            boolean achouPar = false;
            int indexPar = -1;

            // Busca por pares dentro da lista final:
            for(int j = 0; j < consultasAgrupadas.size(); j++) {
                if (Objects.equals(consultasAgrupadas.get(j).getNomeVeterinario(), consultaAtual.getNomeVeterinario())) {
                    achouPar = true;
                    indexPar = j;
                    break;
                }
            }

            // Valida se existe já na lista o Veterinário consultaAtual
            // assim soma os valores e agrupa as consultas.
            if(achouPar) {
                valorConsultas += consultasAgrupadas.get(indexPar).getValorTotalConsultas();
                ArrayList<Consulta> consultasVetAgrupadas = new ArrayList<>();
                consultasVetAgrupadas.addAll(consultasAgrupadas.get(indexPar).getConsultas());
                consultasVetAgrupadas.add(consultaAtual);
                Veterinario veterinarioAtualizado = new Veterinario(consultaAtual.getNomeVeterinario(), valorConsultas, consultasVetAgrupadas);
                consultasAgrupadas.set(indexPar, veterinarioAtualizado);

            // Nova posição única:
            } else {
                consultasVeterinario.add(consultaAtual);
                Veterinario novoVeterinario = new Veterinario(consultaAtual.getNomeVeterinario(), valorConsultas, consultasVeterinario);
                consultasAgrupadas.add(novoVeterinario);
            }
        }
        return consultasAgrupadas;
    }
}
