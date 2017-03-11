/*
 * Vendedor.java
 *
 */
package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Vendedor extends Persona {

    // Atributos
    private IntegerProperty cantAutosVendidos;

    public Vendedor(){
        this(null,null,null,null);
    }
    
    public Vendedor(String nombre, String apellido, String nroDocumento, Integer cantAutosVendidos) {
        super(nombre, apellido, nroDocumento);
        this.cantAutosVendidos = new SimpleIntegerProperty(cantAutosVendidos);
    }

    public String toString() {
        return super.toString() + ", autos vendidos: " + cantAutosVendidos.get();
    }

    public int getCantAutosVendidos() {
        return cantAutosVendidos.get();
    }

    public void setCantAutosVendidos(int cantAutosVendidos) {
        this.cantAutosVendidos.set(cantAutosVendidos);
    }

}
