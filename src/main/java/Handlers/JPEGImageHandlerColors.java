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
public class JPEGImageHandlerColors extends ImageHandler{
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp1,bmp2, bmp3, bmp4;
    File bmpTemporal1,bmpTemporal2,bmpTemporal3,bmpTemporal4;
    public File directorio = new File("./Carpeta_Temporal");

    public JPEGImageHandlerColors(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
        
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        //Sepia
        bmpTemporal1 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal1);
        bmp1 = ImageIO.read(bmpTemporal1);
        //Rojo
        bmpTemporal2 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal2);
        bmp2 = ImageIO.read(bmpTemporal2); 
        //Verde
        bmpTemporal3 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal3);
        bmp3 = ImageIO.read(bmpTemporal3); 
        //Azul
        bmpTemporal4 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal4);
        bmp4 = ImageIO.read(bmpTemporal4); 
    }

    @Override
    public void generateFiles() throws Exception {
        for (int x=0; x<bmp1.getWidth(); x++) {
            for (int y=0; y<bmp1.getHeight(); y++) {
                int rgb=bmp1.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color Sepia = new Color((int)(0.4*color.getBlue()),(int)(0.23*color.getBlue()),(int)(0.16*color.getBlue()));
                bmp1.setRGB(x, y, Sepia.getRGB());
            }
        }
        if(!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        ImageIO.write(bmp1, "jpg", new File("./Carpeta_Temporal/Sepia-"+nombreCorto+".jpg"));
        bmpTemporal1.delete();
        
        for (int x=0; x<bmp2.getWidth(); x++) {
            for (int y=0; y<bmp2.getHeight(); y++) {
                int rgb=bmp2.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color colorRojo = new Color((int)color.getRed(),(int)0,(int)0);
                bmp2.setRGB(x, y, colorRojo.getRGB());
            }
        }
        ImageIO.write(bmp2, "jpg", new File("./Carpeta_Temporal/Red-"+nombreCorto+".jpg"));
        bmpTemporal2.delete();
        
        for (int x=0; x<bmp3.getWidth(); x++) {
            for (int y=0; y<bmp3.getHeight(); y++) {
                int rgb=bmp3.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color Verde = new Color((int)(0),(int)(color.getGreen()),(int)(0));
                bmp3.setRGB(x, y, Verde.getRGB());
            }
        }
        ImageIO.write(bmp3, "jpg", new File("./Carpeta_Temporal/Green-"+nombreCorto+".jpg"));
        bmpTemporal3.delete();
        
        for (int x=0; x<bmp4.getWidth(); x++) {
            for (int y=0; y<bmp4.getHeight(); y++) {
                int rgb=bmp4.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color Azul = new Color((int)(0),(int)(0),(int)(color.getBlue()));
                bmp4.setRGB(x, y, Azul.getRGB());
            }
        }
        ImageIO.write(bmp4, "jpg", new File("./Carpeta_Temporal/Blue-"+nombreCorto+".jpg"));
        bmpTemporal4.delete();
        
    }
    
}
