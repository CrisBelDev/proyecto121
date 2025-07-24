/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.ArrayList;

public class Menu {
    private int id;
    private ArrayList<Plato> platos;
    private ArrayList<Bebidas> bebidas;
    private ArrayList<Postres> postres;

    public Menu(int id) {
        this.id = id;
        this.platos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
    }

    public void agregarPlato(Plato p) { platos.add(p); }
    public void agregarBebida(Bebidas b) { bebidas.add(b); }
    public void agregarPostre(Postres p) { postres.add(p); }

    public void mostrarMenu() {
        System.out.println("PLATOS:");
        for (Plato p : platos) p.mostrar();
        System.out.println("BEBIDAS:");
        for (Bebidas b : bebidas) b.mostrar();
        System.out.println("POSTRES:");
        for (Postres p : postres) p.mostrar();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public ArrayList<Bebidas> getBebidas() {
        return bebidas;
    }

    public ArrayList<Postres> getPostres() {
        return postres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public void setBebidas(ArrayList<Bebidas> bebidas) {
        this.bebidas = bebidas;
    }

    public void setPostres(ArrayList<Postres> postres) {
        this.postres = postres;
    }
    
}
