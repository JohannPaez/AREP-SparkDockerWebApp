package com.arep;


import static spark.Spark.*;

import com.arep.services.ServicesHttp;


public class SparkWebServer {

	public static void main(String... args) {
		ServicesHttp servicesHttp = new ServicesHttp();
		port(getPort());
		staticFiles.location("/public");
		get("hello", (req, res) -> "Hello Docker!");
		get("/mensajes", (req, res) -> {
			return servicesHttp.getMensajes();
		});
		post("/addMensaje", (request, response) -> {
			String body = request.body();
			System.out.println("BODY \n" + body);
			servicesHttp.addMensaje(body);
			return "El mensaje ha sido agregado con exito!";
		});
		
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}

}