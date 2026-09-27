package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecaragaExitosa() {
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "maquinaIpa");
		boolean resulatdo = rubia.recargarCerveza(3000);
		assertTrue(resulatdo);
		assertEquals(3000, rubia.getCapacidadActual(), 0.0001);
	}

	@Test
	public void testRecargaFallidaPorDesborde() {
	    Maquina negra = new Maquina("Club", "Cerveza fria", 0.03, 8000, "maquinaStout");
	    negra.recargarCerveza(7000);
	    boolean resultado = negra.recargarCerveza(2000); // 7000+2000=9000 > 8000 → debe fallar
	    assertFalse(resultado);
	    assertEquals(7000, negra.getCapacidadActual(), 0.0001); // se mantiene el valor anterior
	}
}
