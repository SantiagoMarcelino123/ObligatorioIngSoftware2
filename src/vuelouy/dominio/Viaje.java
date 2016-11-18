/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelouy.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.getInstance;

/**
 * Método qeu controla y matiene los datos 
 * aserca del viaje en avión.
 * 
 */
public class Viaje {
    
    /** Origen del viaje.**/
    private String origen;
    /** Destino del viaje.**/
    private String destino;
    /** Dato que almacena la fecha de partida del viaje.**/
    private Calendar fechaPartida;
    /** Dato que almacena la fecha de arribo del viaje.**/
    private Calendar fechaArribo;
    /** Dato que almacena la lista de pedidos pendientes realizados durante el viaje.**/
    private final ArrayList<Pedido> listaPedidos;
    /** Dato que almacena el nombre del pasajero al que le pertenece el sistema.**/
    private String nombrePasajero;
    /** Dato que almacena número de asiento donde se encuentra el ssistema alojado.**/
    private String asiento;
    
    private Calendar horaViajeActual;

    
    
    private Calendar duracion;

    /**
     * Constructor por defecto
     */
    public Viaje() {
        this.setOrigen("");
        this.setDestino("");
        this.setAsiento("");
        this.setNombrePasajero("");
        listaPedidos = new ArrayList<>();

        Calendar partida = getInstance();
        partida.set(0, 0, 0, 0, 0, 0);
        Calendar arribo = getInstance();
        arribo.set(0, 0, 0, 0, 0, 0);

        this.setFechaPartida(partida);
        this.setFechaArribo(arribo);
        this.setHoraViajeActual(partida);
    }

    
    public Viaje (String origen, String destino, String nombrePasajero,
            String asiento, int anioPartida, int mesPartida, int diaPartida,
            int horaPartida, int minPartida, int segPartida, int horaViaje,
            int minutosViaje) {
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setAsiento(asiento);
        this.setNombrePasajero(nombrePasajero);
        listaPedidos = new ArrayList<>();

        Calendar partida = getInstance();
        partida.set(anioPartida, mesPartida,
                diaPartida, horaPartida, minPartida, segPartida);
        Calendar horaActual = getInstance();
        horaActual.set(anioPartida, mesPartida,
                diaPartida, horaPartida, minPartida, segPartida);
        Calendar arribo = getInstance();
        arribo.set(anioPartida, mesPartida, diaPartida, horaPartida + horaViaje,
                minPartida + minutosViaje, segPartida);

        this.setFechaPartida(partida);
        this.setFechaArribo(arribo);
        this.setHoraViajeActual(horaActual);
        
        Calendar duracionViaje = getInstance();
        duracionViaje.set(Calendar.MINUTE, minutosViaje);
        duracionViaje.set(Calendar.HOUR_OF_DAY, horaViaje);
        
        this.setDuracion(duracionViaje);
    }

    public Calendar getHoraViajeActual() {
        return horaViajeActual;
    }

    public void setHoraViajeActual(Calendar unaHoraViajeActual) {
        horaViajeActual = unaHoraViajeActual;
    }
    
    /**
     * Método de acceso al nombre del pasajero del viaje.
     * @return nombre del pasajero
     */
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    /**
     * Método de modificación del nombre del pasajero.
     * @param unNombrePasajero nuevo nombre del pasajero.
     */
    public void setNombrePasajero(String unNombrePasajero) {
        nombrePasajero = unNombrePasajero;
    }

    /**
     * Método de acceso al número de <code>asiento</code> del pasajero.
     * @return número de asiento
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Método de modificación del número de <code>asiento</code>.
     * @param unAsiento nuevo número de asiento
     */
    public void setAsiento(String unAsiento) {
        asiento = unAsiento;
    }

    /**
     * Método para agrergar un nuevo pedido a la <code>listaPedidos</code>.
     * @param unPedido pedido nuevo.
     */
    public void agregarPedido(Pedido unPedido) {
        listaPedidos.add(unPedido);
    }

    /**
     * Método de acceso a la <code>listaPedidos</code> del viaje.
     * @return la lista de pedidos.
     */
    public ArrayList getListaPedidos() {
        return listaPedidos;
    }

