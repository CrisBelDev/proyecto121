/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
import java.util.ArrayList;

public class Inventario<T> {
    private ArrayList<T> elementos;
    
    public Inventario() {
        elementos = new ArrayList<>();
    }

    public void agregar(T item) {
        elementos.add(item);
    }

    public boolean eliminar(T item) {
        return elementos.remove(item);
    }

    public T buscar(int index) {
        if (index >= 0 && index < elementos.size()) {
            return elementos.get(index);
        }
        return null;
    }

    public ArrayList<T> listar() {
        return elementos;
    }

    public int cantidad() {
        return elementos.size();
    }
}
