/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrián
 */
public class ListaProductos {
    
    public enum ORDERBY {
        alfabetico, precio, puntuacion, fecha
    };
    
    private static final String URL = "jdbc:mysql://192.168.2.191:3306/tienda";
    private static final String USER = "alumno";
    private static final String PASS = "alumno";
    
    private static final int LIMIT = 10;
    
    public static List<Producto> getNoticias(String busqueda, ORDERBY orden){
        LinkedList<Producto> productos = new LinkedList<>();
        String consulta = "select * from Productos WHERE nombre LIKE ? ";
        switch (orden) {
            case alfabetico:
                consulta+="ORDER BY nombre";
                break;
            case precio:
                consulta+="ORDER BY precio";
                break;
            case puntuacion:
                consulta+="ORDER BY puntuacion DESC";
                break;
            case fecha:
                consulta+="ORDER BY fechaInicio";
                break;
        }
        consulta += " LIMIT "+LIMIT;
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection conexion= DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement sentencia= conexion.prepareStatement(consulta);
            sentencia.setString(1, "%"+busqueda+"%");
            ResultSet rs = sentencia.executeQuery();
            
            while (rs.next()) {
                productos.add(new Producto (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDate(7)
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e.getClass().getName()+":\n"+e.getMessage());
        }
        
        return productos;
    }
}