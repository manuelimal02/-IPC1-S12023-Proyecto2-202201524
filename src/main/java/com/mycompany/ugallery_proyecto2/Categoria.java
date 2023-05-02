package com.mycompany.ugallery_proyecto2;
import Estructura.ListaDobleLoteFoto;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author manuel
 */
public class Categoria {

    private String NombreCategoria;
    private ListaDobleLoteFoto listaImagen= new ListaDobleLoteFoto();
    //Funciones
    public void ImprimirImagenes() {
      listaImagen.Imprimir();
    }
    public void SiguienteImagen(JTextField NombreImagen, JLabel ImagenLBL){
        listaImagen.Siguiente(NombreImagen, ImagenLBL);
    }
    public void AnteriorImagen(JTextField NombreImagen, JLabel ImagenLBL){
        listaImagen.Anterior(NombreImagen, ImagenLBL);
    }
    public void agregarImagen(LoteFoto imagen) {
      listaImagen.add(imagen);
    }
    public void eliminarImagen(LoteFoto imagen) {
      listaImagen.delete(imagen);
    }
    
    public void retornarNombre(JList listaImagenes){
      listaImagen.retornarNombre(listaImagenes);
    }
    
    public void ArrayListRuta(ArrayList<String> listaRutaImagenes){
      listaImagen.ArrayListRuta(listaRutaImagenes);
    } 
     
    //Get and Set
    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public ListaDobleLoteFoto getListaImagen() {
        return listaImagen;
    }

    public void setListaImagen(ListaDobleLoteFoto listaImagen) {
        this.listaImagen = listaImagen;
    } 
    
}
