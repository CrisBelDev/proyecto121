package MODELO;
import java.util.ArrayList;

public class Restaurante {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private Menu menu;
    private Inventario<Plato> inventarioPlatos;
    private Inventario<Bebidas> inventarioBebidas;
    private Inventario<Postres> inventarioPostres;
    

    public Restaurante(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.inventarioPlatos = new Inventario<>();
        this.inventarioBebidas = new Inventario<>();
        this.inventarioPostres = new Inventario<>();
    }

    // Métodos para mesas
    public void agregarMesa(Mesa m) {
        mesas.add(m);
    }

    public ArrayList<Mesa> getMesasDisponibles() {
        ArrayList<Mesa> disponibles = new ArrayList<>();
        for (Mesa m : mesas) {
            if (m.isDisponible()) disponibles.add(m);
        }
        return disponibles;
    }

    // Métodos para el menú
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    // Métodos para los inventarios
    public void agregarPlato(Plato plato) {
        inventarioPlatos.agregar(plato);
    }

    public void agregarBebida(Bebidas bebida) {
        inventarioBebidas.agregar(bebida);
    }

    public void agregarPostre(Postres postre) {
        inventarioPostres.agregar(postre);
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public int getId() { return id; }
    public ArrayList<Mesa> getMesas() { return mesas; }
    
    public Inventario<Plato> getInventarioPlatos() { return inventarioPlatos; }
    public Inventario<Bebidas> getInventarioBebidas() { return inventarioBebidas; }
    public Inventario<Postres> getInventarioPostres() { return inventarioPostres; }

    // Método para cargar productos al menú desde los inventarios
    public void cargarMenuDesdeInventarios() {
        if (menu == null) {
            menu = new Menu(this.id);
        } else {
            menu.getPlatos().clear();
            menu.getBebidas().clear();
            menu.getPostres().clear();
        }
        
        for (Plato p : inventarioPlatos.listar()) {
            menu.agregarPlato(p);
        }
        for (Bebidas b : inventarioBebidas.listar()) {
            menu.agregarBebida(b);
        }
        for (Postres p : inventarioPostres.listar()) {
            menu.agregarPostre(p);
        }
    }
    public ArrayList<Mesa> getTodasLasMesas() {
    return mesas;
}

    
}