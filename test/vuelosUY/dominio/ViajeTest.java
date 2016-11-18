package vuelosUY.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vuelouy.dominio.Pedido;
import vuelouy.dominio.Viaje;
import java.util.Calendar;
import static java.util.Calendar.getInstance;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alumnoFI
 */
public class ViajeTest {
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Viaje viaje1;
    private Pedido pedido;
    /**
     *
     */
        public ViajeTest() {
        }
    
    /**
     *
     */
        @Before
    public void setUp() {
        viaje1 = new Viaje("Montevideo", "Buenos Aires", "Camila", "11", 2014, 10, 20, 11, 0, 0, 2, 30);
        pedido = new Pedido("11", "Whisky");
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.

    // The methods must be annotated with annotation @Test.

    /**
     *
     */
        @Test
    public void testAccesorOrigen() {
        assertEquals(viaje1.getOrigen(), "Montevideo");
        assertNotSame(viaje1.getOrigen(), "MONTEVIDEO");
        assertNotSame(viaje1.getOrigen(), "montevideo");
    }
    
    /**
     *
     */
        @Test
    public void testAccesorAsiento() {
        assertEquals(viaje1.getAsiento(), "11");
        assertNotSame(viaje1.getAsiento(), 11);
    }
    
    /**
     *
     */
        @Test
    public void testAccesorDestimo() {
        assertEquals(viaje1.getDestino(), "Buenos Aires");
        assertNotSame(viaje1.getDestino(), "buenos aires");
        assertNotSame(viaje1.getDestino(), "BuenosAires");
        assertNotSame(viaje1.getDestino(), "Buenos aires");
        assertNotSame(viaje1.getDestino(), "BUENOS AIRES");
    }
    
    /**
     *
     */
        @Test
    public void testAccesorNombrePasajero() {
        assertEquals(viaje1.getNombrePasajero(), "Luis Suarez");
        assertNotSame(viaje1.getNombrePasajero(), "Luis Suarez");
        assertNotSame(viaje1.getNombrePasajero(), "Luis Suarez");
    }
    
    /**
     *
     */
    @Test
    public void testLapsoRestante(){
        Calendar fechaActual = getInstance();
        fechaActual.set(2014, 10, 20, 12, 0, 0); //hora 12
        viaje1.setHoraViajeActual(fechaActual);
        // Falta 1 hora y media de viaje
        // Hora 13:30 el arribo
        assertEquals("1:30:00", viaje1.lapsoRestanteViaje());
        
        fechaActual.set(2014, 10, 20, 15, 0, 0); //Hora 15
        viaje1.setHoraViajeActual(fechaActual);
        // El vuelo se atrazo por 1 hora y media
        // Hora 13:30 el arribo
        assertEquals("-1:-30:00", viaje1.lapsoRestanteViaje());
        
        fechaActual.set(2014, 10, 20, 13, 30, 0); 
        viaje1.setHoraViajeActual(fechaActual);
        // El vuelo arribo en ese preciso momento
        // Hora 13:30 el arribo
        assertEquals("0:00:00", viaje1.lapsoRestanteViaje());
        
        fechaActual.set(2014, 10, 19, 13, 29, 40);
        viaje1.setHoraViajeActual(fechaActual);
        assertEquals("0:00:20", viaje1.lapsoRestanteViaje());
    }
    
    /**
     *
     */
    @Test
    public void testRestarFechas(){
        Calendar fecha1 = getInstance();
        Calendar fecha2 = getInstance();
        fecha1.set(2014, 10, 20, 12, 0, 0); //hora 12
        fecha2.set(2014, 10, 20, 14, 0, 0); //hora 14
        assertEquals(7200, viaje1.restarFechas(fecha1, fecha2));
        
        fecha1.set(2014, 10, 19, 23, 0, 0);
        fecha2.set(2014, 10, 20, 1, 0, 20);
        assertEquals(7220, viaje1.restarFechas(fecha1, fecha2));
    }
 
    /**
     *
     */
    @Test
    public void testPedidoRealizado(){
        
        viaje1.agregarPedido(pedido);
        viaje1.pedidoRealizado(0);
        
        if (viaje1.getListaPedidos().contains(pedido)) {
            assert true;
        }
    }
    
    /**
     *
     */
    @Test
    public void testPedidoAgregado(){
        
        viaje1.agregarPedido(pedido);
        
        assertEquals(pedido, viaje1.getListaPedidos().get(0));
    }
}
