/*
 * Comprador.java
 *
 */
package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Comprador extends Persona {

    // Atributos
    private DoubleProperty presupuesto;
    private Integer id;
    private boolean modificado = false;

    /**
     * Creates a new instance of Comprador
     */
    public Comprador() {
        this(null,null,null,0D);
    }

    public Comprador(String nombre, String apellido, String nroDocumento, Double presupuesto) {
        super(nombre, apellido, nroDocumento);
        this.presupuesto = new SimpleDoubleProperty(presupuesto);

    }

    /*
    public Comprador(Double presupuesto, Integer id, String nombre, String apellido, String numeroDocumento) {
        super(nombre, apellido, numeroDocumento);
        this.presupuesto = new SimpleDoubleProperty (presupuesto);
        this.id = id;
    }*/
    public DoubleProperty presupuestoProperty(){
        return presupuesto;
    }
       

    public String toString() {
        return super.toString() + " Presupuesto: " + presupuesto.get();
    }

    public double getPresupuesto() {
        return presupuesto.get();
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto.set(presupuesto);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public boolean estaModificado() {
        return modificado;
    }

    public void setModificado() {
        this.modificado = true;
    }
    
    
    /*
    public static List<Comprador> obtenerTodos(Connection conn) throws Exception {
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM compradores";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laConsulta);

        // Construye la coleccion de autos
        List<Comprador> compradores = new ArrayList<>();

        // Muestra los datos
        while (rs.next()) {
            // Arma el objeto auto con los datos de la consulta
            Comprador c = new Comprador(rs.getDouble("co_presupuesto"), rs.getInt("co_id"), 
                    rs.getString("co_nombre"), rs.getString("co_apellido"), rs.getString("co_documento"));

            // Agrega el auto a la coleccion
            compradores.add(c);
        }
        // Cierra el Statement
        stmtConsulta.close();

        // Retorna la coleccion
        return compradores;
    }
*/
    public static List<Comprador> obtenerTodos(Connection conn) throws Exception {
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM compradores";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laConsulta);

        // Construye la coleccion de autos
        List<Comprador> compradores = new ArrayList<>();

        // Muestra los datos
        while (rs.next()) {
            // Arma el objeto auto con los datos de la consulta
            Comprador c = new Comprador();
            c.setId(rs.getInt("co_id"));
            c.setNombre(rs.getString("co_nombre"));
            c.setApellido(rs.getString("co_apellido"));
            c.setNumeroDocumento(rs.getString("co_documento"));
            c.setPresupuesto(rs.getDouble("co_presupuesto"));

            // Agrega el auto a la coleccion
            compradores.add(c);
        }
        // Cierra el Statement
        stmtConsulta.close();

        // Retorna la coleccion
        return compradores;
    }
    
    public Integer insertar(Connection conn) throws Exception {
        // Arma la sentencia de inserción
        String laInsercion = "INSERT INTO compradores "
                + "(co_nombre, co_apellido, co_documento, co_presupuesto) "
                + " VALUES (?,?,?,?)";

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laInsercion);

        // Ejecuta la insercion
        PreparedStatement ps = conn.prepareStatement(laInsercion, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, getNombre());
        ps.setString(2, getApellido());
        ps.setString(3, getNumeroDocumento());
        ps.setDouble(4, getPresupuesto());
        ps.execute();
        // Obtiene el ID generado
        Integer id = null;
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        // Cierra el Statement
        ps.close();
        return id;
    }

}
