/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo;

import org.javalite.activejdbc.Base;

/**
 *
 * @author Sadhu
 */
public class DB {
    public static void conectar(){
        Base.open(PropertiesLoader.driver, PropertiesLoader.url, PropertiesLoader.user,PropertiesLoader.password);
    }
}
