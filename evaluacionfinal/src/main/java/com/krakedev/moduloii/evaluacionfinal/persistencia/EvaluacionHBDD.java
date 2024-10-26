package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class EvaluacionHBDD {
	public void insertar(Articulo articulo) throws InventarioException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos) values (?, ?, ?, ?, ?)");
			ps.setString(1, articulo.getId());
			ps.setString(2, articulo.getNombre());
			ps.setBigDecimal(3, articulo.getPrecioVenta());
			ps.setBigDecimal(4, articulo.getPrecioCompra());
			ps.setString(5, articulo.getIdGrupos());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InventarioException("Error al insertar el articulo. Detalle: " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//estudiante 4
				public ArrayList<RegistroMovimiento> recuperarTodos(String idArticulo) throws InventarioException {
					ArrayList<RegistroMovimiento> registroMovimientos = new ArrayList<RegistroMovimiento>();
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					RegistroMovimiento registroMovimiento = null;

					try {
						con = ConexionBDD.obtenerConexion();
						ps = con.prepareStatement("select id, id_articulos, cantidad, fecha_movimiento from registro_movimientos where id_articulos = ?");
						ps.setString(1, idArticulo);
						rs = ps.executeQuery();

						while (rs.next()) {
							int id = rs.getInt("id");
							String idArticulos = rs.getString("id_articulos");
							int cantidad = rs.getInt("cantidad");
							Timestamp fechaMovimiento = rs.getTimestamp("fecha_movimiento");
							SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String fechaStr = formato.format(fechaMovimiento);

							registroMovimiento = new RegistroMovimiento(id, idArticulos, cantidad, fechaStr);

							registroMovimientos.add(registroMovimiento);
						}

					} catch (InventarioException e) {
						e.printStackTrace();
						throw e;
					} catch (SQLException e) {
						e.printStackTrace();
						throw new InventarioException("Error al consultar. Detalle: " + e.getMessage());
					} finally {
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if (ps != null) {
							try {
								ps.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}

					return registroMovimientos;
				}
	}
}
