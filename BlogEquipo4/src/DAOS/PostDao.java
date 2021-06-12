/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Post;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
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
        MongoCollection<Post> coleccion = this.getColection();
        FindIterable<Post> Post = coleccion.find();
        ArrayList<Post> listaPost = new ArrayList<>();
        for (Post post : Post) {
            listaPost.add(post);
        }
        return listaPost;
    }
    
    
    public ArrayList<Comentario> ConsultarComentariosPublicacion(Post entidad){
        return entidad.getContenido();
    }

    @Override
    public Post consultarPorId(ObjectId id) {
        MongoCollection<Post> coleccion = this.getColection();
        Post Publicacion = coleccion.find(eq("_id", id)).first();
        return Publicacion;
    }
    
    public Post consultarPorId(String id) {
        return this.consultarPorId(new ObjectId(id));
    } 

    @Override
    public void actualizar(Post entidad) {
        MongoCollection<Post> coleccion = this.getColection();
        coleccion.updateOne(
                eq("_id", entidad.getId()),
                combine(
                        set("contenido", entidad.getContenido()),
                        set("comentarios",entidad.getContenido())
                )
        );
    }
    
    public void actualizarComentario(Post entidad, Comentario comentario){
        for (int i = 0; i < entidad.getContenido().size(); i++) {
            if (entidad.getContenido().get(i).equals(comentario)) {
                entidad.getContenido().set(i, comentario);
                this.actualizar(entidad);
            }
        }
    }
    
    @Override
    public void eliminar(Post entidad) {
        Post publicacion = this.consultarPorId(entidad.getId());
        if (publicacion != null) {
            MongoCollection<Post> coleccion = this.getColection();
            coleccion.deleteOne(eq("_id", entidad.getId()));
        }
    }

    @Override
    protected MongoCollection<Post> getColection() {
        MongoDatabase database = this.getMongoDatabase();
        MongoCollection<Post> coleccion = database.getCollection("Post", Post.class);
        return coleccion;
    }
    
}
