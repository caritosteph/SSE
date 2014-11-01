/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
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
        Spark.post("/registro", (req, res) -> {
            DAOFactory df = DAOFactory.getDAOFactory();
            UsuarioDAO usuarioDAO = df.getUsuarioDAO();
            Usuario u = new Usuario(req.queryParams("email"), true, req.queryParams("password"), req.queryParams("username"));
            usuarioDAO.insertUsuario(u);
            res.redirect("/home_egresado.html");
            return null;
        });

        Spark.post("/login", (req, res) -> {
            HttpSession sesion = request.getSession();
            DAOFactory df = DAOFactory.getDAOFactory();
            UsuarioDAO usuarioDAO = df.getUsuarioDAO();
            Usuario u = null;
            try {
                u = (Usuario) usuarioDAO.findUsuario(req.queryParams("email"), req.queryParams("password"));
                if (u != null) {
                    res.redirect("/home_egresado.html");
                } else {
                   res.redirect("/index.html");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        });

    }
}
