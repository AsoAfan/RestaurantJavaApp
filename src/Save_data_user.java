import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Save_data_user {
//TRUNCATE table_name;
    public JPanel user_panel =new JPanel();
    public JFrame user_frame=new JFrame();
    public JTextField name_textarea=new JTextField();
    public JLabel costumer=new JLabel("costumer name : ");
    private final JButton save_button=new JButton("save");
    Save_data_user(){

        user_frame.setBounds(700, 400, 500, 250);

        user_panel.setBounds(0, 0, 500, 250);
        user_panel.setBackground(new Color(153, 0, 0));
        user_frame.add(user_panel);

        costumer.setBounds(20, 50, 160, 25);
        costumer.setFont(new Font("Arial", Font.BOLD, 18));
        costumer.setForeground(Color.white);
        user_panel.add(costumer);

        name_textarea.setBounds(190, 50, 200, 25);
        name_textarea.setBackground(Color.white);
        user_panel.add(name_textarea);

        save_button.setBounds(210, 100, 90, 25);
        user_panel.add(save_button);


        name_textarea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save_button.setEnabled(false);

                try {

                    String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                    String user = "root";
                    String password = "";

                    Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers (name, text, total_price,admin_name) VALUES (?,?,?,?)");


                    String name = name_textarea.getText().trim();
                    String text = Wassl.TextArea_wassl_2.getText().trim();
                    double total_price = Wassl.sum;
                    String admin_name = Login_in.username_TextField.getText().trim();

                    stmt.setString(1, name);
                    stmt.setString(2, text);
                    stmt.setDouble(3, total_price);
                    stmt.setString(4, admin_name);


                    if(name.isEmpty()){
                        JOptionPane.showMessageDialog(null, "you don't enter customer name ", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }else if(text.isEmpty()){
                        JOptionPane.showMessageDialog(null, "you don't chose any food  ", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }else if(admin_name.isEmpty()){
                        JOptionPane.showMessageDialog(null, "you are not admin  ", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }else {

                        int rowsInserted = stmt.executeUpdate();
                        if (rowsInserted >= 0) {
                            JOptionPane.showMessageDialog(null, "The data have been added", "Success", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("A new row has been inserted.");
                            name_textarea.setText("");
                            user_frame.dispose();
                            Wassl.frame_print.dispose();
                            Wassl.rest();

                        }


                        Wassl.button_rest.doClick();

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });





        user_panel.setLayout(null);
        user_frame.setVisible(true);
    }



}
