package ar.com.educacionit.base.entidades;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Persona.java
 *
 */
public abstract class Persona {

    // Atributos
    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty numeroDocumento;

    /**
     * Creates a new instance of Persona
     */
    public Persona() {
        this(null,null,null);
    }

    public Persona(String nombre, String apellido, String numeroDocumento) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
    }

    // metodo toString()
    @Override
    public String toString() {
        return nombre.get() + " " + apellido.get() + " DNI:" + numeroDocumento.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public String getNumeroDocumento() {
        return numeroDocumento.get();
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento.set(numeroDocumento);
    }

}
