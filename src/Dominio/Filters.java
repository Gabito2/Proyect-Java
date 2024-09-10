package Dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class  Filters {

    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public Filters(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public ArrayList<Socio> getSociosPorGenero(gestor.Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador) {
        return persistencia.socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

}
