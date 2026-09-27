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

	// Metodo AgregarMaquina
	// Recibe los datos de la cerveza, genera un codigo y lo guarda en una lista y la devulve
	public ArrayList<Maquina> agregarMaquina(String nombreCerveza, String descripcion, double precioPorML) {
		// Inicializa una lista vacia de maquina
		ArrayList<Maquina> listaMaquina = new ArrayList<Maquina>();
		// Genera el codigo aleatorio invocando el metodo
		String codigoGenerado = generarCodigo();
		// crea el objeto maquina con todos los datos
		Maquina nuevaMaquina = new Maquina(nombreCerveza, descripcion, precioPorML, codigoGenerado);
		// Agrega la maquina a la lista
		listaMaquina.add(nuevaMaquina);
		// Retorna la lista con el objeto guardado
		return listaMaquina;
	}

}
