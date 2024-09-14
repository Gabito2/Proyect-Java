public class CantidadSocios {

    private Persistencia persistencia;

    public CantidadSocios(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public int getCantidadDeSocios() {
        return persistencia.socios.size();
    }

}
