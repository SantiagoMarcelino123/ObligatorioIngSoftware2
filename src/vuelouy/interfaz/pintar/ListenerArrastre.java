package vuelouy.interfaz.pintar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ListenerArrastre implements MouseMotionListener
{
    /** Clase encargada de hacer algo con el arrastre del rat�n */
    private InterfaceArrastrarRaton accion;

    /** Construye una instancia de esta clase y se guarda la accion que se le
     * pasa.
     * @param accion Clase a la que se ir� avisando del arrastre del rat�n.
     */
    public ListenerArrastre(InterfaceArrastrarRaton accion)
    {
        this.accion = accion;
    }

    /** Si actualmente se est� arrastrando o no el rat�n */
    boolean arrastrando = false;

    /** x del rat�n antes de producirse el �ltimo arrastre */
    int xAntigua;

    /** y del rat�n antes de producirse el �ltimo arrastre */
    int yAntigua;

    /**
     * Se mueve el rat�n sin arrastre. Se marca como que no se est� arrastrando
     */
    public void mouseMoved(MouseEvent e){
        if (arrastrando == true){
            accion.finalizaArrastra(xAntigua, yAntigua);
        }
        arrastrando = false;
        xAntigua = e.getX();
        yAntigua = e.getY();
    }

    /**
     * Se est� arrastrando el rat�n. Se avisa a la accion correspondiente y
     * se actualizan todas las coordenadas.
     */
    public void mouseDragged(MouseEvent e)
    {
        if (arrastrando == false)
        {
            accion.comienzaArrastra(e.getX(), e.getY());
            arrastrando = true;
        }
        accion.arrastra(xAntigua, yAntigua, e.getX(), e.getY());
        xAntigua = e.getX();
        yAntigua = e.getY();
    }

    /**
     * Permite cambiar la acci�n a realizar cuando se arrastre el rat�n.
     * @param accion La nueva acci�n a realizar.
     */
    public void setAccion(InterfaceArrastrarRaton accion)
    {
        this.accion = accion;
    }

}
