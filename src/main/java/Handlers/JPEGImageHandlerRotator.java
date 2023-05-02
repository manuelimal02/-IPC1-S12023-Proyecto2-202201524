package Handlers;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author manuel
 */
public class JPEGImageHandlerRotator extends ImageHandler {
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp1, bmp2;
    File bmpTemporal1, bmpTemporal2;
    public File directorio = new File("./Carpeta_Temporal");
    public JPEGImageHandlerRotator(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal1 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal1);
        bmp1 = ImageIO.read(bmpTemporal1);
        
        bmpTemporal2 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal2);
        bmp2 = ImageIO.read(bmpTemporal2);
    }

    @Override
    public void generateFiles() throws Exception {
        int width = bmp1.getWidth();
        int height = bmp1.getHeight();
        // Rotar horizontalmente
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int temp = bmp1.getRGB(x, y);
                bmp1.setRGB(x, y, bmp1.getRGB(width - x - 1, y));
                bmp1.setRGB(width - x - 1, y, temp);
            }
        }
        if(!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        ImageIO.write(bmp1, "jpg", new File("./Carpeta_Temporal/VRotation-" + nombreCorto + ".jpg"));

        int width1 = bmp2.getWidth();
        int height1 = bmp2.getHeight();
        // Rotar verticalmente
        for (int x = 0; x < width1; x++) {
            for (int y = 0; y < height1 / 2; y++) {
                int temp = bmp2.getRGB(x, y);
                bmp2.setRGB(x, y, bmp2.getRGB(x, height1 - y - 1));
                bmp2.setRGB(x, height1 - y - 1, temp);
            }
        }
        ImageIO.write(bmp2, "jpg", new File("./Carpeta_Temporal/HRotation-" + nombreCorto + ".jpg"));
        bmpTemporal2.delete();
    }

    
}
