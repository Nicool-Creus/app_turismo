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
	
	//Se conecta a la base de datos mediante el método que está dentro de la clase Conexion
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

	//Insertar los datos en la tabla promotores
	public void create(int id, int tipoDocumento, int documento, String nombres, String apellidos, String direccion, String correoPersonal, String correoCorp,
			String fechaNacimiento, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "INSERT INTO tblpromotores (id, tipoDocumento, documento, nombres, apellidos, direccion, correoPersonal, correoCorp, fechaNacimiento, telefono) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
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
			
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Registro con exito");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	//Eliminar los datos de la tabla promotores
	public void delete(int id) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "DELETE FROM tblpromotores WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
	
			//Parametrizar el campo
			pst.setInt(1, id);
			
			//Confirmar la operación
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. "+ id + "?");
			
			if (resp == JOptionPane.OK_OPTION){
				
				//Ejecutar la trx
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "Registro No. "+id+" eliminado");
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Consultar todos los registros de la tabla paquetes
	public void readOne(int id, JTextField tipoDocumento, JTextField documento, JTextField nombres, JTextField apellidos, JTextField direccion, 
			JTextField correoPersonal, JTextField correoCorp, JTextField fechaNacimiento, JTextField telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "SELECT * FROM tblpromotores WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
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
	
	//Actualizar los datos de la tabla promotores
	public void update(int id, int tipoDocumento, int documento, String nombres, String apellidos, String direccion, String correoPersonal, String correoCorp,
			String fechaNacimiento, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "UPDATE tblpromotores SET tipoDocumento = ?, documento = ?, nombres = ?, apellidos = ?, direccion = ?, correoPersonal = ?, correoCorp = ?, fechaNacimiento = ?, telefono = ? WHERE id = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, tipoDocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correoPersonal);
			pst.setString(7, correoCorp);
			pst.setString(8, fechaNacimiento);
			pst.setString(9, telefono);
			pst.setInt(10, id);
			
			//Confirmar la operación
			int rs = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro " + id + "?");
			
			if (rs == JOptionPane.OK_OPTION){
				
			//Ejecutar la trx
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro actualizado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Control e acceso para los promotores
	public void controlAcceso(int user, String pass) {
		Connection dbConnection = null;
		PreparedStatement pst = null; //Preparar la trx
		
		String script = "SELECT * FROM tblpromotores WHERE documento = ? and contrasena = ?";
		
		try {
			dbConnection = conector.conectarBD(); //Abrir la conexión
			pst = dbConnection.prepareStatement(script); //Abrir el buffer
			
			//Parametrizar los campos
			pst.setInt(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery(); //Almacenamiento temporal
			
			if (rs.next()) {
				principal.show();
				JOptionPane.showMessageDialog(null, "Acceso permitido");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la base de datos");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
