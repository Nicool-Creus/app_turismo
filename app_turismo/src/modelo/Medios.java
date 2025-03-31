package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Medios {
	
	Conexion conector = new Conexion();

	public int idMedios;
	public String nombre;
	public String observaciones;
	public int idTiposmedios;

	public Medios(int idMedios, String nombre, String observaciones, int idTiposmedios) {
		super();
		this.idMedios = idMedios;
		this.nombre = nombre;
		this.observaciones = observaciones;
		this.idTiposmedios = idTiposmedios;
	}

	public Medios() {
		super();
	}

	public int getIdMedios() {
		return idMedios;
	}

	public void setIdMedios(int idMedios) {
		this.idMedios = idMedios;
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

	public int getIdTiposmedios() {
		return idTiposmedios;
	}

	public void setIdTiposmedios(int idTiposmedios) {
		this.idTiposmedios = idTiposmedios;
	}

	public void create(int idmedios, String nombre, String observaciones, int idTiposmedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblmedios (idMedios, nombre, observaciones, idTiposmedios) values (?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idMedios);
			pst.setString(2, nombre);
			pst.setString(3, observaciones);
			pst.setInt(4, idTiposmedios);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idMedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblmedios WHERE idMedios = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, idMedios);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idMedios + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idMedios+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
