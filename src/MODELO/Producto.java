/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package MODELO;
    public abstract class Producto {
        protected int id;
        protected String nombre;
        protected String descripcion;
        protected double precio;
        protected boolean estado;

        public Producto(int id, String nombre, String descripcion, double precio, boolean estado) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.estado = estado;
        }

        public abstract void mostrar();
    }
