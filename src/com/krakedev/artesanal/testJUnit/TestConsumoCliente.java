package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {
	@Test
	public void probarConsumo() {
		Maquina maquinaA = new Maquina("Pilsener", "Rubia", 0.002, 8000, "1254664");
		Negocio barDeMoe = new Negocio("Bar de Moe", maquinaA);
		Cliente cliente = new Cliente("Juan", "12367954");
		
		barDeMoe.cargarMaquina();
		barDeMoe.consumirCervezaMaquinaA(cliente, 100);
		assertEquals(7700.0, maquinaA.getCapacidadActual(),0.001);
		assertEquals(0.2, cliente.getTotalConsumido());
		
		barDeMoe.consumirCervezaMaquinaA(cliente, 200);
		assertEquals(7500.0, maquinaA.getCapacidadActual());
		assertEquals(0.6, cliente.getTotalConsumido(), 0.001);
		
	}

}
