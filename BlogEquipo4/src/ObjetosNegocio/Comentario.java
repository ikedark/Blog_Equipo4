/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Jaime Valdez
 */
public class Comentario {
    private ObjectId id;
    private Date Fecha_Hora;
    private String Comentario;
    private Usuario Creador;

    public Comentario() {
    }

    public Comentario(Date Fecha_Hora) {
        this.Fecha_Hora = Fecha_Hora;
    }

    public Comentario(Date Fecha_Hora, String Comentario) {
        this.Fecha_Hora = Fecha_Hora;
        this.Comentario = Comentario;
    }

    public Comentario(Date Fecha_Hora, String Comentario, Usuario Creador) {
        this.Fecha_Hora = Fecha_Hora;
        this.Comentario = Comentario;
        this.Creador = Creador;
    }

    public Comentario(ObjectId id, Date Fecha_Hora, String Comentario, Usuario Creador) {
        this.id = id;
        this.Fecha_Hora = Fecha_Hora;
        this.Comentario = Comentario;
        this.Creador = Creador;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha_Hora() {
        return Fecha_Hora;
    }

    public void setFecha_Hora(Date Fecha_Hora) {
        this.Fecha_Hora = Fecha_Hora;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public Usuario getCreador() {
        return Creador;
    }

    public void setCreador(Usuario Creador) {
        this.Creador = Creador;
    }
    
    public String formattedDate(){
       SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE dd MMMM 'del' yyyy 'Hora: 'HH:mm:SS");
       String date = DATE_FORMAT.format(this.Fecha_Hora);
       return date;       
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", Fecha_Hora=" + Fecha_Hora + ", Comentario=" + Comentario + ", Creador=" + Creador + '}';
    }
    
    
    
}
