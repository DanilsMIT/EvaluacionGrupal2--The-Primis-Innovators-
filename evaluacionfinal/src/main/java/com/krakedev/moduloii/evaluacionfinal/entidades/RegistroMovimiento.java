package com.krakedev.moduloii.evaluacionfinal.entidades;

public class RegistroMovimiento {
	private int id;
	private String idArticulos;
	private int cantidad;
	private String fechaMovimiento;

	public RegistroMovimiento() {
		super();
	}

	public RegistroMovimiento(int id, String idArticulos, int cantidad, String fechaMovimiento) {
		super();
		this.id = id;
		this.idArticulos = idArticulos;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdArticulos() {
		return idArticulos;
	}

	public void setIdArticulos(String idArticulos) {
		this.idArticulos = idArticulos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	@Override
	public String toString() {
		return "RegistroMovimiento [id=" + id + ", idArticulos=" + idArticulos + ", cantidad=" + cantidad
				+ ", fechaMovimiento=" + fechaMovimiento + "]";
	}

}
