package com.arep.services;


import java.util.Date;

import com.arep.model.Mensaje;
import com.google.gson.Gson;


/**
 * Clase encargada de ofrecer los servicios http 
 * @author SebastianPaez
 *
 */
public class ServicesHttp {
	
	private DataBase db;
	
	/**
	 * Crea una nueva instancia de la base de datos
	 */
	public ServicesHttp() {
		db = new DataBase();
	}
	
	/**
	 * Da una lista de los mensajes de la base de datos en formato JSON
	 * @return La lista de animales
	 */
	public String getMensajes() {
		return db.getMensajes();
	}
	
	/**
	 * Añade un mensaje dado su cadena en formato JSON
	 * @param jsonString Es la mensaje en formato strinJson a agregar a la base de datos.
	 */
	public void addMensaje(String jsonString) {
		Gson g = new Gson(); 
		Mensaje mensaje = g.fromJson(jsonString, Mensaje.class);
		Date fecha = new Date();
		mensaje.setFecha(fecha.toString());
		System.out.println("Conversión del strinJson a objeto: \n" + mensaje.toString());
		db.addMensaje(mensaje);
	}	
	
}
