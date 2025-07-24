/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
public class Empleado extends Persona {
    private double salario;
    private String turno;
    private String tipo;

    public Empleado(int id, String nombre, String email, String telefono, double salario, String turno, String tipo) {
        super(id, nombre, email, telefono);
        this.salario = salario;
        this.turno = turno;
        this.tipo = tipo;
    }

    // Getters y setters
    public double getSalario() { return salario; }
    public String getTurno() { return turno; }
    public String getTipo() { return tipo; }

    public void setSalario(double salario) { this.salario = salario; }
    public void setTurno(String turno) { this.turno = turno; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
