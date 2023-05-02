package Estructura;
import com.mycompany.ugallery_proyecto2.Usuario;
import javax.swing.JComboBox;
/**
 *
 * @author manuel
 */
public class ListaSimpleUsuario extends EstructuraDeDatos{
   
    private NodoUsuario Cabeza = null;    
    
    public void ImprimirUsuarios(){
        NodoUsuario nodoAuxiliar = Cabeza;
        while(nodoAuxiliar != null){
            System.out.print(nodoAuxiliar.getUsuarioNuevo().NombreUsuario+"-->");
            nodoAuxiliar=nodoAuxiliar.getUsuarioSiguiente();
        }
        System.out.print("null\n");
        System.out.println("--------------------------");
    }
    
    public void LlenarUsuarios(JComboBox comboBox){
        NodoUsuario nodoAuxiliar = Cabeza;
        while (nodoAuxiliar != null) {
            Usuario usuario = nodoAuxiliar.getUsuarioNuevo();
            comboBox.addItem(usuario.getNombreUsuario());
            nodoAuxiliar = nodoAuxiliar.getUsuarioSiguiente();
        }
    }
    
    @Override
    public void add(Object e) {
        Usuario usuario = (Usuario)e;
        if (find(usuario.NombreUsuario)!= null) {
            return;
        }
        NodoUsuario nodoUsuario = new NodoUsuario(usuario);
        if (Cabeza == null) {
            Cabeza = nodoUsuario;
        }else{
            NodoUsuario  nodoAuxiliar = Cabeza;
            while (nodoAuxiliar.getUsuarioSiguiente()!= null){
                nodoAuxiliar = nodoAuxiliar.getUsuarioSiguiente();   
            }
            nodoAuxiliar.setUsuarioSiguiente(nodoUsuario);    
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object find(Object e) {
        String nombreUsuario = e.toString();
        NodoUsuario nodoAuxiliar = Cabeza;
        for (int i = 0; i < index; i++) {
            if (nodoAuxiliar.getUsuarioNuevo().NombreUsuario.equals(nombreUsuario)){
                return nodoAuxiliar.getUsuarioNuevo();
            }
            nodoAuxiliar  = nodoAuxiliar.getUsuarioSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= index) {
            throw new IllegalArgumentException("Indice fuera de los limites.");
        }
        NodoUsuario nodoAuxiliar = Cabeza;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getUsuarioSiguiente();
        }
        return nodoAuxiliar.getUsuarioSiguiente();
    }
    

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Object e) {


    }
    
}
