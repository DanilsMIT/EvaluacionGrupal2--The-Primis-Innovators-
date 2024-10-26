package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	}
}
