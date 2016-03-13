import java.awt.*;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Scope extends BasicEntity{

    private boolean line;
    private Board board;
    private Player player;

    private int x1,x2,y1,y2;

    private double a,b,c,d;

    public Scope(Board board, Player player){
        super();
        this.board = board;
        this.player = player;

        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;

        a = 0;
        b = 0;
        c = 0;
        d = 0;

        line = false;
    }

    @Override
    public void update() {
        try {
            x2 = (int) board.getMousePosition().getX();
            y2 = (int) board.getMousePosition().getY();

            a =  board.getMousePosition().getX() - player.centerX();
            b =  board.getMousePosition().getY() - player.centerY();


            d = d();
            c = Math.sqrt(55 * 55 - d * d);

            if(board.getMousePosition().getY() < player.centerY() - 55){
                y1 = (int) (d + player.centerY());
                x1 = (int) (-c + player.centerX());
            }else{
                if(board.getMousePosition().getY() < player.centerY() + 55 && board.getMousePosition().getX() < player.centerX()){
                    y1 = (int) (d + player.centerY());
                    x1 = (int) (-c + player.centerX());

                }else {
                    y1 = (int) (d + player.centerY());
                    x1 = (int) (c + player.centerX());
                }
            }

            if(a*a + b*b < 55*55)line=false;
            else {
                line = true;
            }




        }catch (NullPointerException e){

        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        if (line) g.drawLine(x1,y1,x2,y2);

    }

    public double d(){
        return (55*55*b - 55*a*Math.sqrt(a*a + b*b - 55*55 ))/(a*a + b*b);
    }

    public SimpleTrajectory getTrajectory(){
        return new SimpleTrajectory(x1,x2,y1,y2);
    }
}
