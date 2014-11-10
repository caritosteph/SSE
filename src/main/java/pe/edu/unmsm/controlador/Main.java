/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import java.util.HashMap;
import pe.edu.unmsm.modelo.Util;
import pe.edu.unmsm.modelo.Usuario;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author Sadhu
 */
public class Main {

    public static void main(String[] args) {

        Spark.staticFileLocation("/public");
//
//        Spark.get("/",(req,res) ->{
//            
//         return new ModelAndView(null, "index.ftl.html");
//         },new FreeMarkerEngine());
        
        Spark.post("/registro", (req, res) -> {
            Util.conectarBD();
            Usuario u =new Usuario();
            u.set("username", req.queryParams("username"));
            u.set("email", req.queryParams("email"));
            String password=req.queryParams("password");
            String encriptada=Util.encriptar(password);
            
            Usuario existente=Usuario.findFirst("username=?", req.queryParams("username"));
            if(existente!=null){
                HashMap<Object, Object> data=new HashMap<>();
                data.put("error", "El nombre de usuario ya ha sido registrado antes");
                return new ModelAndView(data, "index.html");
            }
            
            existente=Usuario.findFirst("email=?", req.queryParams("email"));
            if(existente!=null){
                HashMap<Object, Object> data=new HashMap<>();
                data.put("error", "El correo ya ha sido registrado antes");
                return new ModelAndView(data, "index.html");
            }
              
            u.set("password", encriptada);
            u.saveIt();
            HashMap<Object, Object> data=new HashMap<>();
            data.put("error", "Ud. ha sido registrado satisfactoriamente");
            return new ModelAndView(data, "index.html");
        },new FreeMarkerEngine());

        Spark.post("/login", (req, res) -> {
            Util.conectarBD();
            String encriptada=Util.encriptar(req.queryParams("password"));
            Usuario u = Usuario.findFirst("email=? and password=?", req.queryParams("email"),encriptada);
           
            if (u != null) {
                res.redirect("/home_egresado.html");
                Session s=req.session(true);
                s.attribute("email", req.queryParams("email"));
                
            } else {
               res.redirect("/index.html");
            }
            return null;
        });
        
        Spark.post("/recuperar", (req, res) -> {
            String email=req.queryParams("email");
            Util.conectarBD();
            Usuario u=Usuario.findFirst("email=?", email);
            String password=u.getString("password");
            String mensaje="<a href='http://localhost:4567/cambiar_contrasena/"+email+"/"+password+"'>Recuperar contraseña</a>";
            Util.enviarCorreo("SSE@gmail.com", email, "Recuperar contrasena", mensaje);
            return "Se le ha mandado correo";
        });
        
        Spark.get("/cambiar_contrasena/:email/:password", (req, res) -> {
            String email=req.params(":email");
            String password=req.params(":password");
            Session s=req.session(true);
            s.attribute("email", email);
            s.attribute("password", password);
            res.redirect("/cambiar_contrasena.html");
            return null;
        });
        
        Spark.post("/cambiar_contrasena", (req, res) -> {
            String nueva=req.queryParams("nueva");
            String confirmacion=req.queryParams("confirmacion");
            if(nueva.equals(confirmacion)){
                Util.conectarBD();
                String email=req.session().attribute("email");
                Usuario u=Usuario.findFirst("email=?", email);
                u.set("password", Util.encriptar(nueva));
                u.saveIt();
                return "Contraseña cambiada";
            }
            else{
               return "No se pudo cambiar contraseña";
            }
        });
        /*
        Spark.post("/cambiar_contrasena", (req, res) -> {
            String nueva=req.queryParams("nueva");
            String confirmacion=req.queryParams("confirmacion");
            if(nueva.equals(confirmacion)){
                Util.conectarBD();
                String email=req.session().attribute("email");
                Usuario u=Usuario.findFirst("email=?", email);
                u.set("password", Util.encriptar(nueva));
                u.saveIt();
            }
            else{
               res.redirect("/home_egresado.html");
            }
            return null;
        });*/
        
        

    }
}
