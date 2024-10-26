package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convertidor {

	private static final String Fecha_Format = "yyyy/MM/dd HH:mm";
	public static Date convertirFecha(String fechaStr) throws Exception {
		SimpleDateFormat simplef = new SimpleDateFormat(Fecha_Format);
		Date fechaDate = null;
		try {
			fechaDate = simplef.parse(fechaStr);
		} catch (ParseException e) {
			throw new Exception("La fecha no tiene el formato correcto");
		}
		return fechaDate;
	}
	
	
}
