/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import org.javalite.activejdbc.Base;
import pe.edu.unmsm.modelo.DB;
import pe.edu.unmsm.modelo.PropertiesLoader;
import pe.edu.unmsm.modelo.Usuario;
import spark.Spark;

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
        Spark.post("/registro", (req, res) -> {
            DB.conectar();
            Usuario u =new Usuario();
            u.set("username", req.queryParams("username"));
            u.set("email", req.queryParams("email"));
            u.set("password", req.queryParams("password"));
            u.saveIt();
            res.redirect("/home_egresado.html");
            return null;
        });

        Spark.post("/login", (req, res) -> {
            DB.conectar();
            Usuario u = Usuario.findFirst("email=? and password=?", req.queryParams("email"),req.queryParams("password"));
           
            if (u != null) {
                res.redirect("/home_egresado.html");
            } else {
               res.redirect("/index.html");
            }
            return null;
        });

    }
}
