/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import ObjetosNegocio.Usuario;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Jaime Valdez
 */
public class UsuariosDao extends BaseDao<Usuario> {

    @Override
    public void guardar(Usuario entidad) {
        MongoCollection<Usuario> coleccion = this.getColection();
        coleccion.insertOne(entidad);
    }

    @Override
    public ArrayList<Usuario> consultar() {
        MongoCollection<Usuario> coleccion = this.getColection();
        FindIterable<Usuario> usuarios = coleccion.find();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }

    @Override
    public Usuario consultarPorId(ObjectId id) {
        MongoCollection<Usuario> coleccion = this.getColection();
        Usuario usuario = coleccion.find(eq("_id", id)).first();
        return usuario;
    }
    
    public Usuario consultarPorId(String id) {
        return this.consultarPorId(new ObjectId(id));
    }

    @Override
    public void actualizar(Usuario entidad) {
        MongoCollection<Usuario> coleccion = this.getColection();
        Document filtroActualizar = new Document("_id", entidad.getId());
        Document datosActualizados = new Document("$set", new Document("nombre", entidad.getNombreCompleto())
                .append("correo", entidad.getCorreo())
                .append("contraseña", entidad.getContrasena())
                .append("telefono", entidad.getTelefono())
                .append("municipio", entidad.getMunicipio()));
        coleccion.findOneAndUpdate(filtroActualizar, datosActualizados);
    }

    @Override
    public void eliminar(Usuario entidad) {
        Usuario usuario = this.consultarPorId(entidad.getId());
        if (usuario != null) {
            MongoCollection<Usuario> coleccion = this.getColection();
            coleccion.deleteOne(eq("_id", entidad.getId()));
        }
    }

    @Override
    protected MongoCollection<Usuario> getColection() {
        MongoDatabase baseDatos = this.getMongoDatabase();
        MongoCollection<Usuario> colection = baseDatos.getCollection("Usuarios", Usuario.class);
        return colection;
    }
    
}
