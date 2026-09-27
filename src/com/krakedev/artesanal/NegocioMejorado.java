package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	// Atributo maquinas del tipo ArrayList

	ArrayList<Maquina> maquinas;

	// Creacion de getter y setter

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	// ConstructorS
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}

	// Metodo generar codigo de manera aleatoria

	public String generarCodigo() {
		int numeroAleatorio = (int) (Math.random() * 100) + 1;

		return "M-" + numeroAleatorio;
	}

}
