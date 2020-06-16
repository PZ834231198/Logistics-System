package 物流面单系统;

import java.awt.image.BufferedImage;  
import java.io.File;
import com.google.zxing.common.BitMatrix;


public class Matrix {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }


    
    public static void writeToFile(BitMatrix matrix, String format, File file) throws Exception {

        BufferedImage image = toBufferedImage(matrix);
    }

}
