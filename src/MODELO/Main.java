/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inventarios generales
        Inventario<Cliente> clientes = new Inventario<>();
        Inventario<Restaurante> restaurantes = new Inventario<>();
        Inventario<Reserva> reservas = new Inventario<>();

        Inventario<Plato> stockPlatos = new Inventario<>();
        Inventario<Bebidas> stockBebidas = new Inventario<>();
        Inventario<Postres> stockPostres = new Inventario<>();

        int idCliente = 1, idRest = 1, idMesa = 1, idReserva = 1;

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== SISTEMA DE RESERVAS DE RESTAURANTE =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar restaurante");
            System.out.println("3. Agregar mesa a restaurante");
            System.out.println("4. Crear menú de restaurante");
            System.out.println("5. Crear reserva");
            System.out.println("6. Cancelar reserva");
            System.out.println("7. Ver menú de restaurante");
            System.out.println("8. Agregar productos al inventario de cocina");
            System.out.println("9. Ver inventario de productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();
                    System.out.print("¿Vegetariano? (true/false): ");
                    boolean pref = sc.nextBoolean();
                    clientes.agregar(new Cliente(idCliente++, nombre, email, tel, pref));
                    System.out.println("Cliente registrado con éxito.");
                    break;

                case 2:
                    System.out.print("Nombre del restaurante: ");
                    String nomRest = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dir = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telf = sc.nextLine();
                    restaurantes.agregar(new Restaurante(idRest++, nomRest, dir, telf));
                    System.out.println("Restaurante registrado.");
                    break;

                case 3:
                    if (restaurantes.cantidad() == 0) {
                        System.out.println("No hay restaurantes.");
                        break;
                    }
                    System.out.println("Seleccione restaurante:");
                    for (int i = 0; i < restaurantes.cantidad(); i++) {
                        System.out.println(i + ". " + restaurantes.buscar(i).getNombre());
                    }
                    int idxR = sc.nextInt();
                    System.out.print("Capacidad de la mesa: ");
                    int cap = sc.nextInt();
                    restaurantes.buscar(idxR).agregarMesa(new Mesa(idMesa++, cap));
                    System.out.println("Mesa agregada.");
                    break;

                case 4:
                    if (restaurantes.cantidad() == 0) {
                        System.out.println("No hay restaurantes.");
                        break;
                    }
                    System.out.println("Seleccione restaurante:");
                    for (int i = 0; i < restaurantes.cantidad(); i++) {
                        System.out.println(i + ". " + restaurantes.buscar(i).getNombre());
                    }
                    int rIndex = sc.nextInt();
                    Menu menu = new Menu(rIndex + 100);

                    // Platos
                    System.out.println("Selecciona platos del inventario:");
                    for (int i = 0; i < stockPlatos.cantidad(); i++) {
                        System.out.print(i + ". ");
                        stockPlatos.buscar(i).mostrar();
                    }
                    System.out.print("¿Cuántos agregar?: ");
                    int nP = sc.nextInt();
                    for (int i = 0; i < nP; i++) {
                        System.out.print("Índice del plato: ");
                        int idx = sc.nextInt();
                        menu.agregarPlato(stockPlatos.buscar(idx));
                    }

                    // Bebidas
                    System.out.println("Selecciona bebidas del inventario:");
                    for (int i = 0; i < stockBebidas.cantidad(); i++) {
                        System.out.print(i + ". ");
                        stockBebidas.buscar(i).mostrar();
                    }
                    System.out.print("¿Cuántas agregar?: ");
                    int nB = sc.nextInt();
                    for (int i = 0; i < nB; i++) {
                        System.out.print("Índice de la bebida: ");
                        int idx = sc.nextInt();
                        menu.agregarBebida(stockBebidas.buscar(idx));
                    }

                    // Postres
                    System.out.println("Selecciona postres del inventario:");
                    for (int i = 0; i < stockPostres.cantidad(); i++) {
                        System.out.print(i + ". ");
                        stockPostres.buscar(i).mostrar();
                    }
                    System.out.print("¿Cuántos agregar?: ");
                    int nPo = sc.nextInt();
                    for (int i = 0; i < nPo; i++) {
                        System.out.print("Índice del postre: ");
                        int idx = sc.nextInt();
                        menu.agregarPostre(stockPostres.buscar(idx));
                    }

                    restaurantes.buscar(rIndex).setMenu(menu);
                    System.out.println("Menú creado.");
                    break;

                case 5:
                    if (clientes.cantidad() == 0 || restaurantes.cantidad() == 0) {
                        System.out.println("Debe registrar clientes y restaurantes primero.");
                        break;
                    }
                    System.out.println("Seleccione cliente:");
                    for (int i = 0; i < clientes.cantidad(); i++) {
                        System.out.println(i + ". " + clientes.buscar(i).getNombre());
                    }
                    int cIndex = sc.nextInt();

                    System.out.println("Seleccione restaurante:");
                    for (int i = 0; i < restaurantes.cantidad(); i++) {
                        System.out.println(i + ". " + restaurantes.buscar(i).getNombre());
                    }
                    int restIndex = sc.nextInt();

                    Restaurante rest = restaurantes.buscar(restIndex);
                    ArrayList<Mesa> disponibles = rest.getMesasDisponibles();
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay mesas disponibles.");
                        break;
                    }
                    System.out.println("Mesas disponibles:");
                    for (int i = 0; i < disponibles.size(); i++) {
                        System.out.println(i + ". Mesa capacidad: " + disponibles.get(i).getCapacidad());
                    }
                    int mIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha (dd-mm-yyyy): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora (hh:mm): ");
                    String hora = sc.nextLine();
                    System.out.print("Cantidad personas: ");
                    int cant = sc.nextInt();

                    Reserva res = new Reserva(idReserva++, fecha, hora, cant, disponibles.get(mIndex), clientes.buscar(cIndex));
                    reservas.agregar(res);
                    System.out.println("Reserva realizada.");
                    break;

                case 6:
                    if (reservas.cantidad() == 0) {
                        System.out.println("No hay reservas.");
                        break;
                    }
                    System.out.println("Seleccione reserva a cancelar:");
                    for (int i = 0; i < reservas.cantidad(); i++) {
                        System.out.print(i + ". ");
                        reservas.buscar(i).mostrar();
                    }
                    int resIndex = sc.nextInt();
                    reservas.buscar(resIndex).cancelar();
                    System.out.println("Reserva cancelada.");
                    break;

                case 7:
                    if (restaurantes.cantidad() == 0) {
                        System.out.println("No hay restaurantes.");
                        break;
                    }
                    System.out.println("Seleccione restaurante:");
                    for (int i = 0; i < restaurantes.cantidad(); i++) {
                        System.out.println(i + ". " + restaurantes.buscar(i).getNombre());
                    }
                    int idxM = sc.nextInt();
                    if (restaurantes.buscar(idxM).getMenu() != null)
                        restaurantes.buscar(idxM).getMenu().mostrarMenu();
                    else
                        System.out.println("Menú no disponible.");
                    break;

                case 8:
                    System.out.println("¿Qué deseas agregar?");
                    System.out.println("1. Plato");
                    System.out.println("2. Bebida");
                    System.out.println("3. Postre");
                    int tipoProd = sc.nextInt(); sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble(); sc.nextLine();
                    boolean estado = true;

                    switch (tipoProd) {
                        case 1:
                            stockPlatos.agregar(new Plato(stockPlatos.cantidad() + 1, nombreP, desc, precio, estado));
                            System.out.println("Plato agregado al inventario.");
                            break;
                        case 2:
                            System.out.print("¿Es alcohólica? (true/false): ");
                            boolean alcohol = sc.nextBoolean(); sc.nextLine();
                            System.out.print("Volumen (ej: 500ml): ");
                            String vol = sc.nextLine();
                            stockBebidas.agregar(new Bebidas(stockBebidas.cantidad() + 1, nombreP, desc, precio, estado, alcohol, vol));
                            System.out.println("Bebida agregada al inventario.");
                            break;
                        case 3:
                            System.out.print("¿Apto para celíacos? (true/false): ");
                            boolean celiaco = sc.nextBoolean();
                            System.out.print("Calorías: ");
                            int cal = sc.nextInt(); sc.nextLine();
                            stockPostres.agregar(new Postres(stockPostres.cantidad() + 1, nombreP, desc, precio, estado, celiaco, cal));
                            System.out.println("Postre agregado al inventario.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 9:
                    System.out.println("=== INVENTARIO DE PRODUCTOS ===");
                    System.out.println("PLATOS:");
                    for (Plato p : stockPlatos.listar()) {
                        p.mostrar();
                    }

                    System.out.println("\nBEBIDAS:");
                    for (Bebidas b : stockBebidas.listar()) {
                        b.mostrar();
                    }

                    System.out.println("\nPOSTRES:");
                    for (Postres p : stockPostres.listar()) {
                        p.mostrar();
                    }
                    break;

                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
