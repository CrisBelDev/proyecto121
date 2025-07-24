/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Plato extends Producto {
    public Plato(int id, String nombre, String descripcion, double precio, boolean estado) {
        super(id, nombre, descripcion, precio, estado);
    }

    public void mostrar() {
        System.out.println(nombre + " - " + descripcion + " - $" + precio);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }
    
}
