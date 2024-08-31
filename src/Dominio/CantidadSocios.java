package Dominio;

public class CantidadSocios {

    private GestorDeSocios gestor;

    public CantidadSocios(GestorDeSocios g) {
        gestor = g;
    }

    public int getCantidadDeSocios() {
        return gestor.socios.size();
    }

}
