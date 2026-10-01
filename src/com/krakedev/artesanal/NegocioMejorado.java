package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	// Atributo: lista (ArrayList) donde el negocio guarda TODAS sus maquinas.
	// Es la evolucion de Negocio, que solo tenia una maquina (maquinaA)
	ArrayList<Maquina> maquinas;

	// Atributo: lista donde el negocio guarda los clientes registrados.
	private ArrayList<Cliente> clientes = new ArrayList<>();
	// Guarda el ultimo numero del cliente
	private int ultimoCodigo = 100;

	// Getter y setter del atributo maquinas (encapsulamiento)
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	// Constructor: crea la lista vacia UNA sola vez al crear el negocio.
	// Si no se inicializa, la lista seria null y el primer add daria
	// NullPointerException
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}

	// Metodo generarCodigo: no recibe parametros y retorna un codigo tipo "M-25".
	// Math.random() da 0 a 0.99 -> *100 da 0 a 99.9 -> (int) corta a 0..99 -> +1 da
	// 1..100
	public String generarCodigo() {
		int numeroAleatorio = (int) (Math.random() * 100) + 1;
		return "M-" + numeroAleatorio;
	}

	// Metodo agregarMaquina: recibe los datos de la cerveza, genera un codigo
	// y agrega la maquina a la lista SOLO si ese codigo no existe (validacion de
	// duplicados).
	// Retorna true si la agrego y false si el codigo ya estaba en uso
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorML) {
		// 1. Genera el codigo aleatorio invocando a generarCodigo
		String codigoGenerado = generarCodigo();
		// 2. Reutiliza recuperarMaquina para saber si ya hay una maquina con ese codigo
		// (si retorna null, el codigo esta libre)
		Maquina existente = recuperarMaquina(codigoGenerado);
		// 3. Para preguntar por null se usa == (no .equals: null no tiene metodos)
		if (existente == null) {
			// Codigo libre: recien ahora se crea la maquina (solo si se va a usar)
			Maquina nuevaMaquina = new Maquina(nombreCerveza, descripcion, precioPorML, codigoGenerado);
			// Se guarda en el atributo maquinas y se confirma con true
			maquinas.add(nuevaMaquina);
			return true;
		} else {
			// Codigo repetido: no se crea ni se agrega, se avisa con false
			return false;
		}
	}

	// Metodo cargarMaquinas: llena TODAS las maquinas del negocio.
	// Recorre la lista con un for (desde 0 hasta size()-1) y a cada maquina
	// le invoca su metodo llenarMaquina()
	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			// Toma la maquina de la posicion i
			Maquina m = maquinas.get(i);
			// Le pide que se llene (cantidadActual = capacidadMaxima - 200)
			m.llenarMaquina();
		}
	}

	// Metodo recuperarMaquina (busqueda lineal): recibe un codigo y busca la
	// maquina.
	// Retorna la maquina que tiene ese codigo, o null si ninguna lo tiene
	public Maquina recuperarMaquina(String codigo) {
		// Recorre la lista revisando una por una
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			// Compara el codigo de la maquina con el recibido (String -> .equals)
			if (m.getCodigo().equals(codigo)) {
				// La encontro: la retorna en ese momento y el metodo termina
				return m;
			}
		}
		// Termino el for sin encontrarla: el return null va FUERA del for
		return null;
	}

	// Metodo registarCliente
	public void registrarCliente(String nombre, String cedula) {
		// Generar el codigo consecutivo y aumneta en 1
		int codigo = ultimoCodigo++;
		// Crear la instancia de cliente
		Cliente nuevoCliente = new Cliente(nombre, cedula);
		// Asignar objeto a la lista
		nuevoCliente.setCodigo(codigo);
		clientes.add(nuevoCliente);

	}

	// Metodo buscarClientePorCedula
	public Cliente buscarClientePorCedula(String cedula) {
		// Recibe una cedula y retorna el Cliente que la tiene, o null si no existe
		// Recorrer las lista clientes
		for (int i = 0; i < clientes.size(); i++) {
			// Tomo a cliente en la posicion i
			Cliente c = clientes.get(i);
			// Si la cedula de ese cliente es igual a la cedula recibida retorna cliente
			if (c.getCedula().equals(cedula)) {
				return c;
			}

		}
		return null;

	}

	// Metodo buscarClientePorCodigo
	public Cliente buscarClientePorCodigo(int codigo) {
		// recibe el codigo y retorna el cliente o null si no existe
		// recorre la lista
		for (int i = 0; i < clientes.size(); i++) {
			// Toma cliente en la posicion i
			Cliente c = clientes.get(i);
			// Si el codigo es igual al recibido retorna cliente
			if (c.getCodigo() == codigo) {
				return c;
			}
		}
		return null;
	}

	// Metodo consumirCerveza
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		// Buscar maquina invocando a recuperarMaquina
		Maquina m = recuperarMaquina(codigoMaquina);
		// Busca el cliente reutilizando buscarClientePorCodigo
		Cliente c = buscarClientePorCodigo(codigoCliente);
		// La maquina encontrada (m) sirve la cantidad y se guarda el valor que retorna
		double valorConsumido = m.servirCerveza(cantidad);
		// Registra el consumo: suma el valor a la cuenta del cliente
		registrarConsumo(c, valorConsumido);

	}

	// Metodo registrarConsumo: suma el valor al totalConsumido del cliente.
	// ACUMULA (no reemplaza): lo que ya debia + el valor nuevo
	public void registrarConsumo(Cliente cliente, double valor) {
		cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);

	}

}