package vuelouy.interfaz.pintar;

/**
 * Trazo que se dibuja en el paint.
 */

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Trazo
{
    /** Color del trazo */
    private Color color = Color.black;

    /** Devuelve el color del trazo */
    public Color getColor()
    {
        return color;
    }

    /** Fija el color para el trazo */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /** Lista de puntos que compone el trazo */
    private LinkedList<Point2D> puntos = new LinkedList<Point2D>();

    /** A�ade un nuevo punto al trazo */
    public void addPunto(Point2D punto)
    {
        puntos.add(punto);
    }

    /** Devuelve la lista de puntos que compone el trazo */
    public LinkedList<Point2D> getPuntos()
    {
        return puntos;
    }

    /** Devuelve cu�ntos puntos componen el trazo */
    public int getNumeroPuntos()
    {
        return puntos.size();
    }

    /** A�ade un nuevo punto al trazo */
    public void addPunto(int x, int y)
    {
        Point2D p = new Point2D.Float(x, y);
        puntos.add(p);
    }

    /** Devuelve el punto de la lista en la posici�n indicada
     * 
     * @param posicion en la lista, entre 0 y getNumeroPuntos()-1
     * @return El punto
     */
    public Point2D getPunto(int posicion)
    {
        return puntos.get(posicion);
    }

    public double dameDistanciaMinima(int x, int y)
    {
        double distancia = dameDistancia(x, y, 0);
        for (int i = 1; i < puntos.size(); i++)
        {
            distancia = Math.min(dameDistancia(x, y, i), distancia);
        }
        return distancia;
    }

    private double dameDistancia(int x, int y, int i)
    {
        return Math.abs(puntos.get(i).getX() - x)
                + Math.abs(puntos.get(i).getY() - y);
    }
}
