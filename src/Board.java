import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Board extends JPanel implements ActionListener {

    private static final int DELAY = 17;
    private Timer timer;

    private Player player;
    private Scope scope;



    public Board() {
        addKeyListener(new TAdapter());
        addMouseMotionListener(new MAdapter());

        setBackground(Color.black);
        setFocusable(true);
        setDoubleBuffered(true);

        loadItems();
        initGame();

        BasicEntity.board = this;



    }

    private void loadItems() {
        player = new Player();
        scope = new Scope(this,player);
    }

    public void initGame(){
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        player.draw(g);
        scope.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        player.update();
        scope.update();

        repaint();


    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if(key == KeyEvent.VK_W) player.moveUp();
            if(key == KeyEvent.VK_A) player.moveLeft();
            if(key == KeyEvent.VK_S) player.moveDown();
            if(key == KeyEvent.VK_D) player.moveRight();

            if(key == KeyEvent.VK_SPACE) Player.ARM_SPEED = 0.1;

        }

        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_W) player.stopUp();
            if(key == KeyEvent.VK_A) player.stopLeft();
            if(key == KeyEvent.VK_S) player.stopDown();
            if(key == KeyEvent.VK_D) player.stopRight();

            if(key == KeyEvent.VK_SPACE) Player.ARM_SPEED = 0.01;
        }
    }

    private class MAdapter extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e){

        }

    }
}
