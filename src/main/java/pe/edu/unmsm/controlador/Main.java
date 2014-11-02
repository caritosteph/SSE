/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import pe.edu.unmsm.modelo.Util;
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
            Util.conectarBD();
            Usuario u =new Usuario();
            u.set("username", req.queryParams("username"));
            u.set("email", req.queryParams("email"));
            String password=req.queryParams("password");
            String encriptada=Util.encriptar(password);
            
            u.set("password", encriptada);
            u.saveIt();
            res.redirect("/home_egresado.html");
            return null;
        });

        Spark.post("/login", (req, res) -> {
            Util.conectarBD();
            String encriptada=Util.encriptar(req.queryParams("password"));
            Usuario u = Usuario.findFirst("email=? and password=?", req.queryParams("email"),encriptada);
           
            if (u != null) {
                res.redirect("/home_egresado.html");
            } else {
               res.redirect("/index.html");
            }
            return null;
        });
        
        Spark.post("/recuperar", (req, res) -> {
            Util.conectarBD();
            res.redirect("/home_egresado.html");
            return null;
        });

    }
}
