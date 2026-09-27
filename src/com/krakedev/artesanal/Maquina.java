package com.krakedev.artesanal;

public class Maquina {

	// *<Atributos encapsulados con el estado private>*//

	private String nombreCerveza;
	private String descripcion;
	private double precioPorML;
	private double capacidadMaxima;
	private double cantidadActual;
	private String codigo;

	/* <Metodos getter y setter > */
	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorML() {
		return precioPorML;
	}

	public void setPrecioPorML(double precioPorML) {
		this.precioPorML = precioPorML;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCapacidadActual() {
		return cantidadActual;
	}

	/* <metodo que permita imprimir el estado actual de la cerveza> */

	public void imprimir() {
		String mensaje;
		mensaje = "Nombre cerveza: " + nombreCerveza + " , Descripción: " + descripcion + " ,  Precio por ML: "
				+ precioPorML + "  , Capacidad máxima: " + capacidadMaxima + " , Cantidad actual: " + cantidadActual
				+ "Código: " + codigo;
		System.out.println(mensaje);
	}
	// *< constructor que es un molde que define que mostrar >*/

	public Maquina(String nombreCerveza, String descripcion, double precioPorML, double capacidadMaxima, String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorML = precioPorML;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	// */<otro constructor el quepuede definir que quiere mostar >*/
	public Maquina(String nombreCerveza, String descripcion, double precioPorML, String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorML = precioPorML;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	// *<metodo para llenar maquina>*/
	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 200;
	}

	// *<validaciones para que la cantidad de cerveza sea la adecuado >*/
	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMaxima - 200;

		if (cantidadActual + cantidad <= limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}

	}
	/*<metodo servir cervexza verifica si la maquina tiene esa cerveza>*/
	
	public double servirCerveza(double cantidad) {
		if(cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			
			double valor;
			valor = cantidad * precioPorML;
			return valor;
		}else {
			return 0;
		}
	}
	
	/*Metodos getter  del atributo codigo*/

	public String getCodigo() {
		return codigo;
	}
	

}
