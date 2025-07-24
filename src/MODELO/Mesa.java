/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Mesa {
    private int id;
    private int capacidad;
    private boolean disponible;

    public Mesa(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void cambiarDisponibilidad(boolean estado) {
        this.disponible = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public int getId() {
    return id;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
@Override
public String toString() {
    return "Mesa " + id + " (" + capacidad + " personas)";
}

}
