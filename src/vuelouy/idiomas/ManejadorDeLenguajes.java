package vuelouy.idiomas;


/**
 * Created by smarcelino on 11/20/16.
 */
public final class ManejadorDeLenguajes {
    private Idioma idiomaActual;
    private static ManejadorDeLenguajes miManejador;

    public static ManejadorDeLenguajes getInstancia() {
        if (miManejador == null) {
            miManejador = new ManejadorDeLenguajes();
        }
        return miManejador;
    }

    private ManejadorDeLenguajes() {

    }

    public void setLenguajeActual(String idioma) {
        if (miManejador == null) {
            miManejador = new ManejadorDeLenguajes();
        }
        switch (idioma) {
            case "español":
                miManejador.idiomaActual = new Espaniol();
                break;
            case "ingles":
                miManejador.idiomaActual = new Ingles();
                break;
            case "italiano":
                miManejador.idiomaActual = new Italiano();
                break;
        }
    }

    public Idioma getIdiomaActual() {
        return miManejador.idiomaActual;
    }
}
