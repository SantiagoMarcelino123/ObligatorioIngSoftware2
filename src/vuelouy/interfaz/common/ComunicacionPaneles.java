/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vuelouy.interfaz.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;


public class ComunicacionPaneles extends Observable implements ActionListener{

    /**Variable de la ventana de inicio del pasajero.**/
    private vuelouy.interfaz.common.InicioPasajero ventanaInicioP;
    /**Variable de la ventana de inicio del tripulante.**/
    private vuelouy.interfaz.common.InicioTripulante ventanaInicioT;
    
    /**Nombre del panel a ver.**/
    private String panel;
    /**Idioma en la que se encuentra el sistema.**/
    private String idioma;
    /**Mensaje que se debe mostrar.**/
    private String mensaje;
    /**Bandera que indica si hubo un cambio de idioma.**/
    private boolean bIdioma;
    /**Bandera que indica si se debe mostrar un mensaje.**/
    private boolean bMensaje;
    /**Bandera que idica si se debe cambiar un panel**/
    private boolean bPanel;
    
    /**Timer para la duración de la visibilidad de la VentanaAlerta**/
    private Timer tiempo;
    
    private boolean silencio;

    
    /**
     * Constructor sin paramentros, con valores por defecto.
     */
    public ComunicacionPaneles() {
        this.setPanel("");
        this.setIdioma("español");
        this.setBIdioma(false);
        this.setBPanel(false);
        this.setbMensaje(false);
        this.setSilencio(false);
    }

    /**
     *
     * @return
     */
    public boolean getBPanel() {
        return bPanel;
    }

    /**
     *
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    public boolean getSilencio() {
        return silencio;
    }
    
    /**
     *
     * @return
     */
    public boolean getBIdioma() {
        return bIdioma;
    }
    
    /**
     *
     * @return
     */
    public boolean getBMensaje() {
        return bMensaje;
    }
    
    /**
     *
     * @return
     */
    public String getIdioma() {
        return idioma;
    }
    
    /**
     *
     * @return
     */
    public String getPanel() {
        return panel;
    }
    
     /**
     *
     * @param unBPanel
     */
    public void setBPanel(boolean unBPanel){
        this.bPanel = unBPanel;
        
    }  

    /**
     *
     * @param unPanel
     */
    public void setPanel(String unPanel) {
        panel = unPanel;
    }  

    /**
     *
     * @param unBIdioma
     */
    public void setBIdioma(boolean unBIdioma) {
        bIdioma = unBIdioma;
    }

    public void setSilencio(boolean unSilencio) {
        silencio = unSilencio;
    }
    
    /**
     *
     * @param unBMensaje
     */
    public void setbMensaje(boolean unBMensaje) {
        bMensaje = unBMensaje;
    }

    /**
     *
     * @param unMensaje
     */
    public void setMensaje(String unMensaje) {
        mensaje = unMensaje;
    }

    /**
     *
     * @param unIdioma
     */
    public void setIdioma(String unIdioma) {
        idioma = unIdioma;
    }

    

    /**
     *
     * @param unaVentanaInicioP
     */
    public void setVentanaInicioP(InicioPasajero unaVentanaInicioP) {
        ventanaInicioP = unaVentanaInicioP;
    }

    /**
     *
     * @param unaVentanaInicioT
     */
    public void setVentanaInicioT(InicioTripulante unaVentanaInicioT){
        ventanaInicioT = unaVentanaInicioT;
    }

    /**
     *
     * @return
     */
    public vuelouy.interfaz.common.InicioPasajero getVentanaInicioP(){
        return ventanaInicioP;
    }
    
    /**
     *
     * @return
     */
    public vuelouy.interfaz.common.InicioTripulante getVentanaInicioT() {
        return ventanaInicioT;
    }
    
    public void cambio(String unCambio) {
        if(this.getBIdioma()){
            this.setIdioma(unCambio);
        }else if (this.getBMensaje()) {
            this.setMensaje(unCambio);
            iniciarTimer();
        }else if (this.getBPanel()) {
            this.setPanel(unCambio);
        }
        this.setChanged();
        notifyObservers();
    }
    
    /**
     * Método que inica un el <code>tiempo</code>.
     */
    public void iniciarTimer(){
        tiempo = new Timer(8000, this); // 5 segundos, deberia de pender del tipo de mensaje
        tiempo.start();
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setMensaje("Desaparecer");
        tiempo.stop();
        this.setChanged();
        notifyObservers();
    }
    
   
}