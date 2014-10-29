/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dao.nuodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import pe.edu.unmsm.modelo.dao.DAOFactory;
import pe.edu.unmsm.modelo.dao.UsuarioDAO;
import pe.edu.unmsm.modelo.dominio.Usuario;

/**
 *
 * @author Sadhu
 */
public class NuoDBUsuarioDAO implements UsuarioDAO{

    @Override
    public List<Usuario> selectUsuarios(){
        try {
            Usuario u=new Usuario();
            Connection conn=NuoDBDaoFactory.createConnection();
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from Usuario");
            //falta
        } catch (SQLException ex) {
            Logger.getLogger(NuoDBUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insertUsuario(Usuario u) {
        try {
            String sql="insert into Usuario(correo, habilitado, password, telefono) values (?,?,?,?)";
            Connection conn=NuoDBDaoFactory.createConnection();
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, u.getCorreo());
            stmt.setBoolean(2, u.isHabilitado());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getTelefono());
            return stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NuoDBUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public boolean updateUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
