/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import DAOS.UsuariosDao;
import ObjetosNegocio.Municipio;
import ObjetosNegocio.Usuario;

/**
 *
 * @author Jaime Valdez
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UsuariosDao usuariosdao = new UsuariosDao();
        
        Usuario usu = new Usuario();
        Municipio muni = new Municipio();
        muni.setNombre("cajeme");
        usuariosdao.guardar(new Usuario("David Picos", "david@gmail.com", "aplicacionesweb", "64445879523", muni, "hombre"));
        
        
    }
    
}
