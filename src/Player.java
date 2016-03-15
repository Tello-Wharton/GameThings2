import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Player {

    public static double ARM_SPEED = 0.01;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private Body body;
    private ArrayList<Arm> arms;

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public int getRadius() {
        return radius;
    }

    private int radius;

    public Player(){
        xPos = 100;
        yPos = 100;

        radius = 60;

        body = new Body("Body.png", this);
        arms = new ArrayList<Arm>();
        width = body.width;
        height = body.height;
        for(int x = 0; x < 10; x++){
            arms.add(new Arm("Arm.png", this));
        }

    }


    public int centerX(){
        return (xPos + (width)/2);
    }

    public int centerY(){
        return (yPos + (height+2)/2);
    }

    public int xPos(){
        return xPos;
    }

    public int yPos(){
        return yPos;
    }

    public void update(){
        if(up)      yPos-=3;
        if(down)    yPos+=3;
        if(left)    xPos-=3;
        if(right)   xPos+=3;
        body.update();
        arms.forEach(Arm::update);
    }

    public void draw(Graphics g){
        body.draw(g);

        for(Arm arm : arms){
            arm.draw(g);
        }


    }

    public void moveUp(){
        up = true;
        down = false;
    }

    public void moveDown(){
        up = false;
        down = true;
    }

    public void moveLeft() {
        left = true;
        right = false;
    }

    public void moveRight() {
        left = false;
        right = true;
    }

    public void stopUp() {
        up = false;
    }

    public void stopLeft() {
        left = false;
    }

    public void stopDown() {
        down = false;
    }

    public void stopRight() {
        right = false;

    }

    public Projectile removeArm(SimpleTrajectory trajectory) {
        boolean hasArm = false;

        double angle;
        if (trajectory.x > 0) {
            angle = Math.atan((trajectory.y) / trajectory.x);
        }else{
            if (trajectory.y > 0){
                angle = Math.PI + Math.atan((trajectory.y) / trajectory.x);
            }else{
                angle = Math.atan((trajectory.y) / trajectory.x) - Math.PI;
            }
        }


        Arm loaded = null;
        double armDiff = Math.PI*2;
        for (Arm arm : arms){
            if (arm.isActive()){
                hasArm = true;
                double tempDiff = Math.min(Math.abs(angle - arm.getRadians()),Math.abs(angle - (arm.getRadians() + Math.PI*2)));
                if (angle < arm.getRadians())tempDiff = Math.PI*2 - tempDiff;
                if (tempDiff < armDiff){
                    loaded = arm;
                    armDiff = tempDiff;
                }
            }
        }

        if (hasArm){
            loaded.setActive(false);
            return new Projectile(loaded,trajectory);
        }
        return null;
    }

    public void reload(){
        for(Arm arm : arms){
            if (!arm.isActive()){
                arm.setActive(true);
                return;
            }
        }
    }
}
