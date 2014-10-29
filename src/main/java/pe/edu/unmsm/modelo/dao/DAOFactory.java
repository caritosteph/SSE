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
import pe.edu.unmsm.modelo.dao.nuodb.NuoDBDaoFactory;

/**
 *
 * @author Sadhu
 */
public abstract class DAOFactory {

    public DAOFactory getDAOFactory(){
        switch(PropertiesLoader.dbms){
            case "nuodb":
                return new NuoDBDaoFactory();
            case "mongodb":
                //falta implementar
            default:
                return null;
        }
    }
    

    public abstract UsuarioDAO getUsuarioDAO();
    
}
