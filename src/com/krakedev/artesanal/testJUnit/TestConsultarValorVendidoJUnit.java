package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestConsultarValorVendidoJUnit {

	// Punto 19: consultarValorVendido suma lo consumido por TODOS los clientes
	@Test
	public void consultarValorVendidoSumaTodosLosClientes() {
		// 1. Preparar: bar con una maquina llena y dos clientes
		NegocioMejorado neg = new NegocioMejorado();
		neg.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);
		neg.cargarMaquinas();
		neg.registrarCliente("Ana", "1111111111"); // recibe el codigo 100
		neg.registrarCliente("Carlos", "215487484"); // recibe el codigo 101
		String codigoMaquina = neg.getMaquinas().get(0).getCodigo();

		// 2. Actuar: Ana toma 300 ml y Luis toma 200 ml
		neg.consumirCerveza(100, codigoMaquina, 300);
		neg.consumirCerveza(101, codigoMaquina, 450);

		// 3. Verificar: total vendido = 6 + 4 = 10
		assertEquals(15, neg.consultarValorVendido(), 0.001);
	}
}