package vuelouy.interfaz.pintar;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;

public class PintaTrazo implements InterfaceArrastrarRaton
{
    /** Lista de trazos */
    private LinkedList<Trazo> trazos;

    /** Trazo que se est� construyendo actualmente */
    private Trazo trazoActual = null;

    /** Lienzo de dibujo, necesario para llamar a repaint() seg�n se va
     * construyendo un nuevo trazo.
     */
    private Component lienzo;

    /** Color del que se est� dibujando el trazo actual */
    private Color colorActual = Color.black;

    /** Construye una instancia de esta clase, guardandose los par�mtros que
     * le pasan.
     * @param trazos Lista donde ir� metiendo los nuevos trazos que se creen.
     * @param lienzo Llamar� a repaint() de este componente seg�n se va
     * construyendo un trazo.
     */
    public PintaTrazo(LinkedList<Trazo> trazos, Component lienzo)
    {
        this.trazos = trazos;
        this.lienzo = lienzo;
    }

    /**
     * Crea un trazo nuevo y le pone como primer punto x,y.
     */
    public void comienzaArrastra(int x, int y)
    {
        trazoActual = new Trazo();
        trazoActual.setColor(colorActual);
        trazoActual.addPunto(x, y);
        trazos.add(trazoActual);
        lienzo.repaint();
    }

    /** A�ade un nuevo punto al trazo actual */
    public void arrastra(int xAntigua, int yAntigua, int xNueva, int yNueva)
    {
        trazoActual.addPunto(xNueva, yNueva);
        lienzo.repaint();
    }

    /** Marca que ya no hay trazo actual */
    public void finalizaArrastra(int x, int y)
    {
        trazoActual = null;
    }

    /** Guarda el color para el pr�ximo trazo que se dibuje */
    public void setColorActual(Color colorActual)
    {
        this.colorActual = colorActual;
    }
}
