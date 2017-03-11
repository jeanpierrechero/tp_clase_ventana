/*
 * Comprador.java
 *
 */
package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Comprador extends Persona {

    // Atributos
    private DoubleProperty presupuesto;

    /**
     * Creates a new instance of Comprador
     */
    public Comprador() {
        this(null,null,null,null);
    }

    public Comprador(String nombre, String apellido, String nroDocumento, Double presupuesto) {
        super(nombre, apellido, nroDocumento);
        this.presupuesto = new SimpleDoubleProperty(presupuesto);

    }

    public String toString() {
        return super.toString() + " Presupuesto: $" + getPresupuesto();
    }

    public double getPresupuesto() {
        return presupuesto.get();
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto.set(presupuesto);
    }

}
