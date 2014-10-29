/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.controlador;

import pe.edu.unmsm.modelo.dao.DAOFactory;
import pe.edu.unmsm.modelo.dao.UsuarioDAO;
import pe.edu.unmsm.modelo.dominio.Usuario;

/**
 *
 * @author crojas
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAOFactory df=DAOFactory.getDAOFactory();
        UsuarioDAO usuarioDAO=df.getUsuarioDAO();
        usuarioDAO.insertUsuario(new Usuario("chavodel8@gmail.com", true, "quebonitavecindad"));
    }
    
}
