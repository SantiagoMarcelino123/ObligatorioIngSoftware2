package vuelosUY.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vuelouy.dominio.Pedido;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pablo
 */
public class PedidoTest {

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

    private Pedido pedido;

    /**
     *
     */
    public PedidoTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
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
    public void testAccesoresAsiento() {
        assertEquals(pedido.getAsiento(), "11");
    }
    
    /**
     *
     */
    @Test
    public void testAccesoresPedido() {
        assertEquals(pedido.getPedido(), "Whisky");
        assertNotSame(pedido.getPedido(), "whisky");
        assertNotSame(pedido.getPedido(), "WHISKY");
    }
    
    /**
     *
     */
    @Test
    public void testEstaEntregado() {
        assertEquals(pedido.estaEntregado(), false);
    }
    
}
