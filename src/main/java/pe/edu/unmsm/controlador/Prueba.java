/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import org.javalite.activejdbc.Base;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.modelo.dao.PropertiesLoader;

/**
 *
 * @author Sadhu
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Base.open(PropertiesLoader.driver, PropertiesLoader.url, PropertiesLoader.user,PropertiesLoader.password);
        Usuario u = new Usuario();
        u.set("correo","gianmarco@jdbc.com");
        u.set("password", "holamundo");
        u.set("habilitado", true);
        u.set("username", true);
        u.saveIt();
    }
    
}
