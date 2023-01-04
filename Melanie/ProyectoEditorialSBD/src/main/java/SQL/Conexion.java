/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Conexion {
    private Connection cn=null;
    private Statement st=null;
    
    public void conectar()
    {   String url="jdbc:mysql://localhost/editorial";
        String user="root";
        String pass="root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection(url, user,pass);
            if(cn!=null)
            {
                st=cn.createStatement();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void desconectar() throws SQLException
    {
        if(st!=null)
        {
            st.close();
        }
        if(cn!=null)
        {
            cn.close();
        }
    }

    public Connection getCn() {
        return cn;
    }

    public Statement getSt() {
        return st;
    }
}
