public class PromedioEdad {

    private Persistencia persistencia;

    public PromedioEdad(Persistencia persistencia) {
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
