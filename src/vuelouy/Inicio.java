package vuelouy;

import vuelouy.dominio.Viaje;
import vuelouy.interfaz.common.ComunicacionPaneles;
import vuelouy.interfaz.common.InicioPasajero;
import vuelouy.interfaz.common.InicioTripulante;
import vuelouy.interfaz.common.VentanaAlerta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Inicio {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        Viaje v = new Viaje("Montevideo", "Buenos Aires", "Luis Suarez", "1", 2014, 20, 10, 19, 0, 0, 1, 0);
        ComunicacionPaneles com = new ComunicacionPaneles();
        InicioPasajero vent = new InicioPasajero(v, com);
        InicioTripulante vent2 = new InicioTripulante(v, com);
        VentanaAlerta vent3 = new VentanaAlerta(com);
        
        com.setVentanaInicioP(vent);
        com.setVentanaInicioT(vent2);
        
        vent.setVisible(true);
        vent2.setVisible(true);
        
        vent3.setSize(600,400);
        //vent3.setLocale(null);
        vent3.setLocation(100,100);
        vent3.setVisible(false);
        vent3.setAlwaysOnTop(true);
    }

}
