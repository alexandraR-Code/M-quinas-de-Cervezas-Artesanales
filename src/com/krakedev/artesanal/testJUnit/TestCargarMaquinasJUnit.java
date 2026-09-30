package com.krakedev.artesanal.testJUnit;

// Importamos assertEquals y @Test de JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCargarMaquinasJUnit {

	// Punto 5: cargarMaquinas debe llenar TODAS las maquinas de la lista 'maquinas'
	@Test
	public void cargarMaquinas() {

		// 1. PREPARAR: crear el negocio y agregarle dos maquinas.
		// Cada maquina se crea con el constructor de 4 parametros,
		// que le pone capacidadMaxima = 10000 y cantidadActual = 0
		NegocioMejorado neg = new NegocioMejorado();
		neg.agregarMaquina("Corona", "Cerveza rubia", 0.03);
		neg.agregarMaquina("Club", "Cerveza negra", 0.05);

		// 2. ACTUAR: llenar todas las maquinas.
		// El for de cargarMaquinas llama a llenarMaquina() de cada una:
		// cantidadActual = capacidadMaxima - 200 = 10000 - 200 = 9800
		neg.cargarMaquinas();

		// 3. VERIFICAR: cada maquina debe tener 9800 de cantidad actual.
		// OJO: en Java el numero va SIN punto (9.800 seria 9,8)
		// get(0) = primera maquina, get(1) = segunda maquina
		// 0.001 Margen de error porque la cantidad es double
		assertEquals(9800, neg.getMaquinas().get(0).getCapacidadActual(), 0.001); // 👈 antes: 9.800
		assertEquals(9800, neg.getMaquinas().get(1).getCapacidadActual(), 0.001); // 👈 antes: 9.600
	}
}