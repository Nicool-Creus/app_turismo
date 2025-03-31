package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Companias {
	
	Conexion conector = new Conexion();

	public int idCompania;
	public String razonSocial;
	public String direccion;
	public String correo;
	public String telefono;
	public String fechaCreacion;
	public String web;

	public Companias(int idCompania, String razonSocial, String direccion, String correo, String telefono,
			String fechaCreacion, String web) {
		super();
		this.idCompania = idCompania;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaCreacion = fechaCreacion;
		this.web = web;
	}

	public Companias() {
		super();
	}
	
	public int getIdCompania() {
		return idCompania;
	}

	public void setIdCompania(int idCompania) {
		this.idCompania = idCompania;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public void create(int idCompania, String razonSocial, String direccion, String correo, String telefono, String fechaCreacion, String web) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblcompania (idCompania, razonSocial, direccion, correo, telefono, fechaCreacion, web) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idCompania);
			pst.setString(2, razonSocial);
			pst.setString(3, direccion);
			pst.setString(4, correo);
			pst.setString(5, telefono);
			pst.setString(6, fechaCreacion);
			pst.setString(7, web);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblcompania WHERE idCompania = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, idCompania);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idCompania + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idCompania+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
