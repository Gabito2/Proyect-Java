package Dominio;

import java.util.ArrayList;

public class Persistencia {
    private GestorDeSocios gestor;

    public Persistencia() {
        this.gestor = gestor;
    }

    public ArrayList<Socio> socios;

    public Persistencia(GestorDeSocios gs) {
        socios = new ArrayList<Socio>();
    }

}
