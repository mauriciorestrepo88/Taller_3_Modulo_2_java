package com.capacitacion.excepciones.personalizadas;

public class ExcepcionesPersonalizadas extends Exception {
	private String causa;
	private String tipoFalla;

	public ExcepcionesPersonalizadas(String causa, String tipoFalla) {
		super();
		this.causa = "El archivo no existe o está vacío ";
		this.tipoFalla = "Falla al procesar el archivo";

	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getTipoFalla() {
		return tipoFalla;
	}

	public void setTipoFalla(String tipoFalla) {
		this.tipoFalla = tipoFalla;
	}

}
