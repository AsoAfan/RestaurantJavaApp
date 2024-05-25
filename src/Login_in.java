import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Login_in {
    public static JFrame frame=new JFrame();
    public static JTextField username_TextField =new JTextField();
    public JPanel panel_login_in =new JPanel();
    public JPasswordField passwordField=new JPasswordField();
    public JButton login_button=new JButton("login in");
    public JLabel pass=new JLabel("password :");
    public JLabel user_name=new JLabel("user name :");
    public JLabel login=new JLabel("- Login in -");
    Login_in(){
        try {
            progress();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        frame.setBounds(650, 300, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel_login_in.setBounds(0, 0, 600, 400);
        panel_login_in.setBackground(new Color(153,0,0));


        login.setBounds(200,40 , 190, 35);
        login.setFont(new Font("SansSerif", Font.PLAIN, 30));
        login.setForeground(Color.white);
        panel_login_in.add(login);


        user_name.setBounds(90, 110, 120, 25);
        user_name.setFont(new Font("SansSerif", Font.PLAIN, 20));
        user_name.setForeground(Color.white);
        panel_login_in.add(user_name);

        username_TextField.setBounds(200, 110, 180,25 );
        panel_login_in.add(username_TextField);


        pass.setBounds(90, 150, 120, 25);
        pass.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pass.setForeground(Color.white);
        panel_login_in.add(pass);

        passwordField.setBounds(200, 150, 180,25 );
        panel_login_in.add(passwordField);


        login_button.setBounds(220, 200, 90,30 );
        panel_login_in.add(login_button);

        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/restaurant_menu", "root", "");

                    String query = "SELECT * FROM accounts WHERE username=? AND password=?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, username_TextField.getText());
                    stmt.setString(2, new String(passwordField.getPassword()));

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(panel_login_in, "Login Successful!");

                        new GUI();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(panel_login_in, "Invalid username or password.");
                    }
                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel_login_in.setLayout(null);
        frame.add(panel_login_in);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void progress() throws InterruptedException {
        ProgressBar load = new ProgressBar();
        for(int i = 0; i <= 100; ++i) {
            Thread.sleep(10L);
            load.lblNewLabel.setText("Loading... " + i);
            load.progressBar.setValue(i);
        }
        load.Pframe.dispose();
    }
}
