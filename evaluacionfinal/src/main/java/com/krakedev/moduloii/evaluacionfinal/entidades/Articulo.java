package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.math.BigDecimal;

public class Articulo {
	private String id;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal precioCompra;
	private String idGrupos;

	public Articulo() {
		super();
	}

	public Articulo(String id, String nombre, BigDecimal precioVenta, BigDecimal precioCompra, String idGrupos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.idGrupos = idGrupos;
	}

	public Articulo(String id, String nombre, String idGrupos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idGrupos = idGrupos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public String getIdGrupos() {
		return idGrupos;
	}

	public void setIdGrupos(String idGrupos) {
		this.idGrupos = idGrupos;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra="
				+ precioCompra + ", idGrupos=" + idGrupos + "]";
	}

}
