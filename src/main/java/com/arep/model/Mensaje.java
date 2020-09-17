package com.arep.model;

import java.util.Date;

public class Mensaje {
	private String mensaje;
	private String fecha;
	
	public Mensaje(String mensaje, String fecha) {
		setMensaje(mensaje);
		setFecha(fecha);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String toString() {
		return "{\"mensaje\": " + "\"" + mensaje +  "\"" + ", \"fecha\": " + "\"" + fecha  +  "\"" + "}";
	}
}
