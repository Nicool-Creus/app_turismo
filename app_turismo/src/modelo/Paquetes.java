package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Paquetes {
	
	Conexion conector = new Conexion();

	public int codigo;
	public int idDestino;
	public int idOrigen;
	public String fechaVenta;
	public String horaVenta;
	public String horaSalida;
	public String fechaEjecucion;
	public String observaciones;
	public String matricula;
	public String precios;
	public int idCliente;
	public int idAgencia;
	public int idMedios;
	public int idPromotor;

	public Paquetes(int codigo, int idDestino, int idOrigen, String fechaVenta, String horaVenta, String horaSalida,
			String fechaEjecucion, String observaciones, String matricula, String precios, int idCliente, int idAgencia,
			int idMedios, int idPromotor) {
		super();
		this.codigo = codigo;
		this.idDestino = idDestino;
		this.idOrigen = idOrigen;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.horaSalida = horaSalida;
		this.fechaEjecucion = fechaEjecucion;
		this.observaciones = observaciones;
		this.matricula = matricula;
		this.precios = precios;
		this.idCliente = idCliente;
		this.idAgencia = idAgencia;
		this.idMedios = idMedios;
		this.idPromotor = idPromotor;
	}

	public Paquetes() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public int getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(String fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPrecios() {
		return precios;
	}

	public void setPrecios(String precios) {
		this.precios = precios;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public int getIdMedios() {
		return idMedios;
	}

	public void setIdMedios(int idMedios) {
		this.idMedios = idMedios;
	}

	public int getIdPromotor() {
		return idPromotor;
	}

	public void setIdPromotor(int idPromotor) {
		this.idPromotor = idPromotor;
	}

	public void create(int codigo, int idDestino, int idOrigen, String fechaVenta, String horaVenta, String horaSalida, String fechaEjecucion, 
			String observaciones, String matricula, String precios, int idCliente, int idAgencia, int idMedios, int idPromotor) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblpaquetes (codigo, idDestino, idOrigen, fechaVenta, horaVenta, horaSalida, fechaEjecucion, observaciones, matricula, precios, idCliente, idAgencia, idMedios, idPromotor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, codigo);
			pst.setInt(2, idDestino);
			pst.setInt(3, idOrigen);
			pst.setString(4, fechaVenta);
			pst.setString(5, horaVenta);
			pst.setString(6, horaSalida);
			pst.setString(7, fechaEjecucion);
			pst.setString(8, observaciones);
			pst.setString(9, matricula);
			pst.setString(10, precios);
			pst.setInt(11, idCliente);
			pst.setInt(12, idAgencia);
			pst.setInt(13, idMedios);
			pst.setInt(14, idPromotor);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int codigo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblpaquetes WHERE codigo = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, codigo);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ codigo + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+codigo+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
