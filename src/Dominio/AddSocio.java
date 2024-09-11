package Dominio;

import java.util.ArrayList;

public class AddSocio {

    private GestorDeSocios gestor;
    private Persistencia persistencia;
    public AddSocio(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public boolean verificacionSocio(Socio socio) {
        if (persistencia.socios.contains(socio))
            return true;
        return false;
    }

    public void agregarSocio(Socio socio) {
        if (!verificacionSocio(socio))
            persistencia.socios.add(socio);
    }
}
