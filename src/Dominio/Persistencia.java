package Dominio;

import java.util.ArrayList;

public class Persistencia {
    private GestorDeSocios gestor;

    public Persistencia() {
        this.gestor = gestor;
    }

    private static GestorDeSocios gs;
    public ArrayList<Socio> socios;

    public Persistencia(GestorDeSocios gs) {
        socios = new ArrayList<Socio>();
    }

    public static GestorDeSocios getInstancia() {
        if (gs == null)
            gs = new GestorDeSocios();
        return getInstancia();
    }

}
