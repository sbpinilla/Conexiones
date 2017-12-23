/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author sbpinilla
 */
public class MysqlConnection {

    private static String className="com.mysql.jdbc.Driver";
    
    
    private static String url = "jdbc:mysql://localhost/nombreBD";

    //El usuario de la base de datos
    private static String user = "USUARIO";

    //La clave del usuario de la base de datos
    private static String password = "PASSWORD";

    //Metodo para obtener la conexion con la base de datos
    public static synchronized Connection getConexion() {
        Connection cn = null;
        try {
            //Cargamos el driver y le decimos que vamos a usar
            //una conexion con mysql
            Class.forName(className);
            //Obtenemos la conexion
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            cn = null;
        } finally {
            return cn;
        }
    }

    //Metodo utilizado para cerrar el callablestatemente
    public static synchronized void cerrarCall(CallableStatement cl) {
        try {
            cl.close();
        } catch (Exception e) {
        }
    }

    //Metodo utilizado para cerrar el resulset de datos
    public static synchronized void cerrarConexion(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
        }
    }

    //Metodo utilizado para cerrar la conexion
    public static synchronized void cerrarConexion(Connection cn) {
        try {
            cn.close();
        } catch (Exception e) {
        }
    }

    //Metodo utilizado para deshacer los cambios en la base de datos
    public static synchronized void deshacerCambios(Connection cn) {
        try {
            cn.rollback();
        } catch (Exception e) {
        }
    }

}
