package com.example.demo.controller;

import com.example.demo.model.Consulta;
import com.example.demo.model.Veterinario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;

@RestController
public class ConsultaController {

    @PostMapping("/agruparConsultas")
    public Veterinario[] retornarVeterinarios(@RequestBody Consulta[] consultas) {
        ArrayList<Veterinario> consultasAgrupadas = new ArrayList<>();

        for(int i = 0; i < consultas.length; i++) {
            Consulta atual = consultas[i];
            Double valorConsultas = atual.getValorConsulta();
            ArrayList<Consulta> consultasVet = new ArrayList<>();
            Boolean achouPar = false;
            int indexPar = 0;

            // Busca por pares dentro da lista final:
            for(int j = 0; j < consultasAgrupadas.size(); j++) {
                if (Objects.equals(consultasAgrupadas.get(j).getNomeVeterinario(), atual.getNomeVeterinario())) {
                    achouPar = true;
                    indexPar = j;
                    break;
                }
            }

            // Valida se existe já na lista o Veterinário atual
            // assim soma os valores e agrupa as consultas.
            if(achouPar) {
                valorConsultas += consultasAgrupadas.get(indexPar).getValorTotalConsultas();
                ArrayList<Consulta> consultasVetAgrupadas = new ArrayList<>();
                consultasVetAgrupadas.addAll(new ArrayList<>(Arrays.asList(consultasAgrupadas.get(indexPar).getConsultas())));
                consultasVetAgrupadas.add(atual);
                Veterinario vet = new Veterinario(atual.getNomeVeterinario(), valorConsultas, consultasVetAgrupadas.toArray(new Consulta[consultasVetAgrupadas.size()]));
                consultasAgrupadas.set(indexPar, vet);

            // Nova posição única:
            } else {
                consultasVet.add(atual);
                Veterinario vet = new Veterinario(atual.getNomeVeterinario(), valorConsultas, consultasVet.toArray(new Consulta[consultasVet.size()]));
                consultasAgrupadas.add(vet);
            }
        }
        // Parse do ArrayList para Array:
        Veterinario[] listaFinal = consultasAgrupadas.toArray(new Veterinario[consultasAgrupadas.size()]);
        return listaFinal;
    }

}
