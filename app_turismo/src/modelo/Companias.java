package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Companias {
	
	//Se conecta a la base de datos mediante el método que está dentro de la clase Conexion
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

	//Insertar datos en la tabla compania
	public void create(int idCompania, String razonSocial, String direccion, String correo, String telefono, String fechaCreacion, String web) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "INSERT INTO tblcompania (idCompania, razonSocial, direccion, correo, telefono, fechaCreacion, web) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, idCompania);
			pst.setString(2, razonSocial);
			pst.setString(3, direccion);
			pst.setString(4, correo);
			pst.setString(5, telefono);
			pst.setString(6, fechaCreacion);
			pst.setString(7, web);
			
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Eliminar datos en la tabla compania
	public void delete(int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "DELETE FROM tblcompania WHERE idCompania = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
	
			//Parametrizar el campo
			pst.setInt(1, idCompania);
			
			//Confirmar la operación
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idCompania + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				
				//Ejecutar la trx
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idCompania+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Consultar todos los registros de la tabla compania
	public void readOne(int idCompania, JTextField razonSocial, JTextField direccion, JTextField correo, JTextField telefono, JTextField fechaCreacion, JTextField web) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "SELECT * FROM tblcompania WHERE idCompania = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar el campo
			pst.setInt(1, idCompania);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
			while (rs.next()) {
				razonSocial.setText(rs.getString(2));
				direccion.setText(rs.getString(3));
				correo.setText(rs.getString(4));
				telefono.setText(rs.getString(5));
				fechaCreacion.setText(rs.getString(6));
				web.setText(rs.getString(7));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Actualizar los datos de la tabla compania
	public void update(int idCompania, String razonSocial, String direccion, String correo, String telefono, String fechaCreacion, String web) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "UPDATE tblcompania SET razonSocial = ?, direccion = ?, correo = ?, telefono = ?, fechaCreacion = ?, web = ? WHERE idCompania = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setString(1, razonSocial);
			pst.setString(2, direccion);
			pst.setString(3, correo);
			pst.setString(4, telefono);
			pst.setString(5, fechaCreacion);
			pst.setString(6, web);
			pst.setInt(7, idCompania);
			
			//Confirmar la operación
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + idCompania + "?");
			
			if (rs == JOptionPane.OK_OPTION){
				
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro actualizado con exito");
			} else {
				JOptionPane.showConfirmDialog(null, "Operación cancelada");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
