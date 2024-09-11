package Dominio;

public class CantidadSocios {

    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public CantidadSocios(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public int getCantidadDeSocios() {
        return persistencia.socios.size();
    }

}
