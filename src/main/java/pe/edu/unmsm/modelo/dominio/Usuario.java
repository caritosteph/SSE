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
    private String correo;
    private boolean habilitado;
    private String password;

    public Usuario() {
    }
    
    public Usuario(String correo, boolean habilitado, String password) {
        this.correo = correo;
        this.habilitado = habilitado;
        this.password = password;
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
    
    
    
}
