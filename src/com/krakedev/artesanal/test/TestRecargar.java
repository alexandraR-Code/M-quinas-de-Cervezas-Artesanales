package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean resultado;
		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "maquinaIpa");
		System.out.println("--------------------ESTADO INICIAL-------------");
		rubia.imprimir();

		System.out.println("--------------------RECRAGA 1------------------");
		resultado = rubia.recargarCerveza(3000);
		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();
		
		System.out.println("--------------------RECRAGA 2------------------");
		resultado = rubia.recargarCerveza(5000);
		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();
		
		System.out.println("--------------------RECRAGA 3------------------");
		resultado = rubia.recargarCerveza(7000);
		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();
	}

}
