package Dominio;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EliminarSocioMenorA {
    private Persistencia persistencia;

    public EliminarSocioMenorA(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void eliminarSociosConEdadMenorA(Predicate<Socio> predicado) {
        ArrayList<Socio> salida = persistencia.socios.stream().filter(predicado)
                .collect(Collectors.toCollection(ArrayList<Socio>::new));
        for (Socio socio : salida) {
            persistencia.socios.remove(socio);
        }
    }

}
