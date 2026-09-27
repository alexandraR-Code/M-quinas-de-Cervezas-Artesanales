package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test

	public void testLlenarMaquina() {

		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "maquinaIpa");

		rubia.llenarMaquina();

		// *<Validacion para controlar el margen de error>*/

		assertEquals(7800, rubia.getCapacidadActual(), 0.0001);
	}

}
