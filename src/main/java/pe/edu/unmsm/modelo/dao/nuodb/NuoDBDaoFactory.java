/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao.nuodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.edu.unmsm.modelo.dao.DAOFactory;
import pe.edu.unmsm.modelo.dao.PropertiesLoader;
import pe.edu.unmsm.modelo.dao.UsuarioDAO;

/**
 *
 * @author Sadhu
 */
public class NuoDBDaoFactory extends DAOFactory{
    public static Connection createConection() {
        
    try {
        // Load the driver
        Class.forName(PropertiesLoader.driver);
        // Create the connection
        Connection conn = DriverManager.getConnection(PropertiesLoader.url, PropertiesLoader.user, PropertiesLoader.password);

        //Do Something with your connection
    } 
    catch (ClassNotFoundException e) {
        System.out.println("Class Not found Exception cought");
        e.printStackTrace();
    } 
    catch (SQLException e) {
        e.printStackTrace();
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new NuoDBUsuarioDAO();
    }
    
}
