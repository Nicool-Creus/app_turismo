package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Agencias {
	
	Conexion conector = new Conexion();

	public int idAgencia;
	public String nombre;
	public String direccion;
	public String correo;
	public String telefono;
	public String web;
	public int idCompania;

	public Agencias(int idAgencia, String nombre, String direccion, String correo, String telefono, String web,
			int idCompania) {
		super();
		this.idAgencia = idAgencia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.web = web;
		this.idCompania = idCompania;
	}

	public Agencias() {
		super();
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getIdCompania() {
		return idCompania;
	}

	public void setIdCompania(int idCompania) {
		this.idCompania = idCompania;
	}

	public void create(int idAgencia, String nombre, String direccion, String correo, String telefono, String web, int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblagencias (idAgencia, nombre, direccion, correo, telefono, web, idCompania) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idAgencia);
			pst.setString(2, nombre);
			pst.setString(3, direccion);
			pst.setString(4, correo);
			pst.setString(5, telefono);
			pst.setString(6, web);
			pst.setInt(7, idCompania);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblagencias WHERE idCompania = ?";
		
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
	
	public void readOne(int idAgencia, JTextField nombre, JTextField direccion, JTextField correo, JTextField telefono, JTextField web, JTextField idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "SELECT * FROM tblagencias WHERE idAgencia = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, idAgencia);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				nombre.setText(rs.getString(2));
				direccion.setText(rs.getString(3));
				correo.setText(rs.getString(4));
				telefono.setText(rs.getString(5));
				web.setText(rs.getString(6));
				idCompania.setText(rs.getString(7));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
