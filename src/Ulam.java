import java.util.ArrayList;

/**
 * Created by Aaron on 13/03/2016.
 */
public class Ulam {

    private Room[][] rooms;

    public Ulam(){


        rooms = new Room[30][30];
        rooms[0][0] = new Room(true);


        for (int a = 0; a < 29; a ++) {
            int x = a + 1;
            int y = 0;
            while (y < a) {
                rooms[x][y] = new Room(true);
                y++;
            }
            while (x > 0) {
                rooms[x][y] = new Room(true);
                x--;
            }
        }


    }

    public static void test(){
        Board board = BasicEntity.board;
    }
}
