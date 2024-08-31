package Dominio;

public class DeleteSocio {

    private GestorDeSocios gestor;

    public DeleteSocio(GestorDeSocios gestor) {
        this.gestor = gestor;
    }

    public boolean existeSocio(int nroSocio) {
        return gestor.socios.stream().filter(s -> s.getNroSocio() == nroSocio).findAny().isPresent();
    }

    public boolean eliminarSocio(int nroSocio) {
        if (existeSocio(nroSocio)) {
            Socio socio = gestor.socios.stream().filter(s -> s.getNroSocio() - nroSocio == 0).findFirst().get();
        }
        return false;
    }

}
