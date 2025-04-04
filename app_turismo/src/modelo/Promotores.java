package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;
import vista.FrmPrincipal;

public class Promotores {
	
	Conexion conector = new Conexion();

	public int id;
	public int tipoDocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String direccion;
	public String correoPersonal;
	public String correoCorp;
	public String fechaNacimiento;
	public String telefono;
	
	FrmPrincipal principal = new FrmPrincipal();

	public Promotores(int id, int tipoDocumento, int documento, String nombres, String apellidos, String direccion,
			String correoPersonal, String correoCorp, String fechaNacimiento, String telefono) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correoPersonal = correoPersonal;
		this.correoCorp = correoCorp;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}

	public Promotores() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoPersonal() {
		return correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getCorreoCorp() {
		return correoCorp;
	}

	public void setCorreoCorp(String correoCorp) {
		this.correoCorp = correoCorp;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void create(int id, int tipoDocumento, int documento, String nombres, String apellidos, String direccion, String correoPersonal, String correoCorp, String fechaNacimiento, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "INSERT INTO tblpromotores (id, tipoDocumento, documento, nombres, apellidos, direccion, correoPersonal, correoCorp, fechaNacimiento, telefono) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, id);
			pst.setInt(2, tipoDocumento);
			pst.setInt(3, documento);
			pst.setString(4, nombres);
			pst.setString(5, apellidos);
			pst.setString(6, direccion);
			pst.setString(7, correoPersonal);
			pst.setString(8, correoCorp);
			pst.setString(9, fechaNacimiento);
			pst.setString(10, telefono);
			
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int id) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "DELETE FROM tblpromotores WHERE id = ?";
		
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
	
	public void readOne(int id, JTextField tipoDocumento, JTextField documento, JTextField nombres, JTextField apellidos, JTextField direccion, 
			JTextField correoPersonal, JTextField correoCorp, JTextField fechaNacimiento, JTextField telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "SELECT * FROM tblpromotores WHERE id = ?";
		
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
				direccion.setText(rs.getString(6));
				correoPersonal.setText(rs.getString(7));
				correoCorp.setText(rs.getString(8));
				fechaNacimiento.setText(rs.getString(9));
				telefono.setText(rs.getString(10));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void controlAcceso(int user, String pass) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		
		String script = "SELECT * FROM tblpromotores WHERE documento = ? and contrasena = ?";
		
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				principal.show();
				JOptionPane.showConfirmDialog(null, "Acceso permitido");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
