
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class lab1 {
    private JButton pbutton1;
    private JTextField textField1;
    private JLabel aaa;
    public JPanel panelmain;

    public lab1() {
        String url = "jdbc:postgresql://localhost:5432/fff";
        String user = "postgres";
        String pass = "123456789";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("нет подключение к бд");
        }

        Statement stat = null;
        try {
            stat = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement finalStat = stat;
        Connection finalConn = conn;
        pbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> array = new ArrayList<>();

                try{

                    Class.forName("org.postgresql.Driver");
                    String wort = textField1.getText();

                    String sqlselect = "select mean from dict where word ILIKE  ? ;" ;
                    PreparedStatement preparedStatement = finalConn.prepareStatement(sqlselect) ;
                    preparedStatement.setString(1,wort);
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()){
                      String str= result.getString(1);

                        int index = 0;
                        while (index < str.length()-150) {
                            String tmp = str.substring(index, index+150);
                            array.add(tmp);
                            index += 150;
                        }
                        array.add(str.substring(index));

                       StringBuilder outString = new StringBuilder();
                        for (String res :array ) {
                            outString.append(res);
                            outString.append('\n');
                        }
                        JOptionPane.showMessageDialog(panelmain,outString );
                    }

                }
                catch (Exception el) {
                    el.printStackTrace();
                }
            }
        });
    }


}
