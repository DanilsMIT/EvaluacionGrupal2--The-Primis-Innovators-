package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	}
}
			
		
	
	
	
	
	

