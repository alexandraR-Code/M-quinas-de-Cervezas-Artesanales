package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestReecuperarMaquinaJUnit {

	@Test
	public void recuperarMaquinaExistente() {
		// Negocio con dos maquinas
		NegocioMejorado neg = new NegocioMejorado();
		neg.agregarMaquina("Club", "Cerveza rubia", 00.3);
		neg.agregarMaquina("Pilser", "Cerveza negra", 00.5);
		// Pregunta a la maquina cual codigo le toco segun su posicion
		String codigo = neg.getMaquinas().get(0).getCodigo();
		String codigo1 = neg.getMaquinas().get(1).getCodigo();
		// Buscar maquina con ese codigo
		Maquina encontrado = neg.recuperarMaquina(codigo);
		Maquina encontrado1 = neg.recuperarMaquina(codigo1);
		// Verificar la maquina encontrada segun su nombre
		assertEquals("Club", encontrado.getNombreCerveza());
		assertEquals("Pilser", encontrado1.getNombreCerveza());
	}

	@Test
	public void reecuperarMaquinaInexistente() {
		// Negocio con do maquinas
		NegocioMejorado neg = new NegocioMejorado();
		neg.agregarMaquina("Club", "Cerveza rubia", 00.3);
		neg.agregarMaquina("Corona", "Cerveza roja", 00.3);
		// Buscra la maquina
		Maquina inexistente = neg.recuperarMaquina("M-0");
		// verificar null
		assertNull(inexistente);

	}

}
