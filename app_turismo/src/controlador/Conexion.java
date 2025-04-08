package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
		
		public Connection conectarBD() {
			//Crear e inicializar un objeto de la clase connection
			Connection connection = null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_turismo", "root", "2556229");
				System.out.println("Connected with the database successfully");
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database");
			}
			return connection; //Retorna la conexión abierta con la BD
		}

	}
