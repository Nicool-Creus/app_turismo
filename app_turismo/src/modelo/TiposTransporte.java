package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class TiposTransporte {
	
	Conexion conector = new Conexion();

	public int idTipo;
	public String nombre;
	public String observaciones;
	
	public TiposTransporte(int idTipo, String nombre, String observaciones) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.observaciones = observaciones;
	}

	public TiposTransporte() {
		super();
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void create(int idTipo, String nombre, String observaciones) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tbltipostransporte (idTipo, nombre, observaciones) values (?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idTipo);
			pst.setString(2, nombre);
			pst.setString(3, observaciones);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idTipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tbltipostransporte WHERE idTipo = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, idTipo);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idTipo + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idTipo+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
