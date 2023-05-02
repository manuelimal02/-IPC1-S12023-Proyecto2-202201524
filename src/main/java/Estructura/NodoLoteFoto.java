package Estructura;
import com.mycompany.ugallery_proyecto2.LoteFoto;

/**
 *
 * @author manuel
 */
public class NodoLoteFoto {
    private LoteFoto Foto;
    private NodoLoteFoto Siguiente;
    private NodoLoteFoto Anterior;     

    public NodoLoteFoto(LoteFoto Foto, NodoLoteFoto Siguiente, NodoLoteFoto Anterior) {
        this.Foto = Foto;
        this.Siguiente = Siguiente;
        this.Anterior = Anterior;
    }
    public NodoLoteFoto(LoteFoto Foto){
        this.Foto=Foto; 
    }
    public LoteFoto getFoto() {
        return Foto;
    }

    public void setFoto(LoteFoto Foto) {
        this.Foto = Foto;
    }

    public NodoLoteFoto getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoLoteFoto Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoLoteFoto getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoLoteFoto Anterior) {
        this.Anterior = Anterior;
    }
  
}
