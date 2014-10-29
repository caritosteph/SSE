/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sadhu
 */
public class PropertiesLoader {
    private static String FILENAME="properties/db.properties";
    public static String dbms;
    public static String url;
    public static String driver;
    public static String user;
    public static String password;
    public static Properties prop;
    
    static{
        prop=new Properties();
        try {
            prop.load(new FileInputStream(FILENAME));
        } catch (IOException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        url=prop.getProperty("url");
        driver=prop.getProperty("driver");
        user=prop.getProperty("user");
        password=prop.getProperty("password");
        dbms=prop.getProperty("dbms");
    }
}
