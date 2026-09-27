package com.krakedev.Test.Negocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*<AL SER UN CONSTRUCTOR VACIO Y OBTENER COMO 
		 * RESULTADO NULL YA QUE EL ATRIBUTO AL QUE QUEREMOS ACCEDER ESTA VACIO
		 *  NOS REFLEJA UN ERROR>*/
		//Negocio negocio1 = new Negocio();		
		//System.out.println("Nombre: " + negocio1.getNombre());
		//System.out.println("Maquina: " + negocio1.getMaquinaA());
		//Maquina m1 = negocio1.getMaquinaA();
		//double capacidad = m1.getCapacidadMaxima();
		
		Maquina nueva = new Maquina("Cerveza Club", "Cerveza fria", 0.02, 8000, "nuevaA");
		
		
		Negocio negocio1 = new Negocio("Mi negocio",nueva);
		
		System.out.println("Nombre: " + negocio1.getNombre());
		System.out.println("Maquina: " + negocio1.getMaquinaA());
		
		
		

	}

}
