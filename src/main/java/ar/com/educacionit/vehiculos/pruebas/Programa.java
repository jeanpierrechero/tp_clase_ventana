/*
 * TestIntegrador02.java
 *
 */
package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.entidades.Comprador;
import ar.com.educacionit.vehiculos.entidades.Vendedor;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@educacionIT.com.ar>
 */
public class Programa {

    /**
     * Creates a new instance of TestIntegrador01
     */
    public Programa() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Construye e informa un auto
        System.out.println("\nCreando un auto....");
        Auto a1 = new Auto("Chevrolet", "Corsa 5P", "Gris", 320, 190, 100,"Equipamiento",50000D);
        System.out.println(a1);

        // Construye e informa un vendedor
        System.out.println("\nCreando un vendedor....");
        Vendedor v1 = new Vendedor("Mario", "Mendoza", "25.689.845", 3);
        System.out.println(v1);

        // Construye e informa un ofertante
        System.out.println("\nCreando un ofertante....");
        Comprador o1 = new Comprador("Mario", "Mendoza", "25.689.845", 20545D);
        System.out.println(o1);

    }

}
