package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Clientes {
	
	Conexion conector = new Conexion();

	public int id;
	public int tipoDocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String eps;
	public String alergias;
	public String fechaNacimiento;
	public String correo;
	public String estadoCivil;
	public String telefono;
	public String direccion;

	public Clientes(int id, int tipoDocumento, int documento, String nombres, String apellidos, String eps,
			String alergias, String fechaNacimiento, String correo, String estadoCivil, String telefono,
			String direccion) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.eps = eps;
		this.alergias = alergias;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Clientes() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void create(int id, int tipoDocumento, int documento, String nombres, String apellidos, String eps, String alergias, 
			String fechaNacimiento, String correo, String estadoCivil, String telefono, String direccion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblclientes (id, tipoDocumento, documento, nombres, apellidos, eps, alergias, fechaNacimiento, correo, estadoCivil, telefono, direccion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, id);
			pst.setInt(2, tipoDocumento);
			pst.setInt(3, documento);
			pst.setString(4, nombres);
			pst.setString(5, apellidos);
			pst.setString(6, eps);
			pst.setString(7, alergias);
			pst.setString(8, fechaNacimiento);
			pst.setString(9, correo);
			pst.setString(10, estadoCivil);
			pst.setString(11, telefono);
			pst.setString(12, direccion);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int id) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblclientes WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
	
			pst.setInt(1, id);
			
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ id + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+id+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readOne(int id, JTextField tipoDocumento, JTextField documento, JTextField nombres, JTextField apellidos, JTextField eps, JTextField alergias,
			JTextField fechaNacimiento, JTextField correo, JTextField estadoCivil, JTextField telefono, JTextField direccion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "SELECT * FROM tblclientes WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				tipoDocumento.setText(rs.getString(2));
				documento.setText(rs.getString(3));
				nombres.setText(rs.getString(4));
				apellidos.setText(rs.getString(5));
				eps.setText(rs.getString(6));
				alergias.setText(rs.getString(7));
				fechaNacimiento.setText(rs.getString(8));
				correo.setText(rs.getString(9));
				estadoCivil.setText(rs.getString(10));
				telefono.setText(rs.getString(11));
				direccion.setText(rs.getString(12));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(int id, int tipoDocumento, int documento, String nombres, String apellidos, String eps, String alergias, String fechaNacimiento,
			String correo, String estadoCivil, String telefono, String direccion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "UPDATE tblclientes SET tipoDocumento = ?, documento = ?, nombres = ?, apellidos = ?, eps = ?, alergias = ?, fechaNacimiento = ?, correo = ?, estadoCivil = ?, telefono = ?, direccion = ? WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, tipoDocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, eps);
			pst.setString(6, alergias);
			pst.setString(7, fechaNacimiento);
			pst.setString(8, correo);
			pst.setString(9, estadoCivil);
			pst.setString(10, telefono);
			pst.setString(11, direccion);
			pst.setInt(12, id);
			
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + id + "?");
			
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
