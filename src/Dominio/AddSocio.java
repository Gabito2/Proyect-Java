package Dominio;

import java.util.ArrayList;

public class AddSocio {

    private GestorDeSocios gestor;

    public AddSocio(GestorDeSocios gestor) {
        this.gestor = gestor;
    }

    public boolean verificacionSocio(Socio socio) {
        if (gestor.socios.contains(socio))
            return true;
        return false;
    }

    public void agregarSocio(Socio socio) {
        if (!verificacionSocio(socio))
            gestor.socios.add(socio);
    }
}
