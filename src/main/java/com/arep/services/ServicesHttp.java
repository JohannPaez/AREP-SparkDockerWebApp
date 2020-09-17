package com.arep.services;

import java.util.Date;
import java.util.HashMap;

import com.arep.model.Mensaje;


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
	 * Da una lista de los animales de la base de datos en formato JSON
	 * @return La lista de animales
	 */
	public String getMensajes() {
		return db.getMensajes();
	}
	
	/**
	 * Añade un animal dado su cadena en formato JSON
	 * @param json Es la cadena
	 */
	public void addMensaje(String json) {
		Mensaje mensaje = convertJsonToMensaje(json);		
		db.addMensaje(mensaje);
	}
	
	/**
	 * Retorna un animal dadas sus caracteristicas en formato json
	 * @param json Es el json a trata
	 * @return Un animal con las caracteristicas dadas
	 */
	private Mensaje convertJsonToMensaje(String json) {
		System.out.println("JSON \n" + json + "\n");
		String sinComillas = json.replace("\"", "");		
		sinComillas = sinComillas.substring(1, sinComillas.length() - 1);
		String[] jsonMensaje = sinComillas.split(",");
		HashMap<String, String> valores = new HashMap<>();
		for (String value: jsonMensaje) {
			String[] dic = value.split(":");
			valores.put(dic[0].trim(), dic[1].trim());
		}
		Date fecha = new Date();
		Mensaje mensaje = new Mensaje(valores.get("mensaje"), fecha.toString());
		System.out.println("FECHA");
		System.out.println(mensaje.toString());
		return mensaje;
	}
	
	
}
