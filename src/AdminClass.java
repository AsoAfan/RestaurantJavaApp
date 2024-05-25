    import javax.swing.*;
    import javax.swing.border.Border;
    import javax.swing.border.LineBorder;
    import javax.swing.table.DefaultTableModel;
    import javax.swing.table.TableColumnModel;
    import javax.swing.text.MaskFormatter;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.*;
    import java.text.ParseException;
    public class AdminClass{
        static JTextField user_textArea =new JTextField();
        static JPasswordField passwordField=new JPasswordField();
        static JButton login=new JButton(new ImageIcon("Admin4.png"));
        static JPanel Admin_panel=new JPanel();
        static JFrame user_frame_window = new JFrame();
        static JPanel user_panel_window=new JPanel();
        static JLabel label = new JLabel();
        static JLabel spinn_leble = new JLabel(new ImageIcon("Spinn.png"));
        static String welcomeText;
        static JFrame f=new JFrame();
        static JTable table_costumer;
        static DefaultTableModel model;
        static JScrollPane scrollPane ;
        static JFormattedTextField dateField;
        static TableColumnModel columnModel;
        static JPanel panel_table_Admin=new JPanel();
        static JTextField Admin_textField= new JTextField();
        static JTextField name_jtextField = new JTextField();
        static JLabel label_ask=new JLabel("Enter the date (yyyy-mm-dd)");
        static JLabel label_ask_customer_name =new JLabel("Enter customer name :");
        static JLabel label_ask_Admin=new JLabel("Enter Admin name :");
        static JButton button_Rest_table =new JButton("- Rest Table -");
        static JButton button_search_Admin =new JButton("- search Admin -");
        static JButton button_search_name =new JButton("- search name -");
        static JButton button_search_date =new JButton("- search date -");
        AdminClass() throws ParseException {
            Admin_panel.setBackground(Color.white);
            Admin_panel.setBorder(new LineBorder(Color.BLACK));
            Admin_panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            Admin_panel.setBounds(650,250,600,450);

            JLabel userImage=new JLabel();
            userImage.setIcon(new ImageIcon("Admin2.png"));
            userImage.setBounds(60, 120, 30, 30);
            Admin_panel.add(userImage);


            JLabel username=new JLabel("username :");
            username.setBounds(100, 120, 100, 25);
            username.setFont(new Font("SansSerif", Font.PLAIN, 20));
            Admin_panel.add(username);

            JLabel passwordImage=new JLabel();
            passwordImage.setIcon(new ImageIcon("Admin3.png"));
            passwordImage.setBounds(60, 170, 40, 40);
            Admin_panel.add(passwordImage);

            JLabel Password=new JLabel("Password :");
            Password.setBounds(100, 180, 100, 25);
            Password.setFont(new Font("SansSerif", Font.PLAIN, 20));
            Admin_panel.add(Password);


            spinn_leble.setBounds(360, 235, 50, 50);

            user_textArea.setBounds(210, 120, 180, 25);
            user_textArea.setBorder(new LineBorder(Color.BLACK));
            user_textArea.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(4.0f)));
            Admin_panel.add(user_textArea);


            passwordField.setBounds(210,180,180,25);
            passwordField.setBorder(new LineBorder(Color.BLACK));
            passwordField.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(4.0f)));
            Admin_panel.add(passwordField);


            login.setBounds(250, 230,90 ,50);
            login.setOpaque(false);
            login.setContentAreaFilled(false);
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/restaurant_menu", "root", "");

                        String query = "SELECT * FROM accounts WHERE username=? AND password=?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, user_textArea.getText());
                        stmt.setString(2, new String(passwordField.getPassword()));


                        ResultSet rs = stmt.executeQuery();


                        if (rs.next()) {


                            JOptionPane.showMessageDialog(Admin_panel, "Login Successful!");

                            welcomeText = "Welcome  " + rs.getString("username") ;
                            System.out.println("login in successful  : "+ user_textArea.getText());

                            Login_successful();


                        } else {

                            JOptionPane.showMessageDialog(Admin_panel, "Invalid username or password.");
                        }


                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            Admin_panel.add(login);





            Admin_panel.setLayout(null);
            GUI.Admin.add(Admin_panel);
        }
        void Login_successful(){
            user_frame_window.setTitle(welcomeText);
            user_frame_window.setBounds(500,280,1000, 600);
            Border border = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));
            user_frame_window.getRootPane().setBorder(border);

            user_panel_window.setBounds(0, 0, 1000, 600);
            user_panel_window.setBackground(new Color(153, 0, 0));

            label.setBounds(10, 10, 300, 30);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            label.setForeground(Color.white);

            JButton Exit=new JButton("- Exit -");
            Exit.setBounds(20, 500, 120, 30);
            Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Login_out();
                    f.dispose();
                }
            });
            user_panel_window.add(Exit);

            Table_data();

            Rest_table();

            serch_name();

            Serch_date();

            serch_Admin();

            user_panel_window.setLayout(null);
            user_panel_window.add(label);

            user_frame_window.add(user_panel_window);
            user_frame_window.setLayout(null);
            user_frame_window.setVisible(true);
        }
        void serch_Admin(){

            button_search_Admin.setBounds(20, 160, 120, 30);
            button_search_Admin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f_Admin=new JFrame();
                    f_Admin.setBounds(800, 400, 400, 200);


                    JPanel p_admin=new JPanel();
                    p_admin.setBounds(0, 0, 400, 200);
                    p_admin.setBackground(new Color(153,0,0));


                    label_ask_Admin.setBounds(20, 50, 300, 25);
                    label_ask_Admin.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    label_ask_Admin.setForeground(Color.white);
                    p_admin.add(label_ask_Admin);


                    Admin_textField.setBounds(220, 50, 150, 30);
                    p_admin.add(Admin_textField);

                    JButton ok_Admin=new JButton("ok");
                    ok_Admin.setBounds(150, 90,90, 30);
                    ok_Admin.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ex) {
                            f_Admin.dispose();
                            String copy=Admin_textField.getText();
                            model.setRowCount(0);
                            try {
                                // 1. Connect to the MySQL database
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                                // 2. Query the data from the customer table
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE admin_name='" + copy+ "'ORDER BY id DESC");

                                while (rs.next()) {
                                    String id = rs.getString("id");
                                    String name = rs.getString("name");
                                    /*String phone = rs.getString("phone");*/
                                    String text = rs.getString("text");
                                    String total_price = rs.getString("total_price");
                                    String admin_name = rs.getString("admin_name");
                                    String order_time = rs.getString("date");

                                    model.addRow(new Object[] { id, name, /*phone,*/ text, total_price,admin_name,order_time });
                                }
                                conn.close();
                                button_Rest_table.setEnabled(true);
                                p_admin.removeAll();
                                p_admin.revalidate();
                                p_admin.repaint();
                            } catch (SQLException e) {
                                button_Rest_table.setEnabled(false);
                                e.printStackTrace();
                            }
                        }
                    });
                    p_admin.add(ok_Admin);
                    p_admin.setLayout(null);
                    f_Admin.add(p_admin);
                    f_Admin.setLayout(null);
                    f_Admin.setVisible(true);
                }
            });
            user_panel_window.add(button_search_Admin);
        }
        void serch_name(){

            button_search_name.setBounds(20, 120, 120, 30);

            button_search_name.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f_search_name=new JFrame();

                    f_search_name.setBounds(800, 400, 400, 200);

                    JPanel p_search_name=new JPanel();

                    p_search_name.setBounds(0, 0, 400, 200);
                    p_search_name.setBackground(new Color(153,0,0));

                    label_ask_customer_name.setBounds(20, 50, 300, 25);
                    label_ask_customer_name.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    label_ask_customer_name.setForeground(Color.white);
                    p_search_name.add(label_ask_customer_name);


                    name_jtextField.setBounds(220, 50, 150, 30);
                    p_search_name.add(name_jtextField);

                    JButton ok_search_name=new JButton("ok");

                    ok_search_name.setBounds(150, 90,90, 30);
                    ok_search_name.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ex) {
                            f_search_name.dispose();
                            String copy= name_jtextField.getText();
                            model.setRowCount(0);

                            try {
                                // 1. Connect to the MySQL database
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                                // 2. Query the data from the customer table
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE name='" + copy+ "'ORDER BY id DESC");

                                while (rs.next()) {
                                    String id = rs.getString("id");
                                    String name = rs.getString("name");
                                    /*String phone = rs.getString("phone");*/
                                    String text = rs.getString("text");
                                    String total_price = rs.getString("total_price");
                                    String admin_name = rs.getString("admin_name");
                                    String order_time = rs.getString("date");

                                    model.addRow(new Object[] { id, name, /*phone,*/ text, total_price,admin_name,order_time });
                                }

                                conn.close();
                                button_Rest_table.setEnabled(true);
                                p_search_name.removeAll();
                                p_search_name.revalidate();
                                p_search_name.repaint();
                            } catch (SQLException e) {
                                button_Rest_table.setEnabled(false);
                                e.printStackTrace();
                            }
                        }
                    });
                    p_search_name.add(ok_search_name);

                    p_search_name.setLayout(null);
                    f_search_name.add(p_search_name);
                    f_search_name.setLayout(null);
                    f_search_name.setVisible(true);
                }
            });



            user_panel_window.add(button_search_name);


        }
        void Serch_date(){

            button_search_date.setBounds(20, 80, 120, 30);
            button_search_date.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame f_date=new JFrame();

                    f_date.setBounds(800, 400, 400, 200);

                    JPanel p_date=new JPanel();


                    p_date.setBounds(0, 0, 400, 200);
                    p_date.setBackground(new Color(153,0,0));

                    label_ask.setBounds(20, 50, 300, 25);
                    label_ask.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    label_ask.setForeground(Color.white);
                    p_date.add(label_ask);

                    MaskFormatter dateFormatter = null;
                    try {
                        dateFormatter = new MaskFormatter("####-##-##");
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    dateField= new JFormattedTextField(dateFormatter);
                    dateField.setBounds(280, 50, 90, 30);
                    p_date.add(dateField);

                    JButton ok_date=new JButton("ok");
                    ok_date.setBounds(150, 90,90, 30);
                    ok_date.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ex) {
                            f_date.dispose();
                            String copy=dateField.getText();
                            model.setRowCount(0);

                            try {
                                // 1. Connect to the MySQL database
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                                // 2. Query the data from the customer table
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE date='" + copy+ "'ORDER BY id DESC");

                                while (rs.next()) {
                                    String id = rs.getString("id");
                                    String name = rs.getString("name");
                                    /*String phone = rs.getString("phone");*/
                                    String text = rs.getString("text");
                                    String total_price = rs.getString("total_price");
                                    String admin_name = rs.getString("admin_name");
                                    String order_time = rs.getString("date");

                                    model.addRow(new Object[] { id, name, /*phone,*/ text, total_price,admin_name,order_time });
                                }

                                conn.close();
                                button_Rest_table.setEnabled(true);


                                p_date.removeAll();
                                p_date.revalidate();
                                p_date.repaint();
                            } catch (SQLException e) {
                                button_Rest_table.setEnabled(false);
                                e.printStackTrace();
                            }

                        }
                    });
                    p_date.add(ok_date);

                    p_date.setLayout(null);
                    f_date.add(p_date);
                    f_date.setLayout(null);
                    f_date.setVisible(true);
                }
            });



            user_panel_window.add(button_search_date);

        }
        void Rest_table(){

            button_Rest_table.setBounds(20, 40, 120, 30);
            button_Rest_table.setEnabled(false);
            button_Rest_table.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ex) {
                    try {
                        model.setRowCount(0);
                        // 1. Connect to the MySQL database
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                        // 2. Query the data from the customer table
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM customers ORDER BY id DESC");

                        while (rs.next()) {
                            String id = rs.getString("id");
                            String name = rs.getString("name");
                            /*String phone = rs.getString("phone");*/
                            String text = rs.getString("text");
                            String total_price = rs.getString("total_price");
                            String admin_name = rs.getString("admin_name");
                            String order_time = rs.getString("date");

                            model.addRow(new Object[] { id, name, /*phone,*/ text, total_price,admin_name,order_time });
                        }
                        conn.close();
                        button_Rest_table.setEnabled(false);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            user_panel_window.add(button_Rest_table);
        }
        void Table_data(){
            panel_table_Admin.setBounds(150, 20, 800, 500);

            model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("text_area_data");
            model.addColumn("Total_price");
            model.addColumn("admin_name");
            model.addColumn("date");

            table_costumer =new JTable();
            table_costumer = new JTable(model);
            table_costumer.setBounds(0, 0, 800, 500);
            table_costumer.setDragEnabled(false);


            scrollPane= new JScrollPane(table_costumer);
            scrollPane.setBounds(0, 0, 800, 500);
            scrollPane.setPreferredSize(new Dimension(800, 500));

            columnModel= table_costumer.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(1);
            columnModel.getColumn(1).setPreferredWidth(1);
            columnModel.getColumn(2).setPreferredWidth(1);
            columnModel.getColumn(3).setPreferredWidth(0);
            columnModel.getColumn(4).setPreferredWidth(100);
            columnModel.getColumn(5).setPreferredWidth(10);
            try {
                // 1. Connect to the MySQL database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                // 2. Query the data from the customer table
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM customers ORDER BY id DESC ");

                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String text = rs.getString("text");
                    String total_price = rs.getString("total_price");
                    String admin_name = rs.getString("admin_name");
                    String order_time = rs.getString("date");

                    model.addRow(new Object[] { id, name, text, total_price,admin_name,order_time});
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            panel_table_Admin.add(scrollPane);
            panel_table_Admin.setLayout(null);
            user_panel_window.add(panel_table_Admin);
        }
        void Login_out(){

            try {
                String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                String user = "root";
                String password = "";
                Connection conn = DriverManager.getConnection(url, user, password);


                user_textArea.setText("");
                passwordField.setText("");
                label.setText("");
                user_frame_window.setVisible(false);
                conn.close();
                System.out.println("login out successful  : "+ user_textArea.getText());

            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }

    }
