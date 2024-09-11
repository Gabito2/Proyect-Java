package Dominio;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

public class Instancia {
    private GestorDeSocios gestor;
    private Persistencia persistencia;
    private static GestorDeSocios gs;

    public Instancia(GestorDeSocios gestor, Persistencia persistencia) {
        this.gestor = gestor;
        this.persistencia = persistencia;
    }

    public static GestorDeSocios getInstancia() {
        if (gs == null) gs = new GestorDeSocios();
        return getInstancia();
    }
}
