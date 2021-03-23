import javax.swing.*;
import java.sql.*;



public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("lab1");
        frame.setContentPane(new lab1().panelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
