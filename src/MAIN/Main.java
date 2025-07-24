package MAIN;

import MODELO.Cliente;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("SISTEMA DE GESTIÓN DE CLIENTES");
        System.out.println("==============================");
        
        while (true) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    registrarCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.println("\nREGISTRO DE NUEVO CLIENTE");
        System.out.println("-----------------------");
        
        Cliente cliente = new Cliente();
        
        System.out.print("Nombre: ");
        cliente.setNombre(scanner.nextLine());
        
        System.out.print("Email: ");
        cliente.setEmail(scanner.nextLine());
        
        System.out.print("Teléfono: ");
        cliente.setTelefono(scanner.nextLine());
        
        System.out.print("¿Es vegetariano? (s/n): ");
        String respuesta = scanner.nextLine();
        cliente.setVegetariano(respuesta.equalsIgnoreCase("s"));
        
        // Guardar en la base de datos
        cliente.guardarEnBD();
        
        System.out.println("Cliente registrado exitosamente!");
    }

    private static void listarClientes() {
        System.out.println("\nLISTADO DE CLIENTES");
        System.out.println("------------------");
        
        List<Cliente> clientes = Cliente.obtenerTodosClientes();
        
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.printf("%-5s %-20s %-25s %-15s %-12s%n", 
                "ID", "Nombre", "Email", "Teléfono", "Vegetariano");
            System.out.println("-----------------------------------------------------------");
            
            for (Cliente c : clientes) {
                System.out.printf("%-5d %-20s %-25s %-15s %-12s%n", 
                    c.getId(), 
                    c.getNombre(), 
                    c.getEmail(), 
                    c.getTelefono(), 
                    c.isVegetariano() ? "Sí" : "No");
            }
        }
    }
}