/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo.dao.nuodb;

import java.util.List;
import pe.edu.unmsm.modelo.dao.AlumnoDAO;
import pe.edu.unmsm.modelo.dominio.Alumno;
import pe.edu.unmsm.modelo.dominio.Usuario;


public class NuoDBAlumnoDAO extends NuoDBUsuarioDAO implements AlumnoDAO {

    @Override
    public int insert(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
