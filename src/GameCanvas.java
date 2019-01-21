import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    BufferedImage player;
    int playerX = 176;
    int playerY = 500;
    boolean leftPressed;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;
    Enemy e;
    BufferedImage playerBullet;
    int playerBulletX = playerX;
    int playerBulletY = playerY;

    public GameCanvas() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        e = new Enemy();
        e.loadImage();

        try {
            playerBullet = ImageIO.read(new File("assets/images/player-bullets/a/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Key left Pressed");
                    leftPressed = true;
                } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("Key right Pressed");
                    rightPressed = true;
                } else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("Key up Pressed");
                    upPressed = true;
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("Key down Pressed");
                    downPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("KeyReleased");
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                } else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = false;
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, 800, 600);
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, playerX, playerY, null);
        e.paint(g);
        g.drawImage(playerBullet, playerBulletX, playerBulletY, null);
    }

    public void gameLoop() {
        while(true) {
            updateEnemyPosition();
            updatePlayerPosition();
            updatePlayerBulletPosition();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void updatePlayerPosition() {
        if(leftPressed) {
            playerX -= 5;
        } else if(rightPressed) {
            playerX += 5;
        } else if(upPressed) {
            playerY -= 5;
        } else if(downPressed) {
            playerY += 5;
        }
    }

    void updateEnemyPosition() {
        e.updatePosition();
    }

    void updatePlayerBulletPosition() {
        playerBulletY -= 1;
    }

}
