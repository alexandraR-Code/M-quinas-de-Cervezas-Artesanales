package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

/**
 * Pruebas unitarias para el metodo servirCerveza(double cantidad) de la clase Maquina.
 *
 * Estas pruebas se basan UNICAMENTE en la descripcion funcional del metodo, no en su
 * implementacion interna:
 * - Si hay suficiente cerveza disponible: se resta la cantidad servida de la cantidad
 *   actual y se retorna el valor a pagar (cantidad servida * precio por ML).
 * - Si NO hay suficiente cerveza disponible: no se sirve nada, la cantidad actual no
 *   se modifica y se retorna 0.
 *
 * Se usan los dos constructores disponibles en Maquina y unicamente los metodos
 * publicos existentes en la clase (constructores, getters, recargarCerveza y
 * servirCerveza).
 */
public class TestServirCervezaAI {

	// Tolerancia para comparaciones con valores double
	private static final double DELTA = 0.0001;

	@Test
	public void testServirExitosaConCantidadSuficiente() {
		// Caso: la maquina tiene mas cerveza disponible que la cantidad solicitada.
		// Se espera que el servicio sea exitoso, que se descuente la cantidad de la
		// cantidad actual y que se retorne el valor a pagar (cantidad * precioPorML).
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "maquinaIpa");
		rubia.recargarCerveza(5000); // cantidadActual = 5000

		double valorPagar = rubia.servirCerveza(2000);

		assertEquals(40.0, valorPagar, DELTA); // 2000 * 0.02 = 40.0
		assertEquals(3000, rubia.getCapacidadActual(), DELTA); // 5000 - 2000 = 3000
	}

	@Test
	public void testServirExitosaSirviendoTodaLaCantidadDisponible() {
		// Caso limite: se solicita servir exactamente la cantidad que hay disponible.
		// Debe ser exitoso, dejar la cantidad actual en 0 y retornar el valor a pagar
		// correspondiente a toda la cantidad servida.
		Maquina negra = new Maquina("Club", "Cerveza fria", 0.03, 8000, "maquinaIpa");
		negra.recargarCerveza(1000); // cantidadActual = 1000

		double valorPagar = negra.servirCerveza(1000);

		assertEquals(30.0, valorPagar, DELTA); // 1000 * 0.03 = 30.0
		assertEquals(0, negra.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirFallidaPorCantidadInsuficiente() {
		// Caso: se solicita servir mas cerveza de la que hay disponible.
		// No debe servir nada, la cantidad actual no debe modificarse y debe
		// retornar 0 como valor a pagar.
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "maquinaIpa");
		rubia.recargarCerveza(1000); // cantidadActual = 1000

		double valorPagar = rubia.servirCerveza(1500); // pide mas de lo disponible

		assertEquals(0, valorPagar, DELTA);
		assertEquals(1000, rubia.getCapacidadActual(), DELTA); // no cambia
	}

	@Test
	public void testServirFallidaConMaquinaVacia() {
		// Caso: la maquina no tiene cerveza cargada (cantidadActual = 0, valor por
		// defecto de los constructores). Cualquier solicitud mayor a 0 debe fallar,
		// retornando 0 y sin modificar la cantidad actual.
		Maquina negra = new Maquina("Club", "Cerveza fria", 0.03, 8000, "maquinaIpa");
		// No se recarga la maquina, cantidadActual sigue en 0

		double valorPagar = negra.servirCerveza(500);

		assertEquals(0, valorPagar, DELTA);
		assertEquals(0, negra.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirExitosaUsandoConstructorDeTresParametros() {
		// Caso: se usa el constructor de 3 parametros (capacidad maxima por defecto
		// = 10000). Se recarga la maquina y se sirve una cantidad valida, validando
		// que el calculo del valor a pagar use correctamente el precioPorML definido.
		Maquina artesanal = new Maquina("Golden Ale", "Cerveza artesanal dorada", 0.05, "maquinaIpa");
		artesanal.recargarCerveza(4000); // cantidadActual = 4000

		double valorPagar = artesanal.servirCerveza(1500);

		assertEquals(75.0, valorPagar, DELTA); // 1500 * 0.05 = 75.0
		assertEquals(2500, artesanal.getCapacidadActual(), DELTA); // 4000 - 1500 = 2500
	}

	@Test
	public void testServirCantidadCero() {
		// Caso borde: se solicita servir una cantidad de 0 ML. Como hay suficiente
		// cerveza (cantidadActual >= 0 siempre se cumple si hay algo cargado o no),
		// el servicio "exitoso" no modifica la cantidad actual y el valor a pagar
		// debe ser 0 (0 * precioPorML = 0).
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "maquinaIpa");
		rubia.recargarCerveza(3000); // cantidadActual = 3000

		double valorPagar = rubia.servirCerveza(0);

		assertEquals(0, valorPagar, DELTA);
		assertEquals(3000, rubia.getCapacidadActual(), DELTA); // no cambia
	}

}