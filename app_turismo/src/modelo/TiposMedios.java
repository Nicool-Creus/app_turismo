package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class TiposMedios {
	
	Conexion conector = new Conexion();

	public int idTiposMedios;
	public String nombre;
	public String observaciones;
	
	public TiposMedios(int idTiposMedios, String nombre, String observaciones) {
		super();
		this.idTiposMedios = idTiposMedios;
		this.nombre = nombre;
		this.observaciones = observaciones;
	}


	public TiposMedios() {
		super();
	}
	
	
	public int getIdTiposMedios() {
		return idTiposMedios;
	}


	public void setIdTiposMedios(int idTiposMedios) {
		this.idTiposMedios = idTiposMedios;
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

	public void create(int idTiposMedios, String nombre, String observaciones) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tbltiposmedios (idTiposMedios, nombre, observaciones) values (?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idTiposMedios);
			pst.setString(2, nombre);
			pst.setString(3, observaciones);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idTiposMedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tbltiposmedios WHERE idTiposMedios = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, idTiposMedios);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idTiposMedios + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idTiposMedios+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
