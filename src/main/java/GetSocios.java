import java.util.ArrayList;

public class GetSocios {

    private Persistencia persistencia;

    public GetSocios(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public ArrayList<Socio> getsocio() {
        return persistencia.socios;
    }
}
