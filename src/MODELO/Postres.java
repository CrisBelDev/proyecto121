/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

    public class Postres extends Producto {
        private boolean aptoCeliacos;
        private int calorias;

        public Postres(int id, String nombre, String descripcion, double precio, boolean estado, boolean aptoCeliacos, int calorias) {
            super(id, nombre, descripcion, precio, estado);
            this.aptoCeliacos = aptoCeliacos;
            this.calorias = calorias;
        }

        public void mostrar() {
            System.out.println(nombre + " - " + calorias + "cal - $" + precio + (aptoCeliacos ? " (Apto celiacos)" : ""));
        }

    public boolean isAptoCeliacos() {
        return aptoCeliacos;
    }

    public int getCalorias() {
        return calorias;
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
