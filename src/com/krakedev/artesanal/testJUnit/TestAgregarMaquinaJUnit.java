package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaJUnit {

	@Test
	// AgregarMaquina debe guardar maquina en el atributo Maquina

	public void agregarMaquinasLista() {

		// clase que gusrada la lista de maquinas

		NegocioMejorado neg = new NegocioMejorado();
		// Agreegar maquinas con datos distintos
		neg.agregarMaquina("Corona", "Cerveza rubia", 0.03);
		neg.agregarMaquina("Pilsenes", "Cerveza negra", 0.05);

		// verificar que la lista agrego 2 maquinas
		assertEquals(2, neg.getMaquinas().size());
	}
}
