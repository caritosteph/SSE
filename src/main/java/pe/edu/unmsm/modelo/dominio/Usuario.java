/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.unmsm.modelo.dominio;

/**
 *
 * @author Sadhu
 */
public class Usuario {

    private int idUsuario;
    private String correo;
    private boolean habilitado;
    private String password;
    private String username;

    public Usuario() {
    }

    public Usuario(String correo, boolean habilitado, String password, String username) {
        this.correo = correo;
        this.habilitado = habilitado;
        this.password = password;
        this.username = username;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
