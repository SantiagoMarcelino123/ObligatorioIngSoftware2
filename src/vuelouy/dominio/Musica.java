/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vuelouy.dominio;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;

/**
 * 
 * @author 
 */
public class Musica {

    /**Variable que maneja los archivos de audio.**/
    private AudioClip cancion;
    /**Bandera qeu indica si se esta reproduciendo una pista**/
    private boolean reproduciendo;
    /**Lista de rutas de las cacniones**/
    private String[] listaMusicas = {"/vuelouy/sonidos/wav1.wav",
                                     "/vuelouy/sonidos/wav2.wav",
                                     "/vuelouy/sonidos/wav3.wav"};
    /**Numero de pista que se sesta reproduciendo**/
    private int posActual;
    
    /**
     * Constructor de la clase
     */
    public Musica() {
        this.setReproduciendo(false);
        this.setCancion(this.getListaMusicas()[0]);
        this.setPosActual(0);
    }

    /**
     *
     * @return la lista de rutas de canciones.
     */
    public String[] getListaMusicas() {
        return listaMusicas;
    }

    /**
     *
     * @return el numero de pista que se esta reproduciendo. (0 = primero)
     */
    public int getPosActual() {
        return posActual;
    }
    
    /**
     * Se cambia el numero de la cancion que se reproduce
     * @param unaPosActual es la nueva cancion
     */
    public void setPosActual(int unaPosActual) {
        posActual = unaPosActual;
    }

    /**
     *
     * @return el manejador de la pista de audio
     */
    public AudioClip getCancion() {
        return cancion;
    }

    /**
     * Se crea una nueva cancion
     * @param ruta es la direccion donde se encuentra la nueva cancion
     */
    public void setCancion(String ruta) {
        cancion = newAudioClip(getClass().getResource(ruta));
    }

    /**
     *
     * @return <code>true</code> si se esta reproduciendo
     */
    public boolean estaReproduciendo() {
        return reproduciendo;
    }
    
    private void setReproduciendo(boolean b){
        reproduciendo = b;
    }
    
    /**
     * Inicia la cancion
     */
    public void reproducir(){
        cancion.play();
        setReproduciendo(true);
    }

    /**
     * Para la cancion
     */
    public void parar(){
        cancion.stop();
        setReproduciendo(false);
    }
    
    /**
     * Pasa a la siguiente cancion
     */
    public void siguiente(){
        if (this.estaReproduciendo()) {
            parar();
        }

            this.setPosActual(this.getPosActual() + 1);
            this.setCancion(this.getListaMusicas()[this.getPosActual()]);

    }
    
    /**
     * Retrocede a la cancion anterior
     */
    public void anterior(){
        if (this.estaReproduciendo()) {
            parar();
        }
        if ( (this.getPosActual() - 1) < 0){
            this.setPosActual(this.getListaMusicas().length - 1);
            this.setCancion(this.getListaMusicas()[this.getPosActual()]);
        } else {
            this.setPosActual(this.getPosActual() - 1);
            this.setCancion(this.getListaMusicas()[this.getPosActual()]);
        }
    }
    
}
