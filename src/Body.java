import java.awt.*;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Body extends BasicEntity {
    Image body;
    private static Player player;


    public Body(String image, Player p){
        super(image);
        player = p;
        body = super.body;
    }

    @Override
    public void update() {
        if (!active)return;
    }

    @Override
    public void draw(Graphics g) {
        if (!active)return;
        g.drawImage(body,player.xPos(),player.yPos(),board);
    }

}
