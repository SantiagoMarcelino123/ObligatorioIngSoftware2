/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vuelouy.dominio;

/**
 * Controla los pedidos realizados por los
 * pasajeros.
 */
public class Pedido {

    /**Indica el número de asiento del pasajero.**/
    private String asiento;
    /**Indica el pedido realizado por el pasajero.**/
    private String pedido;
    /**Indica si el pedido ya fue entregado alpasajero.**/
    boolean entregado;
    
    /**
     * Constructor de Pedido.
     */
    public Pedido(){
        this.setAsiento("");
        this.setPedido("");
        entregado = false;
    }
    
    /**
     * Constructor de Pedido.
     * @param unAsiento es el asiento del pasajero. 
     * @param unPedido es el pedido realizado por el pasajero
     */
    public Pedido(String unAsiento, String unPedido){
        this.setAsiento(unAsiento);
        this.setPedido(unPedido);
        entregado = false;
    }
    
    /**
     * Método de acceso al número de <code>asiento</code> del pasajero.
     * @return número de asiento.
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Método de modificación del número de asiento del pasajero
     * @param unAsiento nuevo número de asiento.
     */
    public void setAsiento(String unAsiento) {
        asiento = unAsiento;
    }

    /**
     * Método de acceso.
     * @return pedido realizado
     */
    public String getPedido() {
        return pedido;
    }

    /**
     * Método de modificación de un pedido.
     * @param unPedido dato nuevo a modificar.
     */
    public void setPedido(String unPedido) {
        pedido = unPedido;
    }

    /**
     * Método de consulta del estado de un pedido.
     * @return true si el pedido fue entregado, false sino.
     */
    public boolean estaEntregado() {
        return entregado;
    }

    /**
     * Método de modificación para indicar que se ha 
     * entregado el pedido al pasajero.
     */
    public void entregado() {
        entregado = true;
    }
    
    /**
     * Método de impresión de los datos del pedido.
     * @return 
     */
    @Override
    public String toString(){
        return "Numero de asiento: " + this.getAsiento() + ", " + "Pedido: " + this.getPedido();
    }
}
