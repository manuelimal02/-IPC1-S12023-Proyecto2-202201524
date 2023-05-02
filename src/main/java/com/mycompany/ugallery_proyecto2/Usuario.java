package com.mycompany.ugallery_proyecto2;
import java.util.ArrayList;
/**
 *
 * @author manuel
 */
public class Usuario {
    
    public String NombreUsuario; 
    ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
    
    public void agregarCategoria(Categoria categoria) {
        this.listaCategoria.add(categoria);
    }
    
    public void ImprimirCategorias() {
        for (int i = 0; i <listaCategoria.size(); i++) {
            System.out.println(listaCategoria.get(i).getNombreCategoria());    
        }
        System.out.println("----------------------------------------------");
    }
    
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }


    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
}