    /**
     * Método de acceso al <code>origen</code> del viaje
     * @return 
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Método de modificación de el <code>origen</code> del viaje.
     * @param unOrigen nuevo origen
     */
    public void setOrigen(String unOrigen) {
        origen = unOrigen;
    }

    /**
     * Método de acceso al <code>destino</code> del viaje.
     * @return
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Método de modificación del <code>destino</code> del viaje.
     * @param unDestino nuevo destino.
     */
    public void setDestino(String unDestino) {
        this.destino = unDestino;
    }

    /**
     * Método de acceso de la <code>fechaPartida</code> del viaje.
     * @return fecha de partida del viaje.
     */
    public Calendar getFechaPartida() {
        return fechaPartida;
    }
    
    /**
     * Método de modificación de la <code>fechaPartida</code> del viaje.
     * @param unaFechaPartida nueva fecha de partida.
     */
    public void setFechaPartida(Calendar unaFechaPartida) {
        fechaPartida = unaFechaPartida;
    }

    public Calendar getDuracion() {
        return duracion;
    }
    
    public void setDuracion(Calendar unaDuracion) {
        duracion = unaDuracion;
    }
    
    /**
     * Método de acceso de a la <code>fechaArribo</code> del viaje.
     * @return fecha de arribo del viaje.
     */
    public Calendar getFechaArribo() {
        return fechaArribo;
    }

    /**
     * Método de modificación de la <code>fechaArribo</code> del viaje.
     * @param unaFechaArribo nueva fecha de arribo.
     */
    public void setFechaArribo(Calendar unaFechaArribo) {
        fechaArribo = unaFechaArribo;
    }

    /**
     * Método que elimina de la lista los pedidos que fueron realizados.
     * @param indexPedido lugaar numerico que ocupa un pedido en <code>listaPedidos</code>
     */
    public void pedidoRealizado(int indexPedido) {
        this.getListaPedidos().remove(indexPedido);
    }

    //pos: devuelve la diferencia de fechas en segundos
    /**
     * Método para calcular las ddiferencia entre dos fechas.
     * @param fechaIn fecha inicial.
     * @param fechaFinal fecha final.
     * @return diferencia entre <code>fechaFinal</code> - <code>fechaIn</code> 
     * en segundos.
     */
    public int restarFechas(Calendar fechaIn, Calendar fechaFinal) {
        long inicial = fechaIn.getTime().getTime(); //devuelve fecha en milisegundos
        long fin = fechaFinal.getTime().getTime();
        Long diffEnSegs = (fin - inicial) / 1000; // Resta milisegundos y luego pasa a segundos
        return diffEnSegs.intValue();
    }

    /**
     * Método que calcula lo que resta del viaje.   
     */
    public String lapsoRestanteViaje() {
        int diffTotalSegs = this.restarFechas(this.getHoraViajeActual(), this.getFechaArribo());
        int diffDias = diffTotalSegs / (60 * 60 * 24);
        int diffHoras = diffTotalSegs / (60 * 60) - (diffDias * 24);
        int diffMinutos = (diffTotalSegs / 60) - ((diffDias * 24 + diffHoras) * 60);
        int diffSegs = diffTotalSegs - ((diffDias * 24 * 60 + diffHoras * 60) + diffMinutos) * 60;
        String diferencia = "";

        if (diffMinutos < 10 && diffMinutos >= 0 && diffSegs < 10 && diffSegs >= 0) {
            diferencia = diffHoras + ":" + "0" + diffMinutos + ":" + "0" + diffSegs;
        } else {
            if (diffMinutos < 10 && diffMinutos >= 0) {
                diferencia = diffHoras + ":" + "0" + diffMinutos + ":" + diffSegs;
            }
            if (diffSegs < 10 && diffSegs >= 0) {
                diferencia = diffHoras + ":" + diffMinutos + ":" + "0" + diffSegs;
            }
        }

        if (diffMinutos > 9 && diffSegs > 9) {
            diferencia = diffHoras + ":" + diffMinutos + ":" + diffSegs;
        }

        return diferencia;
    }
}
