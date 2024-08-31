package Dominio;

import java.util.ArrayList;

public class GetSocios {

    private GestorDeSocios gestor;

    public GetSocios(GestorDeSocios gestor) {
        this.gestor = gestor;
    }

    public ArrayList<Socio> getsocio() {
        return gestor.socios;
    }
}
