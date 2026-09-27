package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "maquinaIpa");
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();

		System.out.println("--------------ESRTADO 1----------------------");

		Maquina negra = new Maquina("Club", "Cerveza buena", 0.03, "maquinaStout");
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();

		System.out.println("--------------ESRTADO 2----------------------");

		Maquina roja = new Maquina("Corona", "Cerveza buena", 0.06, "maquinaRubia" );
		roja.imprimir();
		roja.llenarMaquina();
		roja.imprimir();
	}

}
