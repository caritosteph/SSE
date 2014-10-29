/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao;

import java.sql.SQLException;
import java.util.List;
import pe.edu.unmsm.modelo.dominio.Usuario;

/**
 *
 * @author Sadhu
 */
public interface UsuarioDAO {
    public List<Usuario> selectUsuarios();
    public Usuario findUsuario(String correo,String password) throws SQLException;
    public int insertUsuario(Usuario u);
    public boolean updateUsuario();
    public boolean deleteUsuario();
    
}
