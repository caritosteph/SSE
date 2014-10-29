/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.controlador;

import java.util.HashMap;
import java.util.Map;
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
        /*Spark.get("/",(req,res) ->{
            return new ModelAndView(null, "home.ftl.html");
        }, new FreeMarkerEngine());*/
        Spark.get("/hello", (req, res) -> "Hola mundo");
    }
}
