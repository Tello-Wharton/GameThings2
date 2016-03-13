import java.awt.geom.AffineTransform;

/**
 * Created by Aaron on 12/03/2016.
 */
public class SimpleTrajectory {

    public int      x0, y0;
    public double   x, y;

    public SimpleTrajectory(int x1, int x2, int y1, int y2){
        x0 = x1;
        y0 = y1;

        x = x2 - x1;
        y = y2 - y1;
        double mod = Math.sqrt(x*x+y*y);

        x = x/mod;
        y = y/mod;

    }


}
