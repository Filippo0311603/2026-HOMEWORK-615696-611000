package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FabbricaComandiIntrospettivaTest {

    private FabbricaDiComandi factory;

    @BeforeEach
    public void setUp() {
        this.factory = new FabbricaComandiIntrospettiva();
    }

    @Test
    public void testComandoValido() throws Exception{
        Comando c = factory.costruisciComando("vai sud");
        assertEquals("vai", c.getNome());
        assertEquals("sud", c.getParametro());
        assertTrue(c instanceof ComandoVai); 
    }

    @Test
    public void testComandoInesistente()throws Exception {
        
        Comando c = factory.costruisciComando("vola alto");
        assertTrue(c instanceof ComandoNonValido);
    }

    @Test
    public void testComandoVuoto() throws Exception {
        Comando c = factory.costruisciComando("");
        assertTrue(c instanceof ComandoNonValido);
    }
}