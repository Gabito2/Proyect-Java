package Dominio;

public class BorrarSocioMenorA {
    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public BorrarSocioMenorA(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public void eliminarSociosConEdadMenorA(int edadLimite) {
        persistencia.socios.removeIf(s -> s.getEdad() < edadLimite);
    }

}
