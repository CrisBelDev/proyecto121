package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_restaurantes";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    
    public MySQLConnection() {}
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a MySQL");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a MySQL: " + e.getMessage());
            connection = null; // Asegura que no quede una conexión inválida
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            } finally {
                connection = null;
            }
        }
    }
    
    public static boolean testConnection() {
        try (Connection testConn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Prueba de conexión exitosa");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error en prueba de conexión: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Prueba de conexión
        System.out.println("=== Iniciando prueba de conexión ===");
        
        if (testConnection()) {
            System.out.println("La conexión a la base de datos está funcionando correctamente");
            
            // Prueba adicional con getConnection()
            Connection conn = getConnection();
            if (conn != null) {
                try {
                    System.out.println("Información de la conexión:");
                    System.out.println("AutoCommit: " + conn.getAutoCommit());
                    System.out.println("Base de datos: " + conn.getCatalog());
                    
                    // Cerrar la conexión de prueba
                    closeConnection();
                } catch (SQLException e) {
                    System.err.println("Error al obtener información de conexión: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos");
            System.out.println("Verifica lo siguiente:");
            System.out.println("1. Que MySQL esté corriendo en tu equipo");
            System.out.println("2. Que la base de datos 'sistema_restaurantes' exista");
            System.out.println("3. Que el usuario y contraseña sean correctos");
            System.out.println("4. Que el puerto 3306 esté accesible");
        }
    }
}