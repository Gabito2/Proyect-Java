package Dominio;

public class DeleteArray {

    private GestorDeSocios gestor;
    private Persistencia persistencia;

    public DeleteArray(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public void LimpiarTodo() {
        persistencia.socios.clear();
    }

}
