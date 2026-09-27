package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenararCodigoJUnit {

	@Test

	public void testGenerarCodigo() {
		NegocioMejorado neg = new NegocioMejorado();
		// Ejecutamos el metodo varias veces
		for (int i = 0; i < 500; i++) {
			String codigo = neg.generarCodigo();

			// Verificar que no sea null y inicie con "M-"
			assertNotNull(codigo);
			assertTrue(codigo.startsWith("M-"), "El codigo debe empezar con 'M-'");

			// Extraer el número eliminando el prefijo "M-"
			String numeroStr = codigo.substring(2);
			int numero = Integer.parseInt(numeroStr);

			// Verificar que el entero este entre 1 - 100

			assertTrue(numero >= 1 && numero <= 100,
					"El numero  " + numero + "esta fuera del rango permitido (1-100)");
		}

	}

}