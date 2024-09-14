import java.util.function.Predicate;

public class ExisteSocio {
    private Persistencia persistencia;

    public ExisteSocio(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public boolean existeSocioConNombre(Predicate<Socio> predicado) {
        return persistencia.socios.stream().filter(predicado).findFirst().isPresent();
    }

}
