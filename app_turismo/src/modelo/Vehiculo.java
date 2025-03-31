package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

	public void create(String matricula, String marca, String puestos, String modelo, String numeroMotor, String categoria, int idTipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblvehiculo (matricula, marca, puestos, modelo, numeroMotor, categoria, idTipo) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setString(1, matricula);
			pst.setString(2, marca);
			pst.setString(3, puestos);
			pst.setString(4, modelo);
			pst.setString(5, numeroMotor);
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

}
