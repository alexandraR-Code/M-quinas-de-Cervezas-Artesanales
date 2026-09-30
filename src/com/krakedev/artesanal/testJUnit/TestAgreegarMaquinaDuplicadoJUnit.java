package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgreegarMaquinaDuplicadoJUnit {

	@Test
	public void agregarMaquinaretornaTrue() {
		// vacio
		NegocioMejorado neg = new NegocioMejorado();
		// Agregae una maquina y guardar lo que respona (true o false)
		boolean resultado = neg.agregarMaquina("Club", "Cerveza rubia", 0.03);
		// verificar resultado en este caso true
		assertTrue(resultado);
	}

	@Test
	public void agregarMaquinaRechaza() {
		// vacio
		NegocioMejorado neg = new NegocioMejorado();
		int rechazadas = 0;
		// intentar agregar mas maquina fuera del limite
		for (int i = 0; i < 150; i++) {
			boolean agregada = neg.agregarMaquina("Cerveza" + i, "Cervaza negra", 0.05);
			// Si no la agreaga es false
			if (agregada == false) {
				rechazadas++;
			}
		}
		// verificar
		assertTrue(neg.getMaquinas().size() <= 100);
		assertTrue(rechazadas > 0);
	}
}
