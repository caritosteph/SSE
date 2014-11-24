/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.javalite.activejdbc.Base;
import pe.edu.unmsm.modelo.Alumno;
import pe.edu.unmsm.modelo.Util;
import pe.edu.unmsm.modelo.Usuario;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.halt;
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
             //herencia
            Alumno a=new Alumno();
            u.add(a);
            Base.close();
            //fin herencia
            HashMap<Object, Object> data=new HashMap<>();
            data.put("mensaje", "Ud. ha sido registrado satisfactoriamente");
            return new ModelAndView(data, "index.ftl.html");
        },new FreeMarkerEngine());

        Spark.post("/login", (req, res) -> {
            Util.conectarBD();
            String encriptada=Util.encriptar(req.queryParams("password"));
            Usuario u = Usuario.findFirst("email=? and password=?", req.queryParams("email"),encriptada);
            Base.close();
            if (u != null) {
                res.redirect("/home_egresado");
                Session s=req.session(true);
                s.attribute("email", req.queryParams("email"));
                
            } else {
               HashMap<Object, Object> data=new HashMap<>();
               data.put("mensaje", "Su usuario y contraseña no coinciden");
               return new ModelAndView(data, "index.ftl.html");
            }
            return null; //debe eliminarse este null
        },new FreeMarkerEngine());
        
        Spark.get("/home_egresado", (req, res) -> {
            Util.conectarBD();
           
            Base.close();

            HashMap<Object, Object> data=new HashMap<>();
            data.put("mensaje", "Porfavor sírvase llenar la encuesta de egresados 2014");
            return new ModelAndView(data, "home_egresado.ftl.html");

        },new FreeMarkerEngine());
        
        Spark.post("/recuperar", (req, res) -> {
            String email=req.queryParams("email");
            Util.conectarBD();
            Usuario u=Usuario.findFirst("email=?", email);
            String password=u.getString("password");
            Base.close();
            String mensaje="<a href='http://localhost:4567/cambiar_contrasena/"+email+"/"+password+"'>Haga clic aquí para recuperar su contraseña</a> <br> <br> SSE-UNMSM";
            Util.enviarCorreo("SSE@gmail.com", email, "Recuperar contraseña", mensaje);
            HashMap<Object, Object> data=new HashMap<>();
            data.put("mensaje", "Se le ha mandado un mensaje para recuperar su contraseña");
            return new ModelAndView(data, "index.ftl.html");
        },new FreeMarkerEngine());
        
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
            Session s=req.session();
            s.attribute("email", email);
            s.attribute("password", password);
            res.redirect("/cambiar_contrasena.html");
            return null;
        });
        
        Spark.post("/cambiar_contrasena", (req, res) -> {
            String nueva=req.queryParams("password");
            String confirmacion=req.queryParams("confirmPassword");
            HashMap<Object, Object> data=new HashMap<>();
            if(nueva.equals(confirmacion)){
                Util.conectarBD();
                String email=req.session().attribute("email");
                Usuario u=Usuario.findFirst("email=?", email);
                u.set("password", Util.encriptar(nueva));
                u.saveIt();
                Base.close();
                
                data.put("mensaje", "Se ha cambiado la contraseña satisfactoriamente");
                return new ModelAndView(data, "index.ftl.html");
            }
            else{
               data.put("mensaje", "No se pudo cambiar la contraseña");
               return new ModelAndView(data, "index.ftl.html");
            }
        },new FreeMarkerEngine());
        
        
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
        
        
        Spark.get("/buscar", (req, res) -> {
            
            String q=req.queryParams("busqueda");
            
            String[] l=q.split(" ");
            List<Usuario> usuarios=null;
            if(l.length>0){
                String query="";
                for (String s : l) {
                    if(!query.equals(""))
                        query+=" and ";
                    query+="(lcase(nombres) like '%"+s+"%' or lcase(apellidos) like '%"+s+"%')";
                }
                Util.conectarBD();
                usuarios=Usuario.where(query).load();
                
            }
            Base.close();
            HashMap<Object, Object> data=new HashMap<>();
            data.put("busqueda",q);
            data.put("usuarios", usuarios);
            
            return new ModelAndView(data, "buscar_egresado.ftl.html");
        },new FreeMarkerEngine());
        
        Spark.post("/modificar_perfil", (req, res) -> {
            Util.conectarBD();
            
            String email=req.queryParams("email");
            
            Usuario u=Usuario.findFirst("email=?", email);
            
            Alumno a=u.getAll(Alumno.class).get(0);

            a.set("nombres", u.get("nombres"));
            a.set("apellidos", u.get("apellidos"));
            a.set("fecha_nacimiento", req.queryParams("fecha_nacimiento"));
            a.set("dni",req.queryParams("dni"));
            a.set("direccion",req.queryParams("direccion"));
            a.set("distrito",req.queryParams("distrito"));
            a.set("telefono_fijo",req.queryParams("telefono_fijo"));
            a.set("telefono_movil",req.queryParams("telefono_movil"));
            a.set("universidad",req.queryParams("universidad"));
            a.set("facultad",req.queryParams("facultad"));
            a.set("especialidad",req.queryParams("especialidad"));
            a.set("anio_egreso",req.queryParams("anio_egreso"));
            a.set("facebook",req.queryParams("facebook"));
            a.set("linkedin",req.queryParams("linkedin"));
            a.set("twitter",req.queryParams("twitter"));
            a.set("estado_civil",req.queryParams("estado_civil"));
            a.set("genero",req.queryParams("genero"));
            a.saveIt();
            Base.close();
            HashMap<Object, Object> data=new HashMap<>();
            data.put("mensaje", "Ud. ha sido registrado satisfactoriamente");
            return new ModelAndView(data, "index.ftl.html");
        },new FreeMarkerEngine());
        

    }
}
