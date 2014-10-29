/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.controlador;

import pe.edu.unmsm.modelo.dao.DAOFactory;
import pe.edu.unmsm.modelo.dao.UsuarioDAO;
import pe.edu.unmsm.modelo.dominio.Usuario;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;


/**
 *
 * @author Sadhu
 */
public class Main {
    public static void main(String[] args) {
        
        
        Spark.staticFileLocation("/public");
        
        /*Spark.post("/registro",(req,res) ->{
            
            return new ModelAndView(null, "registrarse.ftl.html");
        }, new FreeMarkerEngine());*/
        
        Spark.post("/registro", (req,res)->{
               DAOFactory df=DAOFactory.getDAOFactory();
               UsuarioDAO usuarioDAO=df.getUsuarioDAO();
               Usuario u=new Usuario(req.queryParams("correo"), true, req.queryParams("password"));
               usuarioDAO.insertUsuario(u);
               return "Ud. ha elegido la fruta "+req.queryParams("nombre");
       });
        Spark.get("/hello", (req, res) -> "Hola mundo");
    }
}
