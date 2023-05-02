package Handlers;
/**
 *
 * @author manuel
 */
import java.io.*;

public class BmpHandlerCopy extends ImageHandler {
    
    protected byte[] filebytes;
    protected String copyname;
    public File directorio = new File("./Carpeta_Temporal");
    
    public BmpHandlerCopy(String imagename) {
        super(imagename);
        File file = new File(imagename);
        if(!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        this.copyname = "./Carpeta_Temporal/Copia-"+file.getName();
    }
    public void readFile() throws Exception {
        FileInputStream input = new FileInputStream(this.handledFileName);
        filebytes = new byte[input.available()];
        input.read(filebytes);
        input.close();
	}
    public void generateFiles() throws Exception {
        FileOutputStream output = new FileOutputStream(copyname);
        output.write(filebytes);
        output.close();
	}
}
