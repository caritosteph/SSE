/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo.dominio;

/**
 *
 * @author crojas
 */
public class Alumno extends Usuario{
    private String idAlumno;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String anioPromocion;
    private String cvurl;
    private String dni;
    private String especialidad;
    private String faclutad;
    private String fechaNacimiento;
    private String fotoUrl;
    private String genero;
    private String nacionalidad;

    public Alumno() {
    }
    
    public Alumno(String idAlumno, String nombres, String apellidos, String direccion, String anioPromocion, String cvurl, String dni, String especialidad, String faclutad, String fechaNacimiento, String fotoUrl, String genero, String nacionalidad, String correo, boolean habilitado, String password, String telefono) {
        super(correo, habilitado, password, telefono);
        this.idAlumno = idAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.anioPromocion = anioPromocion;
        this.cvurl = cvurl;
        this.dni = dni;
        this.especialidad = especialidad;
        this.faclutad = faclutad;
        this.fechaNacimiento = fechaNacimiento;
        this.fotoUrl = fotoUrl;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }
    
    
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAnioPromocion() {
        return anioPromocion;
    }

    public void setAnioPromocion(String anioPromocion) {
        this.anioPromocion = anioPromocion;
    }

    public String getCvurl() {
        return cvurl;
    }

    public void setCvurl(String cvurl) {
        this.cvurl = cvurl;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFaclutad() {
        return faclutad;
    }

    public void setFaclutad(String faclutad) {
        this.faclutad = faclutad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
    
    
}
