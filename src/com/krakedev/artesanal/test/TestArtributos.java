package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestArtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "Cerveza runia", 0.02, 10.000, "maquinaIpa");
		rubia.imprimir();

		rubia.setDescripcion("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma mas intenso");
		rubia.imprimir();

	}

}
