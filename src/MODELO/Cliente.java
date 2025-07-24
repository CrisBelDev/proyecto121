package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private boolean vegetariano;
    
    public Cliente() {
        // Constructor vacío
    }

    public Cliente(int id, String nombre, String email, String telefono, boolean vegetariano) {
        super(id, nombre, email, telefono);
        this.vegetariano = vegetariano;
    }
    
   

    // Métodos getter y setter
    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    // Método para guardar cliente directamente en la BD
    public void guardarEnBD() {
        String sql = "INSERT INTO clientes (nombre, email, telefono, vegetariano) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistema_restaurantes", 
                "root", 
                "");
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, this.getNombre());
            pstmt.setString(2, this.getEmail());
            pstmt.setString(3, this.getTelefono());
            pstmt.setBoolean(4, this.isVegetariano());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        this.setId(rs.getInt(1));
                        System.out.println("Cliente guardado con ID: " + this.getId());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    // Método para obtener todos los clientes desde la BD
    public static List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistema_restaurantes", 
                "root", 
                "");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setVegetariano(rs.getBoolean("vegetariano"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Método para probar la funcionalidad
    public static void main(String[] args) {
        // Prueba de inserción
        Cliente nuevo = new Cliente();
        nuevo.setNombre("Ana López");
        nuevo.setEmail("ana@test.com");
        nuevo.setTelefono("5559876543");
        nuevo.setVegetariano(false);
        nuevo.guardarEnBD();

        // Prueba de obtención
        System.out.println("\nListado de clientes:");
        List<Cliente> clientes = Cliente.obtenerTodosClientes();
        for (Cliente c : clientes) {
            System.out.println(c.getId() + ": " + c.getNombre() + " - " + c.getEmail());
        }
    }

    public boolean getPreferencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}