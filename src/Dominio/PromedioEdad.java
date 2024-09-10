package Dominio;

public class PromedioEdad {

    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public PromedioEdad(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public double getPromedioEdad() {
        int suma = 0;
        for (Socio socio : persistencia.socios) {
            suma = suma + socio.getEdad();
        }
        return suma / persistencia.socios.size();
    }

}
