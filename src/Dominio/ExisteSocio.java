package Dominio;

import java.util.function.Predicate;

public class ExisteSocio {
    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public ExisteSocio(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public boolean existeSocioConNombre(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).findFirst().isPresent();
    }

}
