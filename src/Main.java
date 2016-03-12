import javax.swing.*;
import java.awt.*;

/**
 * Created by Aaron on 12/03/2016.
 */
public class Main extends JFrame {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }

    public Main() {

        initUI();
    }

    private void initUI() {
        add(new Board());

        dispose();

        setUndecorated(true);

        setBounds(0,0,getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);
        setVisible(true);

    }



}
