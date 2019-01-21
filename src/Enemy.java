import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    BufferedImage image;
    int x = 176;
    int y = 0;

    void loadImage() {
        try {
            image = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updatePosition() {
        y += 1;
    }

    void paint(Graphics g) {
        g.drawImage(image, x, y,null);
    }
}
