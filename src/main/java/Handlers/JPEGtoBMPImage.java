package Handlers;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author manuel
 */
public class JPEGtoBMPImage extends ImageHandler {
    
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    public File directorio = new File("./Carpeta_Temporal");

    public JPEGtoBMPImage(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        if(!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        ImageIO.write(jpg, "bmp", new File("./Carpeta_Temporal/Converted-"+nombreCorto+".bmp"));
        bmpTemporal.delete();
    }
    
}
