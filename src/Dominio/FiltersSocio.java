package Dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltersSocio {

    private GestorDeSocios gestor;
    private Persistencia persistencia;
    public FiltersSocio(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador) {
        return persistencia.socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c) {
        return persistencia.socios.stream().filter(p).sorted(c).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<String> getSociosX2(Predicate<Socio> p, Comparator<Socio> c) {
        return persistencia.socios.stream().filter(p).sorted(c).map(s -> s.toString())
                .collect(Collectors.toCollection(ArrayList<String>::new));
    }

    public ArrayList<Integer> getSociosX3(Predicate<Socio> p, Comparator<Socio> c) {
        return persistencia.socios.stream().filter(p).sorted(c).map(s -> s.getNroSocio())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
    }

}
