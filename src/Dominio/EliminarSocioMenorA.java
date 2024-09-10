package Dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EliminarSocioMenorA {
    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public EliminarSocioMenorA(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
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
