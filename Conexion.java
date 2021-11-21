import java.sql.*;

public class Conexion {

	private String host = "jdbc:mysql://localhost:3306/laberinto";
	private String user = "root";
	private String password = "";
	

	// CONECTA A LA BASE DE DATOS
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host, user, password);
		} catch (SQLException ex) {
			System.out.println ("¡Error al conectarse a la base de datos!");
		}
		return conn;
	}
	
	// MUESTRA RESULTADOS
	public void mostrarResultados(String query) {
		try {
			Statement cursor = this.getConn().createStatement();
			ResultSet consulta = cursor.executeQuery(query);
			while (consulta.next()) {

		        int id = consulta.getInt("id");
		        String nombre = consulta.getString("nombre");
		        System.out.println(id + " " + nombre);
		        
		    }
			consulta.close();
			cursor.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// INSERTA DATOS
	public void insertarDatos(String query) {
		try {
			Statement cursor = this.getConn().createStatement();
			cursor.executeUpdate(query);
			cursor.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ELIMINA DATOS
	public void eliminarDatos(String query) {
		try {
			Statement cursor = this.getConn().createStatement();
			cursor.executeUpdate(query);
			cursor.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// CIERRA CONEXION
	public void closeConn() {
		try {
			this.getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




}
