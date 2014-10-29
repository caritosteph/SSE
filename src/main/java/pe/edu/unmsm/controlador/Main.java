/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.controlador;

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
        Spark.post("/registro",(req,res) ->{
            System.out.println(req.params(:));
            return new ModelAndView(null, "registrarse.ftl.html");
        }, new FreeMarkerEngine());
        Spark.get("/hello", (req, res) -> "Hola mundo");
    }
}
