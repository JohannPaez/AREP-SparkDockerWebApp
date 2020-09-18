package com.arep.services;

import java.util.HashMap;

import org.bson.Document;

import com.arep.model.Mensaje;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * @author SebastianPaez
 *
 */
public class DataBase {
	
	private MongoCollection<org.bson.Document> columnas;
	
	
	/**
	 * Realiza la conexi�n con la base de datos
	 */
	public DataBase() {
		// arep-mongo-db1 localhost
		MongoClientURI uri = new MongoClientURI(
		    "mongodb://najoh2907:Prueba123%40@arep-mongo-db1:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=AREP-DOCKER-01&authMechanism=SCRAM-SHA-256&3t.uriVersion=3&3t.connection.name=AREP-DOCKER-01");		
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("AREP-DOCKER-01");		
		columnas = database.getCollection("Mensajes");
	}
	
 		
	
	public void addMensaje(Mensaje m) {
		HashMap<String, Object> map = new HashMap<>();
		String mensaje = m.getMensaje();
		String fecha = m.getFecha();		
		map.put("Mensaje", mensaje);
		map.put("Fecha", fecha);
		Document registro = new Document(map);
        columnas.insertOne(registro);
	}
	
	
	
	public String getMensajes() {
		String data ="[";
		Mensaje mensaje;
		int cont = 0;
		for (Document d : columnas.find()) {
        	cont++;
        	if (columnas.countDocuments() - cont < 10) {
	        	mensaje = new Mensaje(d.get("Mensaje").toString(), d.get("Fecha").toString());
	        	data += mensaje.toString() + ", ";
        	}
        	
        }
		if (columnas.countDocuments() == 0) data = "[  ";
        data = data.substring(0, data.length() - 2);
        data += "]";
        return data;
	}
	

}
