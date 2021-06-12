/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.io.File;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author David
 */
public class Usuario {
    private ObjectId id;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private File avatar;
    private Municipio municipio;
    private Date fechaNacimiento;
    private String genero;

    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, File avatar, Municipio municipio, Date fechaNacimiento, String genero) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.avatar = avatar;
        this.municipio = municipio;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public File getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasena=" + contrasena + ", telefono=" + telefono + ", avatar=" + avatar + ", municipio=" + municipio + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }
    
    

    
}
