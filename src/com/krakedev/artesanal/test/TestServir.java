package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "maquinaIpa");

		System.out.println("----------------ESTADO ACTUAL-----------------");
		rubia.imprimir();

		System.out.println("---------------LENADO DE MAQUINA--------------");
		rubia.llenarMaquina();
		rubia.imprimir();

		System.out.println("---------------SERVIR 1000 ML --------------");
		double valor;
		valor = rubia.servirCerveza(1000);
		System.out.println("Valor a pagar: " + valor);

		System.out.println("---------------SERVIR 1000 ML --------------");
		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagra: " + valor);
		rubia.imprimir();
		
		System.out.println("---------------SERVIR 6000 ML---------------");
		valor = rubia.servirCerveza(6000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();

	}

}
