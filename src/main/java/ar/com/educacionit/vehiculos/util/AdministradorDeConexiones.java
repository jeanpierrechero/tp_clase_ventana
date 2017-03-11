/*
 * AdministradorDeConexiones.java
 *
 *
 */

package ar.com.educacionit.vehiculos.util;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class AdministradorDeConexiones {
    
    /**
     * Creates a new instance of AdministradorDeConexiones
     */
    public AdministradorDeConexiones() {
    }

    public static Connection getConnection() throws Exception
    {

        // Establece el nombre del driver a utilizar
        String dbDriver = "com.mysql.jdbc.Driver";
        
        // Establece la conexion a utilizar contra la base de datos
        String dbConnString = "jdbc:mysql://192.168.10.14/j2se"; //"jdbc:h2:~/j2se;INIT=RUNSCRIPT FROM 'classpath:ddl/autos-h2.sql'";
        
        // Establece el usuario de la base de datos
        String dbUser = "root";
        
        // Establece la contraseña de la base de datos
        String dbPassword = "bvs$$123";

        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }    
    
}
