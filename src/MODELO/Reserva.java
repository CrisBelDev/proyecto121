/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;

public class Reserva {
    private int id;
    private String fecha;
    private String hora;
    private int numPersonas;
    private Mesa mesa;
    private Cliente cliente;
    private boolean activa;

    public Reserva(int id, String fecha, String hora, int numPersonas, Mesa mesa, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.mesa = mesa;
        this.cliente = cliente;
        this.activa = true;
        mesa.cambiarDisponibilidad(false);
    }

    public void cancelar() {
        activa = false;
        mesa.cambiarDisponibilidad(true);
    }

    public void mostrar() {
        System.out.println("Reserva #" + id + " para " + cliente.getNombre() + " en mesa de " + mesa.getCapacidad() + " personas");
    }
}
