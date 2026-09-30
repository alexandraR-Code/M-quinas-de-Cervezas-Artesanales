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
	// Recibe los datos de la cerveza, genera un codigo, crea la maquina
	// y la guarda en el atributo maquinas (la lista del negocio)
	public void agregarMaquina(String nombreCerveza, String descripcion, double precioPorML) {
		// Genera el codigo aleatorio invocando el metodo
		String codigoGenerado = generarCodigo();
		// crea el una nuevaMaquina yla agrega a maquina con todos los datos
		Maquina nuevaMaquina = new Maquina(nombreCerveza, descripcion, precioPorML, codigoGenerado);
		// Agrega la maquina a la lista
		maquinas.add(nuevaMaquina);
	}
	// Metodo cargarMaquinas

	public void cargarMaquinas() {
		// Recorre la lista 'maquinas' con un for (desde 0 hasta size()-1)
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			// y llena cada maquina invocando a su metodo llenarMaquina()
			m.llenarMaquina();
		}
	}

}
