import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Arm extends BasicEntity {

    private BufferedImage body;
    private AffineTransform at;



    private static Player player;
    private static double bStart = 0;

    public Arm(String image, Player p) {
        super();
        player = p;

        try {
            body = ImageIO.read(new File(image));
        }catch (IOException e) {

        }
        radians = Math.toRadians(bStart);
        bStart += 36;
        grow = 1;
        radius = 60;



    }



    @Override
    public void update() {
        radians += Player.ARM_SPEED;
        if(radians > Math.PI){
            radians -= Math.PI*2;
        }
    }

    private double radians;
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(body, at(), board);
    }


    private int grow;
    private int radius;
    private AffineTransform at(){
        at = new AffineTransform();
        at.translate(player.centerX() - 5, player.centerY() - radius);
        at.rotate(radians, 5,radius);
        //radius +=grow;
        if(radius > 79)grow=-1;
        if(radius < 40) grow= 1;
        return at;
    }

}
