package ar.com.educacionit.base.entidades;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/*
 * Vehiculo.java
 *
 */

public abstract class Vehiculo {

    // Atributos
    private IntegerProperty ancho;
    private IntegerProperty largo;
    private IntegerProperty altura;

    /**
     * Creates a new instance of Vehiculo
     */
    public Vehiculo() {
        this(0,0,0);
    }

    public Vehiculo(Integer ancho, Integer largo, Integer altura) {
        this.ancho = new SimpleIntegerProperty(ancho);
        this.largo = new SimpleIntegerProperty(largo);
        this.altura = new SimpleIntegerProperty(altura);
    }

    public String toString() {
        return "Altura:" + altura.get() + "cm - Ancho:" + ancho.get() + "cm - Largo:" + largo.get();
    }

    public int getAncho() {
        return ancho.get();
    }

    public void setAncho(int ancho) {
        this.ancho.set(ancho);
    }

    public int getLargo() {
        return largo.get();
    }

    public void setLargo(int largo) {
        this.largo.set(largo);
    }

    public int getAltura() {
        return altura.get();
    }

    public void setAltura(int altura) {
        this.altura.set(altura);
    }

}
