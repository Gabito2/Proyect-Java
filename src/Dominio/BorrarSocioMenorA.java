package Dominio;

public class BorrarSocioMenorA {
    private Persistencia persistencia;

    public BorrarSocioMenorA(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void eliminarSociosConEdadMenorA(int edadLimite) {
        persistencia.socios.removeIf(s -> s.getEdad() < edadLimite);
    }

}
