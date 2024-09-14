package Dominio;

public class DeleteSocio {

    private Persistencia persistencia;

    public DeleteSocio(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public boolean existeSocio(int nroSocio) {
        return persistencia.socios.stream().filter(s -> s.getNroSocio() == nroSocio).findAny().isPresent();
    }

    public boolean eliminarSocio(int nroSocio) {
        if (existeSocio(nroSocio)) {
            Socio socio = persistencia.socios.stream().filter(s -> s.getNroSocio() - nroSocio == 0).findFirst().get();
        }
        return false;
    }

}
