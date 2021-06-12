/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Post;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author Jaime Valdez
 */
public class PostDao extends BaseDao<Post>{

    @Override
    public void guardar(Post entidad) {
        MongoCollection<Post> coleccion = this.getColection();
        coleccion.insertOne(entidad);
    }
    
    public void guardarComentario(Post entidad, Comentario comentario) {
        entidad.getContenido().add(comentario);
        this.actualizar(entidad);
    }

    @Override
    public ArrayList<Post> consultar() {
        return null;
    }

    @Override
    public Post consultarPorId(ObjectId id) {
        return null;
    }

    @Override
    public void actualizar(Post entidad) {
        
    }

    @Override
    public void eliminar(Post entidad) {
        
    }

    @Override
    protected MongoCollection<Post> getColection() {
        MongoDatabase database = this.getMongoDatabase();
        MongoCollection<Post> coleccion = database.getCollection("Post", Post.class);
        return coleccion;
    }
    
}
