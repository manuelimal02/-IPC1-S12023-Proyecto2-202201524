package Estructura;
import com.mycompany.ugallery_proyecto2.LoteFoto;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author manuel
 */
public class ListaDobleLoteFoto extends EstructuraDeDatos{
    
    NodoLoteFoto PrimerNodo;
    NodoLoteFoto UltimoNodo;
    ImageIcon icon;
    DefaultListModel<String> modelo1 = new DefaultListModel();

    
    public void ArrayListRuta(ArrayList<String> listaRutaImagenes){
        if(PrimerNodo==null){
            return;
        }
        NodoLoteFoto NodoAuxiliar=PrimerNodo;
        while(NodoAuxiliar!=null){
            listaRutaImagenes.add(NodoAuxiliar.getFoto().getRuta());
            NodoAuxiliar=NodoAuxiliar.getSiguiente();
        }
    }
    
    public void Imprimir(){
        if(PrimerNodo==null){
            return;
        }
        NodoLoteFoto NodoAuxiliar=PrimerNodo;
        while(NodoAuxiliar!=null){
            System.out.print(NodoAuxiliar.getFoto().getNombre()+"<--->");
            NodoAuxiliar=NodoAuxiliar.getSiguiente();
        }
        System.out.println("null");
    }
    
    public void ImprimirTamanio(JLabel ImagenLBL){
        int contador=0;
        if(PrimerNodo==null){
            return;
        }
        NodoLoteFoto NodoAuxiliar=PrimerNodo;
        while(NodoAuxiliar!=null){
            contador++;
        }
        ImagenLBL.setText(String.valueOf(contador));
    }
    
    public void retornarNombre(JList listaImagenes){
        if(PrimerNodo==null){
            return;
        }
        NodoLoteFoto NodoAuxiliar=PrimerNodo;
        modelo1.removeAllElements();
        while(NodoAuxiliar!=null){
            modelo1.addElement(NodoAuxiliar.getFoto().getNombre());
            NodoAuxiliar=NodoAuxiliar.getSiguiente();
        }
        listaImagenes.setModel(modelo1);
    }
    
    public void Siguiente(JTextField NombreImagen, JLabel ImagenLBL){
        String nombreImagen=NombreImagen.getText();
        if(PrimerNodo==null){
            return;
        }
        NodoLoteFoto NodoAuxiliar1=PrimerNodo;
        for (int i=0; i < index; i++) {
            if(NodoAuxiliar1.getFoto().Nombre.equals(nombreImagen)){
                NodoAuxiliar1 = NodoAuxiliar1.getSiguiente();
                if(NodoAuxiliar1==null){
                    return;
                }else{
                    NombreImagen.setText(String.valueOf(NodoAuxiliar1.getFoto().getNombre()));
                    icon = NodoAuxiliar1.getFoto().ImagenIcon;
                    Image Imagen = icon.getImage();
                    Imagen = Imagen.getScaledInstance(ImagenLBL.getWidth(), ImagenLBL.getHeight(), Image.SCALE_DEFAULT);
                    ImagenLBL.setIcon(new ImageIcon(Imagen));
                    break;    
                }
            }else{
                NodoAuxiliar1 = NodoAuxiliar1.getSiguiente();
            } 
        }
    }
    
    public void Anterior(JTextField NombreImagen, JLabel ImagenLBL){
        String nombreImagen=NombreImagen.getText();
        if(UltimoNodo==null){
            return;
        } 
        NodoLoteFoto NodoAuxiliar1=UltimoNodo;
        for (int i = 0; i < index; i++) {
            if(NodoAuxiliar1.getFoto().Nombre.equals(nombreImagen)){
                NodoAuxiliar1 = NodoAuxiliar1.getAnterior();
                if(NodoAuxiliar1==null){
                    break;
                }else{
                    NombreImagen.setText(String.valueOf(NodoAuxiliar1.getFoto().getNombre()));
                    icon = NodoAuxiliar1.getFoto().ImagenIcon;
                    Image Imagen = icon.getImage();
                    Imagen = Imagen.getScaledInstance(ImagenLBL.getWidth(), ImagenLBL.getHeight(), Image.SCALE_DEFAULT);
                    ImagenLBL.setIcon(new ImageIcon(Imagen));
                    break;
                }
            }else{
                NodoAuxiliar1 = NodoAuxiliar1.getAnterior();
            }
        } 
    }

    @Override
    public void add(Object e) {
      LoteFoto Foto =  (LoteFoto)e;
      if(PrimerNodo==null){
          PrimerNodo = UltimoNodo = new NodoLoteFoto(Foto);
      }else{
          NodoLoteFoto nuevoNodo = new NodoLoteFoto(Foto,null,UltimoNodo);
          UltimoNodo.setSiguiente(nuevoNodo);
          UltimoNodo = nuevoNodo;
      }
      index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
       if(PrimerNodo==null){
           return null;
       } 
       String NombreImagen = e.toString();
       NodoLoteFoto NodoAuxiliar =PrimerNodo;
        for (int i = 0; i < index; i++) {
            if(NodoAuxiliar.getFoto().getNombre().equals(NombreImagen)){
                return NodoAuxiliar.getFoto();
            }
            NodoAuxiliar = NodoAuxiliar.getSiguiente();
        }
       return null;            
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public Object get(int i) {
        if(PrimerNodo==null){
            return null;
        } 
        if (i < 0  || i > index) {
            return new IndexOutOfBoundsException();
        }
        NodoLoteFoto nodoAuxiliar = PrimerNodo;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getFoto();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String nombreImagen=e.toString();
        NodoLoteFoto nodoAuxiliar=PrimerNodo;
        while(nodoAuxiliar!=null&&!nodoAuxiliar.getFoto().getNombre().equals(nombreImagen)){
            nodoAuxiliar=nodoAuxiliar.getSiguiente();
        }
        if(nodoAuxiliar==null){
            return;
        }else if(nodoAuxiliar==PrimerNodo){
            PrimerNodo=PrimerNodo.getSiguiente();
            PrimerNodo.setAnterior(null);
            
        }else if(nodoAuxiliar==UltimoNodo){
            UltimoNodo= UltimoNodo.getAnterior();
            UltimoNodo.setSiguiente(null);
        }else{
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
    
}
