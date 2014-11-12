/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        Spark.get("/",(req,res) ->{
            
         return new ModelAndView(null, "index.ftl.html");
         },new FreeMarkerEngine());
        
        Spark.post("/registro", (req, res) -> {
            Util.conectarBD();
            Usuario u =new Usuario();

            u.set("email", req.queryParams("email"));
            Usuario existente=Usuario.findFirst("email=?", req.queryParams("email"));
            if(existente!=null){
                HashMap<Object, Object> data=new HashMap<>();
                data.put("mensaje", "El correo ya ha sido registrado antes");
                return new ModelAndView(data, "index.ftl.html");
            }
            
            u.set("nombres", req.queryParams("nombres"));
            u.set("apellidos", req.queryParams("apellidos"));
            String password=req.queryParams("password");
            String encriptada=Util.encriptar(password);
            u.set("password", encriptada);
            u.saveIt();
            HashMap<Object, Object> data=new HashMap<>();
            data.put("mensaje", "Ud. ha sido registrado satisfactoriamente");
            return new ModelAndView(data, "index.ftl.html");
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
               res.redirect("/index.ftl.html");
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
        
        Spark.post("/contacto", (req,res)->{
            String nombre=req.queryParams("nombre");
            String email=req.queryParams("email");
            String asunto=req.queryParams("asunto");
            String mensaje=req.queryParams("mensaje");
            Util.enviarCorreo(email, "carlos.sadhu@gmail.com", asunto, mensaje+"<br><br>"+nombre);
            HashMap<Object, Object> data=new HashMap<>();
            return new ModelAndView(null, "index.ftl.html");
        },new FreeMarkerEngine());
        
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
        
        
        Spark.get("/buscar/:q", (req, res) -> {
            Util.conectarBD();
            String q=req.params(":q");
            System.out.println(q);
            
            String[] l=q.split(" ");
            List<Usuario> usuarios=null;
            if(l.length>0){
                String query="";
                for (String s : l) {
                    if(!query.equals(""))
                        query+=" and ";
                    query+="nombre='"+s+"'";
                }
                usuarios=Usuario.where(query);
            }
            /*
            HashMap<Object, Object> data=new HashMap<>();
            data.put("usuarios", usuarios);
            return new ModelAndView(data, "buscar_egresado.ftl.html");*/
            return usuarios;
        });
        
        

    }
}
