package Dominio;

import java.util.ArrayList;

public class GetSocios {

    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public GetSocios(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public ArrayList<Socio> getsocio() {
        return persistencia.socios;
    }
}
