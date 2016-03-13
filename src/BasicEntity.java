import javax.swing.*;
import java.awt.*;

/**
 * Created by Aaron on 12/03/2016.
 */
public abstract class BasicEntity {
    public static Board board;
    protected Image body;

    protected int xPos;
    protected int yPos;

    protected int width;
    protected int height;

    protected boolean active;

    public BasicEntity(String image){
        ImageIcon ii = new ImageIcon(image);
        body = ii.getImage();

        width = ii.getIconWidth();
        height = ii.getIconHeight();

        active = true;
    }

    public BasicEntity(){
        active = true;
    }


    public abstract void update();
    public abstract void draw(Graphics g);

    public void setActive(boolean bool){
        active = bool;
    }

    public boolean isActive(){
        return active;
    }

}
