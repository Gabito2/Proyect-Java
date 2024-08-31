package Dominio;

public class Filters {

    private GestorDeSocios gestor;

     public Filters(GestorDeSocios gestor) {
         this.gestor = gestor;
     }

    public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado) {
        return gestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador) {
        return gestor.socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado) {
        return gestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

}
