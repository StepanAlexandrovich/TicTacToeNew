package tictactoe;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
