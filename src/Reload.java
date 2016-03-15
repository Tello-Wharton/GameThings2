import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;

/**
 * Created by Aaron on 13/03/2016.
 */
public class Reload extends BasicEntity {

    double x, y;

    public Reload(){
        super("Bar.png");
        x = -100;
        y = 1060;
    }


    @Override
    public void update() {
        x+=8;
        if (x > 1920){
            x = -100;
            board.getPlayer().reload();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(body,(int)x,(int)y,board);
    }
}
