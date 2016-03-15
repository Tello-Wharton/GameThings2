import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Projectile extends BasicEntity{

    private SimpleTrajectory trajectory;
    private Arm arm;
    private AffineTransform at;
    private AffineTransform finalCircleAt;
    private AffineTransform tj;
    private double angle;
    private boolean init;
    double armDiff;

    private double x,y;


    public Projectile(Arm arm, SimpleTrajectory trajectory){
        super("Arm.png");
        this.trajectory = trajectory;
        this.arm = arm;
        if (trajectory.x > 0) {
            angle = Math.atan((trajectory.y) / trajectory.x);
        }else{
            if (trajectory.y > 0){
                angle = Math.PI + Math.atan((trajectory.y) / trajectory.x);
            }else{
                angle = Math.atan((trajectory.y) / trajectory.x) - Math.PI;
            }
        }
        init = true;
        tj = new AffineTransform();
        armDiff = Math.PI*2;
    }



    @Override
    public void update() {
        if (init){
            at = arm.at();

            double tempDiff = Math.abs(angle - arm.getRadians());
            if (angle < arm.getRadians())tempDiff = Math.PI*2 - tempDiff;
            if (tempDiff < armDiff){
                armDiff = tempDiff;
            } else {
                finalCircleAt = at;
                init = false;
            }
        } else {
            tj.translate(trajectory.x*5,trajectory.y*5);
            at = new AffineTransform();
            at.concatenate(tj);
            at.concatenate(finalCircleAt);
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(body, at, board);
    }
}
