/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo.dao;

import pe.edu.unmsm.modelo.dominio.Alumno;

/**
 *
 * @author crojas
 */
public interface AlumnoDAO extends UsuarioDAO{
   int insert(Alumno a);
}
