package myormawa;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import javax.imageio.ImageIO;
/**
 *
 * @author ariputraaa
 */
public class loadIMG {
        public static BufferedImage loadImage(String urlGambar){
        BufferedImage bimg = null;
        try{
            bimg = ImageIO.read(new File(urlGambar));
            
        } catch(IOException e){
            System.out.println("Gagal load gambar;" +e.getMessage());
        }
        return bimg;
    }
}
