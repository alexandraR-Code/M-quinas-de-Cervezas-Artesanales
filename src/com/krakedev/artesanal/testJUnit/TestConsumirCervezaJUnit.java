package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumirCervezaJUnit {
	@Test
	public void consumirCervezaActualizaClienteYMaquina() {
		// Crear negocioMejorado
		NegocioMejorado neg = new NegocioMejorado();
		// Agregar una maquina
		neg.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);
		// Llenar la maquina
		neg.cargarMaquinas();
		// Registarr al cliente
		neg.registrarCliente("Astrid", "1048850135");
		// verificr el codigo que genero
		String codigoMaquina = neg.getMaquinas().get(0).getCodigo();
		// Consumo de Astrid
		neg.consumirCerveza(100, codigoMaquina, 300);
		// verificar e cliente actualixado
		assertEquals(6, neg.buscarClientePorCodigo(100).getTotalConsumido(), 0.001);
		// verificar Maqina afectada
		assertEquals(9500, neg.recuperarMaquina(codigoMaquina).getCapacidadActual());
	}

}
