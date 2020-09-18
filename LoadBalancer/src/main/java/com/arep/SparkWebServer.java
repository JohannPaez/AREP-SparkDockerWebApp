package com.arep;


import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;



public class SparkWebServer {
	
	private static HttpClient httpClient = new HttpClient();

	public static void main(String... args) {
		port(getPort());
		staticFiles.location("/public");
		get("hello", (req, res) -> "Hello Docker!");
		get("/mensajes", (req, res) -> {
			String response = httpClient.getMensajes("/mensajes");
			httpClient.roundRobin();
			return response;
		});
		post("/addMensaje", (req, res) -> {
			String response = httpClient.postMensajes(req.body(),"/addMensaje");
			httpClient.roundRobin();
			return response;
		});
		
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}

}