/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
public class Bebidas extends Producto {
    private boolean alcoholica;
    private String volumen;

    public Bebidas(int id, String nombre, String descripcion, double precio, boolean estado, boolean alcoholica, String volumen) {
        super(id, nombre, descripcion, precio, estado);
        this.alcoholica = alcoholica;
        this.volumen = volumen;
    }

    public void mostrar() {
        System.out.println(nombre + " - " + volumen + " - $" + precio + (alcoholica ? " (Alcoholica)" : ""));
    }

    public boolean isAlcoholica() {
        return alcoholica;
    }

    public String getVolumen() {
        return volumen;
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
