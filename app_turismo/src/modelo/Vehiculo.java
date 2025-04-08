package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Vehiculo {
	
	Conexion conector = new Conexion();

	public String matricula;
	public String marca;
	public int puestos;
	public String modelo;
	public int numeroMotor;
	public String categoria;
	public int idTipo;

	public Vehiculo(String matricula, String marca, int puestos, String modelo, int numeroMotor, String categoria,
			int idTipo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.puestos = puestos;
		this.modelo = modelo;
		this.numeroMotor = numeroMotor;
		this.categoria = categoria;
		this.idTipo = idTipo;
	}

	public Vehiculo() {
		super();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPuestos() {
		return puestos;
	}

	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(int numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public void create(String matricula, String marca, int puestos, String modelo, int numeroMotor, String categoria, int idTipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblvehiculo (matricula, marca, puestos, modelo, numeroMotor, categoria, idTipo) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setString(1, matricula);
			pst.setString(2, marca);
			pst.setInt(3, puestos);
			pst.setString(4, modelo);
			pst.setInt(5, numeroMotor);
			pst.setString(6, categoria);
			pst.setInt(7, idTipo);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(String matricula) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblvehiculo WHERE matricula = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setString(1, matricula);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ matricula + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+matricula+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readOne(String matricula, JTextField marca, JTextField puestos, JTextField modelo, JTextField numeroMotor, JTextField categoria, JTextField idTipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "SELECT * FROM tblvehiculo WHERE matricula = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setString(1, matricula);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				marca.setText(rs.getString(2));
				puestos.setText(rs.getString(3));
				modelo.setText(rs.getString(4));
				numeroMotor.setText(rs.getString(5));
				categoria.setText(rs.getString(6));
				idTipo.setText(rs.getString(7));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(String matricula, String marca, int puestos, String modelo, int numeroMotor, String categoria, int idTipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "UPDATE tblvehiculo SET marca = ?, puestos = ?, modelo = ?, numeroMotor = ?, categoria = ?, idTipo = ? WHERE matricula = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setString(1, marca);
			pst.setInt(2, puestos);
			pst.setString(3, modelo);
			pst.setInt(4, numeroMotor);
			pst.setString(5, categoria);
			pst.setInt(6, idTipo);
			pst.setString(7, matricula);
			
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + matricula + "?");
			
			if (rs == JOptionPane.OK_OPTION){
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
