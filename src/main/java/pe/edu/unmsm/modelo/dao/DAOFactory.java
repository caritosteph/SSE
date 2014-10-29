/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao;

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
                //se puede implementar
            default:
                return null;
        }
    }
    

    public abstract UsuarioDAO getUsuarioDAO();
    
}
