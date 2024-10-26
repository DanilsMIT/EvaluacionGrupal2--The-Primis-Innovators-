package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;
import com.krakedev.moduloii.evaluacionfinal.utils.Convertidor;

public class EvaluacionHBDD {

	
	//estudiante 3
	
	public class RegistroMovimientoBDD {
		public void insertar(RegistroMovimiento registroMovimiento) throws InventarioException {
			Connection con = null;
			PreparedStatement ps = null;

			try {
				con = ConexionBDD.obtenerConexion();
				ps = con.prepareStatement(
						"insert into registro_movimientos (id_articulos, cantidad, fecha_movimiento) values (?, ?, ?)");
				ps.setString(1, registroMovimiento.getIdArticulos());
				
				ps.setInt(2, registroMovimiento.getCantidad());

				Date fechaConvertida = Convertidor.convertirFecha(registroMovimiento.getFechaMovimiento());
				ps.setTimestamp(3, new java.sql.Timestamp(fechaConvertida.getTime()));

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new InventarioException("Error al insertar el registro de movimiento. Detalle: " + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
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
			
		
	
	
	
	
	

