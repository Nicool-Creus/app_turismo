package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Medios {
	
	//Se conecta a la base de datos mediante el método que está dentro de la clase Conexion
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

	//Insertar datos en la tabla medios
	public void create(int idmedios, String nombre, String observaciones, int idTiposmedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Peparar la trx
		
		String script = "INSERT INTO tblmedios (idMedios, nombre, observaciones, idTiposmedios) values (?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, idMedios);
			pst.setString(2, nombre);
			pst.setString(3, observaciones);
			pst.setInt(4, idTiposmedios);
			
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Eliminar datos en la tabla medios
	public void delete(int idMedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "DELETE FROM tblmedios WHERE idMedios = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
	
			//Parametrizar el campo
			pst.setInt(1, idMedios);
			
			//Confirmar la operación
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ idMedios + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				//Ejecutar la trx
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+idMedios+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Consultar todos los registros de la tabla medios
	public void readOne(int idMedios, JTextField nombre, JTextField observaciones, JTextField idTiposMedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preaparar la trx
		
		String script = "SELECT * FROM tblmedios WHERE idMedios = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar el campo
			pst.setInt(1, idMedios);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
			while (rs.next()) {
				nombre.setText(rs.getString(2));
				observaciones.setText(rs.getString(3));
				idTiposMedios.setText(rs.getString(4));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Actualizar los datos de la tabla medios
	public void update(int idmedios, String nombre, String observaciones, int idTiposMedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "UPDATE tblmedios SET nombre = ?, observaciones = ?, idTiposMedios = ? WHERE idmedios = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los caampos
			pst.setString(1, nombre);
			pst.setString(2, observaciones);
			pst.setInt(3, idTiposMedios);
			pst.setInt(4, idmedios);
			
			//Confirmar la operación
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + idmedios + "?");
			
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
