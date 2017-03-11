/*
 * TestAutos.java
 *
 */
package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;

import java.sql.Connection;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@educacionIT.com.ar>
 */
public class TestAutos {

    /**
     * Creates a new instance of TestAutos
     */
    public TestAutos() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Obtiene la conexion
        Connection conn = AdministradorDeConexiones.getConnection();

        // Caso #1 -- Obtener autos, e informarlos /////////////////////////////////////
        /*
         ArrayList autos = Auto.obtenerTodos(conn);
         Iterator it = autos.iterator();
         while (it.hasNext()) {
         Auto a = (Auto) it.next();
         System.out.println(a);
         }
         */
        // Caso #2 -- Obtiene un auto, y lo informa /////////////////////////////////////
        /*
         Auto a = Auto.obtenerSegunId(conn, 1);
         System.out.println(a);
         */
        // Caso #3 -- Inserta un auto /////////////////////////////////////
        Auto a = new Auto();
        a.setMarca("Citroen");
        a.setModelo("2007");
        a.setColor("Rojo");
        a.setPrecio(18000.0);
        a.setAltura(150);
        a.setAncho(180);
        a.setLargo(345);
        a.setEquipamiento("aqui va el equipamiento");
        
        Integer id = a.insertar(conn);

        System.out.println(id);
        
        // Caso #4 -- Obtiene un auto, y lo modifica /////////////////////////////////////
        /*
         Auto a = Auto.obtenerSegunId(conn, 3);
         if(a != null)
         {
         a.setPrecio(15000.0);  // Modifica el precio
         a.setColor("Negro");  // Modifica el color
         a.actualizar(conn);
         }
         */
        // Caso #5 -- Obtiene un auto, y lo elimina /////////////////////////////////////
        /*
         Auto a = Auto.obtenerSegunId(conn, 2);
         if(a != null)
         {
         a.eliminar(conn);
         }
         */
    }

}
