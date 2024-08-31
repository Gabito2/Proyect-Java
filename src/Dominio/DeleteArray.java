package Dominio;

public class DeleteArray {

    private GestorDeSocios gestor;

    public DeleteArray(GestorDeSocios gestor) {
        this.gestor = gestor;
    }

    public void LimpiarTodo() {
        gestor.socios.clear();
    }

}
