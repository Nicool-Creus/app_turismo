package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Agencias {
	
	//Se conecta a la base de datos mediante el método que está dentro de la clase Conexion
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

	//Insertar datos en la tabla agencias
	public void create(int idAgencia, String nombre, String direccion, String correo, String telefono, String web, int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "INSERT INTO tblagencias (idAgencia, nombre, direccion, correo, telefono, web, idCompania) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, idAgencia);
			pst.setString(2, nombre);
			pst.setString(3, direccion);
			pst.setString(4, correo);
			pst.setString(5, telefono);
			pst.setString(6, web);
			pst.setInt(7, idCompania);
			
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Eliminar datos de la tabla agencias
	public void delete(int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "DELETE FROM tblagencias WHERE idCompania = ?";
		
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
	
	//Consultar todos los registros de la tabla agencias
	public void readOne(int idAgencia, JTextField nombre, JTextField direccion, JTextField correo, JTextField telefono, JTextField web, JTextField idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "SELECT * FROM tblagencias WHERE idAgencia = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script);//Abrir el buffer
			
			pst.setInt(1, idAgencia);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
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
	
	//Actualizar los datos de la tabla agencias
	public void update(int idAgencia, String nombre, String direccion, String correo, String telefono, String web, int idCompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "UPDATE tblagencias SET nombre = ?, direccion = ?, correo = ?, telefono = ?, web = ?, idCompania = ? WHERE idAgencia = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setString(1, nombre);
			pst.setString(2, direccion);
			pst.setString(3, correo);
			pst.setString(4, telefono);
			pst.setString(5, web);
			pst.setInt(6, idCompania);
			pst.setInt(7, idAgencia);
			
			//Confirmar la operación
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + idAgencia + "?");
			
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
