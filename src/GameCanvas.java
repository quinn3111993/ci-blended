import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    public GameCanvas() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0,0,800,600);
        g.drawImage(background,0,0, null);
    }
}
