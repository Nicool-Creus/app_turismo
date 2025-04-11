package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Paquetes {
	
	//Se conecta a la base de datos mediante el método que está dentro de la clase Conexion
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

	//Insertar datos en la tabla paquetes
	public void create(int codigo, int idDestino, int idOrigen, String fechaVenta, String horaVenta, String horaSalida, String fechaEjecucion, 
			String observaciones, String matricula, String precios, int idCliente, int idAgencia, int idMedios, int idPromotor) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "INSERT INTO tblpaquetes (codigo, idDestino, idOrigen, fechaVenta, horaVenta, horaSalida, fechaEjecucion, observaciones, matricula, precios, idCliente, idAgencia, idMedios, idPromotor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
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
			
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Eliminar datos de la tabla paquetes
	public void delete(int codigo) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "DELETE FROM tblpaquetes WHERE codigo = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
	
			//Parametrizar el campo
			pst.setInt(1, codigo);
			
			//Confirmar la operación
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ codigo + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				
				//Ejecutar la trx
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+codigo+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Consultar todos los registros de la tabla paquetes
	public void readOne(int codigo, JTextField idDestino, JTextField idOrigen, JTextField fechaVenta, JTextField horaVenta, JTextField horaSalida, 
			JTextField fechaEjecucion, JTextField observaciones, JTextField precios, JTextField matricula, JTextField idCliente, JTextField idAgencia, 
			JTextField idMedios, JTextField idPromotor) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "SELECT * FROM tblpaquetes WHERE codigo = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar el campo
			pst.setInt(1, codigo);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
			while (rs.next()) {
				idDestino.setText(rs.getString(2));
				idOrigen.setText(rs.getString(3));
				fechaVenta.setText(rs.getString(4));
				horaVenta.setText(rs.getString(5));
				horaSalida.setText(rs.getString(6));
				fechaEjecucion.setText(rs.getString(7));
				observaciones.setText(rs.getString(8));
				precios.setText(rs.getString(9));
				matricula.setText(rs.getString(10));
				idCliente.setText(rs.getString(11));
				idAgencia.setText(rs.getString(12));
				idMedios.setText(rs.getString(13));
				idPromotor.setText(rs.getString(14));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Actualizar los datos de la tabla paquetes
	public void update(int codigo, int idDestino, int idOrigen, String fechaVenta, String horaVenta, String horaSalida, String fechaEjecucion, 
			String observaciones, String matricula, String precios, int idCliente, int idAgencia, int idMedios, int idPromotor) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "UPDATE tblpaquetes SET idDestino = ?, idOrigen = ?, fechaVenta = ?, horaVenta = ?, horaSalida = ?, fechaEjecucion = ?, observaciones = ?, matricula = ?, precios = ?, idCliente = ?, idAgencia = ?, idMedios = ?, idPromotor = ? WHERE codigo = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, idDestino);
			pst.setInt(2, idOrigen);
			pst.setString(3, fechaVenta);
			pst.setString(4, horaVenta);
			pst.setString(5, horaSalida);
			pst.setString(6, fechaEjecucion);
			pst.setString(7, observaciones);
			pst.setString(8, matricula);
			pst.setString(9, precios);
			pst.setInt(10, idCliente);
			pst.setInt(11, idAgencia);
			pst.setInt(12, idMedios);
			pst.setInt(13, idPromotor);
			pst.setInt(14, codigo);
			
			//Confirmar la operación
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + codigo + "?");
			
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
