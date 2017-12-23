/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sbpinilla
 */
public class Conexiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Connection conn = null;
        
        try {
            
            conn = SqlServerConnection.getConexion();
            ResultSet rs;
            PreparedStatement ps = conn.prepareStatement("select * from tblTipoUsuario");
            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("id:" + rs.getString("iIDTipoUsuario"));
                System.out.println("Nombre:" + rs.getString("tTipoUsuario"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            SqlServerConnection.cerrarConexion(conn);
        }

    }

}
