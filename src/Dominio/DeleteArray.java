package Dominio;

public class DeleteArray {

    private Persistencia persistencia;

    public DeleteArray(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void LimpiarTodo() {
        persistencia.socios.clear();
    }

}
