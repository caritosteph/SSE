/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao;

import java.util.List;
import pe.edu.unmsm.modelo.dominio.Usuario;

/**
 *
 * @author Sadhu
 */
public interface UsuarioDAO {
    List<Usuario> selectUsuarios();
    Usuario findUsuario();
    int insertUsuario(Usuario u);
    boolean updateUsuario();
    boolean deleteUsuario();
    
}
