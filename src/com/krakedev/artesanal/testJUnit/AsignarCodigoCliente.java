package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class AsignarCodigoCliente {
	@Test
	public void asignarCodigo() {
		
		Negocio barDeMoe = new Negocio();
		
		Cliente mario = new Cliente("Mario", "123654789");
		Cliente ana = new Cliente("Ana", "154789645");
		
		
		barDeMoe.asignarCodigoCliente(mario);
		barDeMoe.asignarCodigoCliente(ana);
		
		assertEquals(100, mario.getCodigo());
		assertEquals(101, ana.getCodigo());
	}

}
