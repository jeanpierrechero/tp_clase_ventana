/*
 * CONSTANTES.java
 *
 */

package ar.com.educacionit.vehiculos.util;


/**
 *
 * 
 */
public enum CONSTANTES {
    
    UBICACION_RECURSOS("/ar/com/educacionit/vehiculos/recursos/"),
    COMBO_SIN_SELECCION("Seleccione...");
    
    private String valor;

    private CONSTANTES(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
    
    
}
