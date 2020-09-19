package com.arep;


import static spark.Spark.*;

import com.arep.services.ServicesHttp;

/**
 * 
 * @author SebastianPaez
 *
 */
public class SparkWebServer {

	
	/**
	 * Ejecuta la aplicación para poder utilizar los servicios
	 * @param args Son los parametros al momento de ejecutar.
	 */
	public static void main(String... args) {
		ServicesHttp servicesHttp = new ServicesHttp();
		port(getPort());	
		get("hello", (req, res) -> "Hello Docker!");
		get("/mensajes", (req, res) -> {
			System.out.println("Peticion get /mensajes");
			return servicesHttp.getMensajes();
		});
		post("/addMensaje", (request, response) -> {
			String body = request.body();
			System.out.println("BODY \n" + body);
			servicesHttp.addMensaje(body);
			return "El mensaje ha sido agregado con exito!";
		});
		
	}

	/**
	 * Funcion que retorna el número del puerto por el cual se correrá el servicio.
	 * @return El número de puerto del servicio.
	 */
	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}

}