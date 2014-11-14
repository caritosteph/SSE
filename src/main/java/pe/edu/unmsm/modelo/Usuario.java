/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Sadhu
 */
public class Usuario extends Model{
    /*
    String nombres;
    String apellidos;
    public void getAll(){
        nombres= getString("nombres");
        apellidos= getString("apellidos");
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }*/
    
    public String getNombres(){
        return getString("nombres");
    }
    
    public String getApellidos(){
        return getString("apellidos");
    }
}
