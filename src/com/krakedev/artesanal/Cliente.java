package com.krakedev.artesanal;

public class Cliente {
	
	/*Atributos*/
	private String nombre; 
	private String cedula;
	private int codigo;
	private double totalConsumido;
	
	/*Metodos getter y setter*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getTotalConsumido() {
		return totalConsumido;
	}
	public void setTotalConsumido(double totalConsumido) {
		this.totalConsumido = totalConsumido;
	}
	
	/*Constructor*/
	
	public Cliente(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}

}
