import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public final class Wassl {
    //1327
    public static JPanel wassl =new JPanel();
    public DefaultTableModel model;
    public JPanel panel_Table=new JPanel();
    public JLabel dateTimeLabel;
    public static JLabel label_total=new JLabel("Total : 0.00 IQD");
    public JTextArea TextArea_wassl=new JTextArea();
    public static JTextArea TextArea_wassl_2 =new JTextArea();
    public String Total_money_print;
    public static double sum = 0.0;
    public static JFrame frame_print=new JFrame();
    public JPanel panel2_label=new JPanel();
    public static JButton button_rest =new JButton("rest");
    public JButton button_Add =new JButton("ADD");
    public JButton button_total=new JButton("total");
    public static JButton Button_print =new JButton("Print");
    public JButton button_exit =new JButton("Exit");
    public JButton save_button =new JButton("- save data -");
    public JButton print_pdf=new JButton("- print -");
    Wassl(){
        wassl.setBounds(1375,375 , 525,600);
        wassl.setBackground(Color.WHITE);
        wassl.setBorder(new LineBorder(Color.BLACK));
        wassl.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        DT();

        table();

        rest();

        total();

        exit();

        Add();

        Print();

        JLabel number=new JLabel();
        number.setBackground(new Color(157, 0, 0));

        wassl.setLayout(null);
        GUI.fastFood.add(wassl);
    }
    void total(){
        label_total.setBounds(30, 380, 250, 30);
        label_total.setFont(new Font("Arial", Font.PLAIN, 20));
        panel_Table.add(label_total);

        button_total.setBounds(320,530 , 80, 40);
        button_total.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                    Statement stmt = con.createStatement();

                    ResultSet rs = stmt.executeQuery("SELECT SUM(total_price) FROM menu");

                    if (rs.next()) {
                        sum = rs.getDouble(1);
                    }

                    rs.close();
                    stmt.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                String formattedSum = String.format("%.2f", sum);

                label_total.setText("Total : " + formattedSum+" IQD");
                 Total_money_print = label_total.getText();
            }
        });

        //wassl.add(button_total);
    }
    void Print(){
        String finall_wasll= """
                \n***************************************************************************************************
                                                                Welcome to our restaurant
                *****************************************************************************************************
                ID  |             food name                         |  food Price   |  food quantity | total price
                --------------------------------------------------------------------------------------------------------
                """;

        Button_print.setBounds(320,530 , 80, 40);
        Button_print.setMnemonic(KeyEvent.VK_P);
        Button_print.setEnabled(false);

        frame_print.setBounds(500, 250, 800, 700);
        frame_print.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panel2_label.setBounds(0, 0, 800, 700);
        panel2_label.setBackground(new Color(153, 0, 0));

        TextArea_wassl.setBounds(20, 30, 730, 560);
        TextArea_wassl.setBackground(Color.white);
        TextArea_wassl.setOpaque(true);
        TextArea_wassl.setLayout(null);
        TextArea_wassl.setEditable(false);
        panel2_label.add(TextArea_wassl);

        print_pdf.setBounds(30, 600, 90, 30);
        print_pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document document = new Document() {};

                try {
                    PdfWriter.getInstance((com.itextpdf.text.Document) document, (OutputStream) new FileOutputStream("output.pdf"));

                    document.open();

                    document.add(new Paragraph(TextArea_wassl.getText()));

                } catch (DocumentException | FileNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    document.close();
                }

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save PDF");
                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    try {
                        Files.move(Path.of("output.pdf"), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        panel2_label.add(print_pdf);

        save_button.setBounds(140, 600, 100, 30);
        save_button.setMnemonic(KeyEvent.VK_S);
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save_data_user s=new Save_data_user();
            }
        });
        panel2_label.add(save_button);
        Button_print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                    String username = "root";
                    String password = "";
                    Connection conn = DriverManager.getConnection(url, username, password);

                    Statement stmt = conn.createStatement();
                    String query = "SELECT id, food_name, food_price, food_quantity, total_price FROM menu";
                    ResultSet rs = stmt.executeQuery(query);

                    StringBuilder sb = new StringBuilder();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String foodName = rs.getString("food_name");
                        double foodPrice = rs.getDouble("food_price");
                        int foodQuantity = rs.getInt("food_quantity");
                        double foodTotal = rs.getDouble("total_price");
                        sb.append(id).append("   | ").append(foodName).append("| ")
                                .append(foodPrice).append("             | ")
                                .append(foodQuantity).append("                   | ")
                                .append(foodTotal).append("\n");
                    }

                    Font currentFont = TextArea_wassl.getFont();
                    Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), 20);
                    TextArea_wassl.setFont(newFont);


                    String data= "                                 "+dateTimeLabel.getText();
                    data+=finall_wasll;
                    data+= sb.toString();

                    data+="*****************************************************************************************************";
                    data+="\n"+label_total.getText();

                    TextArea_wassl.setText(data);

                    TextArea_wassl_2.setText(data);

                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame_print.setVisible(true);
            }
        });

        panel2_label.setLayout(null);
        frame_print.add(panel2_label);
        wassl.add(Button_print);

    }
    void table(){

        JTable table2;
        panel_Table.setBounds(10, 50, 500, 450);
        panel_Table.setBackground(Color.white);
        panel_Table.setBorder(new LineBorder(Color.BLACK));
        panel_Table.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Food Name");
        model.addColumn("Food Price");
        model.addColumn("Food Quantity");
        model.addColumn("Total Price");

        table2 = new JTable(model);
        table2.setBounds(10, 10, 480, 350);
        JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setBounds(10, 10, 480, 350);
        scrollPane.setPreferredSize(new Dimension(480, 350));

        button_Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM menu");

                    model.setRowCount(0);

                    while (rs.next()) {
                        String id = rs.getString("id");
                        String name = rs.getString("food_name");
                        String price = rs.getString("food_price");
                        String quantity = rs.getString("food_quantity");
                        String total = rs.getString("total_price");


                        model.addRow(new Object[] { id, name, price, quantity, total });
                    }
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        button_rest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                model.setRowCount(0);
            }
        });
        panel_Table.add(scrollPane);
        panel_Table.setLayout(null);
        wassl.add(panel_Table);

    }
    void DT(){

        dateTimeLabel = new JLabel("", SwingConstants.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dateTimeLabel.setBounds(120,10, 300, 30);
        dateTimeLabel.setBackground(new Color(153, 0, 0));
        dateTimeLabel.setForeground(Color.white);
        dateTimeLabel.setOpaque(true);


        // Update the label every second
        Thread thread = new Thread(() -> {
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss  <->  yyyy-MM-dd");
                String formattedDateTime = now.format(formatter);
                dateTimeLabel.setText(formattedDateTime);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        wassl.add(dateTimeLabel);


    }
    static void rest(){
        button_rest.setBounds(20,530 , 80, 40);
        button_rest.setMnemonic(KeyEvent.VK_R);
        button_rest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza.pizza_Margherita_CheckBox.setSelected(false);
                Pizza.CheckBox_pizza_Margherita_size_S.setSelected(false);
                Pizza.CheckBox_pizza_Margherita_size_L.setSelected(false);
                Pizza.CheckBox_pizza_Margherita_size_M.setSelected(false);

                Pizza.CheckBox_pizza_Margherita_size_S.setEnabled(false);
                Pizza.CheckBox_pizza_Margherita_size_M.setEnabled(false);
                Pizza.CheckBox_pizza_Margherita_size_L.setEnabled(false);

                Pizza.jTextArea_margarita_size_s.setEnabled(false);
                Pizza.jTextArea_margarita_size_M.setEnabled(false);
                Pizza.jTextArea_margarita_size_L.setEnabled(false);

                Pizza.jlabel_wassl_margarita_size_s.setEnabled(false);
                Pizza.jlabel_wassl_margarita_size_M.setEnabled(false);
                Pizza.jlabel_wassl_margarita_size_L.setEnabled(false);

                Pizza.jlabel_wassl_margarita_size_s.setText("0 IQD");
                Pizza.jlabel_wassl_margarita_size_M.setText("0 IQD");
                Pizza.jlabel_wassl_margarita_size_L.setText("0 IQD");

                Pizza.jTextArea_margarita_size_s.setText("");
                Pizza.jTextArea_margarita_size_M.setText("");
                Pizza.jTextArea_margarita_size_L.setText("");

                Pizza.jlabel_price_pizza_Margherita_size_s.setEnabled(false);
                Pizza.jlabel_price_pizza_Margherita_size_M.setEnabled(false);
                Pizza.jlabel_price_pizza_Margherita_size_L.setEnabled(false);

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Pizza.pizza_BBQ_chicken_ChokeBox.setSelected(false);
                Pizza.CheckBox_pizza_BBQ_chicken_size_S.setSelected(false);
                Pizza.CheckBox_pizza_BBQ_chicken_size_M.setSelected(false);
                Pizza.CheckBox_pizza_BBQ_chicken_size_L.setSelected(false);

                Pizza.CheckBox_pizza_BBQ_chicken_size_S.setEnabled(false);
                Pizza.CheckBox_pizza_BBQ_chicken_size_M.setEnabled(false);
                Pizza.CheckBox_pizza_BBQ_chicken_size_L.setEnabled(false);

                Pizza.jTextArea_BBQ_chicken_size_s.setEnabled(false);
                Pizza.jTextArea_BBQ_chicken_size_M.setEnabled(false);
                Pizza.jTextArea_BBQ_chicken_size_L.setEnabled(false);

                Pizza.jlabel_wassl_BBQ_chicken_size_s.setEnabled(false);
                Pizza.jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);
                Pizza.jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);

                Pizza.jlabel_wassl_BBQ_chicken_size_s.setText("0 IQD");
                Pizza.jlabel_wassl_BBQ_chicken_size_M.setText("0 IQD");
                Pizza.jlabel_wassl_BBQ_chicken_size_L.setText("0 IQD");

                Pizza.jTextArea_BBQ_chicken_size_s.setText("");
                Pizza.jTextArea_BBQ_chicken_size_M.setText("");
                Pizza.jTextArea_BBQ_chicken_size_L.setText("");

                Pizza.jlabel_price_pizza_BBQ_chicken_size_s.setEnabled(false);
                Pizza.jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);
                Pizza.jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Pizza.pizza_Mexican_ChokeBox.setSelected(false);
                Pizza.CheckBox_pizza_Mexican_pizza_size_S.setSelected(false);
                Pizza.CheckBox_pizza_Mexican_pizza_size_M.setSelected(false);
                Pizza.CheckBox_pizza_Mexican_pizza_size_L.setSelected(false);

                Pizza.CheckBox_pizza_Mexican_pizza_size_S.setEnabled(false);
                Pizza.CheckBox_pizza_Mexican_pizza_size_M.setEnabled(false);
                Pizza.CheckBox_pizza_Mexican_pizza_size_L.setEnabled(false);

                Pizza.jTextArea_Mexican_pizza_size_s.setEnabled(false);
                Pizza.jTextArea_Mexican_pizza_size_M.setEnabled(false);
                Pizza.jTextArea_Mexican_pizza_size_L.setEnabled(false);

                Pizza.jTextArea_Mexican_pizza_size_s.setText("");
                Pizza.jTextArea_Mexican_pizza_size_M.setText("");
                Pizza.jTextArea_Mexican_pizza_size_L.setText("");

                Pizza.jlabel_wassl_Mexican_pizza_size_s.setText("0 IQD");
                Pizza.jlabel_wassl_Mexican_pizza_size_M.setText("0 IQD");
                Pizza.jlabel_wassl_Mexican_pizza_size_L.setText("0 IQD");

                Pizza.jlabel_wassl_Mexican_pizza_size_s.setEnabled(false);
                Pizza.jlabel_wassl_Mexican_pizza_size_M.setEnabled(false);
                Pizza.jlabel_wassl_Mexican_pizza_size_L.setEnabled(false);

                Pizza.jlabel_price_pizza_Mexican_pizza_size_s.setEnabled(false);
                Pizza.jlabel_price_pizza_Mexican_pizza_size_M.setEnabled(false);
                Pizza.jlabel_price_pizza_Mexican_pizza_size_L.setEnabled(false);

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Burger.CheckBox_cheese_Chicken_Wrap.setSelected(false);

                Burger.checkBox_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                Burger.checkBox_Cheese_Chicken_Wrap_size_S.setSelected(false);
                Burger.jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                Burger.jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                Burger.jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText("0 IQD");

                Burger.checkBox_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                Burger.checkBox_Cheese_Chicken_Wrap_size_L.setSelected(false);
                Burger.jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                Burger.jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
                Burger.jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText("0 IQD");

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Burger.Cheese_Burger_CheckBox.setSelected(false);

                Burger.checkBox_Cheese_Burger_size_S.setEnabled(false);
                Burger.checkBox_Cheese_Burger_size_S.setSelected(false);
                Burger.jTextArea_Cheese_Burger_size_S.setEnabled(false);
                Burger.jTextArea_Cheese_Burger_size_S.setText("");
                Burger.jlabel_price_Cheese_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Burger_size_s.setText("0 IQD");

                Burger.checkBox_Cheese_Burger_size_L.setEnabled(false);
                Burger.checkBox_Cheese_Burger_size_L.setSelected(false);
                Burger.jTextArea_Cheese_Burger_size_L.setEnabled(false);
                Burger.jTextArea_Cheese_Burger_size_L.setText("");
                Burger.jlabel_price_Cheese_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Cheese_Burger_size_L.setText("0 IQD");

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                Burger.Farm_Burger_CheckBox.setSelected(false);

                Burger.checkBox_Farm_Burger_size_S.setEnabled(false);
                Burger.checkBox_Farm_Burger_size_S.setSelected(false);
                Burger.jTextArea_Farm_Burger_size_S.setEnabled(false);
                Burger.jTextArea_Farm_Burger_size_S.setText("");
                Burger.jlabel_price_Farm_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Farm_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Farm_Burger_size_s.setText("0 IQD");

                Burger.checkBox_Farm_Burger_size_L.setEnabled(false);
                Burger.checkBox_Farm_Burger_size_L.setSelected(false);
                Burger.jTextArea_Farm_Burger_size_L.setEnabled(false);
                Burger.jTextArea_Farm_Burger_size_L.setText("");
                Burger.jlabel_price_Farm_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Farm_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Farm_Burger_size_L.setText("0 IQD");



                Burger.Double_Cheese_Burger_CheckBox.setSelected(false);

                Burger.checkBox_Double_Cheese_Burger_size_S.setEnabled(false);
                Burger.checkBox_Double_Cheese_Burger_size_S.setSelected(false);
                Burger.jTextArea_Double_Cheese_Burger_size_S.setEnabled(false);
                Burger.jTextArea_Double_Cheese_Burger_size_S.setText("");
                Burger.jlabel_price_Double_Cheese_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Double_Cheese_Burger_size_s.setEnabled(false);
                Burger.jlabel_wassl_Double_Cheese_Burger_size_s.setText("0 IQD");

                Burger.checkBox_Double_Cheese_Burger_size_L.setEnabled(false);
                Burger.checkBox_Double_Cheese_Burger_size_L.setSelected(false);
                Burger.jTextArea_Double_Cheese_Burger_size_L.setEnabled(false);
                Burger.jTextArea_Double_Cheese_Burger_size_L.setText("");
                Burger.jlabel_price_Double_Cheese_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Double_Cheese_Burger_size_L.setEnabled(false);
                Burger.jlabel_wassl_Double_Cheese_Burger_size_L.setText("0 IQD");


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Lasagna.lasagna_meat_CheckBox.setSelected(false);

                Lasagna.checkBox_lasagna_meat_size_S.setEnabled(false);
                Lasagna.checkBox_lasagna_meat_size_S.setSelected(false);
                Lasagna.jlabel_price_lasagna_meat_size_s.setEnabled(false);
                Lasagna.jTextArea_lasagna_meat_size_S.setEnabled(false);
                Lasagna.jTextArea_lasagna_meat_size_S.setText("");
                Lasagna.jlabel_wassl_lasagna_meat_size_s.setText("0 IQD");
                Lasagna.jlabel_wassl_lasagna_meat_size_s.setEnabled(false);

                Lasagna.checkBox_lasagna_meat_size_L.setEnabled(false);
                Lasagna.checkBox_lasagna_meat_size_L.setSelected(false);
                Lasagna.jlabel_price_lasagna_meat_size_L.setEnabled(false);
                Lasagna.jTextArea_lasagna_meat_size_L.setEnabled(false);
                Lasagna.jTextArea_lasagna_meat_size_L.setText("");
                Lasagna.jlabel_wassl_lasagna_meat_size_L.setText("0 IQD");
                Lasagna.jlabel_wassl_lasagna_meat_size_L.setEnabled(false);

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Potato_finger.potato_CheckBox.setSelected(false);

                Potato_finger.checkBox_potato1.setSelected(false);
                Potato_finger.checkBox_potato1.setEnabled(false);
                Potato_finger.jlabel_price_potato1.setEnabled(false);
                Potato_finger.jTextArea_potato1.setEnabled(false);
                Potato_finger.jTextArea_potato1.setText("");
                Potato_finger.jlabel_wassl_potato1.setEnabled(false);
                Potato_finger.jlabel_wassl_potato1.setText("0 IQD");

                Potato_finger.checkBox_potato2.setSelected(false);
                Potato_finger.checkBox_potato2.setEnabled(false);
                Potato_finger.jlabel_price_potato2.setEnabled(false);
                Potato_finger.jTextArea_potato2.setEnabled(false);
                Potato_finger.jTextArea_potato2.setText("");
                Potato_finger.jlabel_wassl_potato2.setEnabled(false);
                Potato_finger.jlabel_wassl_potato2.setText("0 IQD");

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Combo.combo1_CheckBox.setSelected(false);

                Combo.jTextArea_structure_combo1.setEnabled(false);

                Combo.jSpinner_combo1.setValue(0);
                Combo.jSpinner_combo1.setEnabled(false);
                Combo.jLabel_price_combo1.setText("0 IQD");
                Combo.jLabel_price_combo1.setEnabled(false);

                Combo.jcomboBox_drinkList.setEnabled(false);
                Combo.jlale_drinkPhoto.setEnabled(false);
                Combo.jcomboBox_drinkList.setSelectedItem("select one");
                Combo.jlale_drinkPhoto.setIcon(new ImageIcon("white.jpg"));

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Combo.combo2_CheckBox.setSelected(false);

                Combo.jTextArea_structure_combo2.setEnabled(false);

                Combo.jSpinner_combo2.setValue(0);
                Combo.jSpinner_combo2.setEnabled(false);
                Combo.jLabel_price_combo2.setText("0 IQD");
                Combo.jLabel_price_combo2.setEnabled(false);

                Combo.jcomboBox_drinkList2.setEnabled(false);
                Combo.jlale_drinkPhoto2.setEnabled(false);
                Combo.jcomboBox_drinkList2.setSelectedItem("select one");
                Combo.jlale_drinkPhoto2.setIcon(new ImageIcon("white.jpg"));

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Drink.water_ChakeBox.setSelected(false);
                Drink.water_JSpinner.setValue(0);
                Drink.water_JSpinner.setEnabled(false);
                Drink.water_JLable.setText("0 IQD");
                Drink.water_JLable.setEnabled(false);

                Drink.cocaCola_ChakeBox.setSelected(false);
                Drink.coca_Cola_JSpinner.setValue(0);
                Drink.coca_Cola_JSpinner.setEnabled(false);
                Drink.coca_Cola_JLable.setText("0 IQD");
                Drink.coca_Cola_JLable.setEnabled(false);

                Drink.pepsi_ChakeBox.setSelected(false);
                Drink.pepsi_JSpinner.setValue(0);
                Drink.pepsi_JSpinner.setEnabled(false);
                Drink.pepsi_JLable.setText("0 IQD");
                Drink.pepsi_JLable.setEnabled(false);

                Drink.dew_ChakeBox.setSelected(false);
                Drink.dew_JSpinner.setValue(0);
                Drink.dew_JSpinner.setEnabled(false);
                Drink.dew_JLable.setText("0 IQD");
                Drink.dew_JLable.setEnabled(false);

                Drink.fanta_ChakeBox.setSelected(false);
                Drink.fanta_JSpinner.setValue(0);
                Drink.fanta_JSpinner.setEnabled(false);
                Drink.fanta_JLable.setText("0 IQD");
                Drink.fanta_JLable.setEnabled(false);

                Drink.sprite_ChakeBox.setSelected(false);
                Drink.sprite_JSpinner.setValue(0);
                Drink.sprite_JSpinner.setEnabled(false);
                Drink.sprite_JLable.setText("0 IQD");
                Drink.sprite_JLable.setEnabled(false);

                label_total.setText("Total : 0.00 IQD");


                try (Statement stmt = Main.conn.createStatement()) {
                    String sql = "TRUNCATE TABLE menu";
                    System.out.println("All data deleted from menu");
                    stmt.executeUpdate(sql);
                } catch (SQLException ex) {
                    // handle the exception
                    ex.printStackTrace();
                }

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_menu", "root", "");
                    String query = "DELETE FROM menu";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    System.out.println(query);
                    pstmt.executeUpdate();
                    con.close();

                } catch (Exception exxx) {
                    System.out.println(e);
                }
                Button_print.setEnabled(false);
            }

        });



        wassl.add(button_rest);


    }
    void exit(){


        button_exit.setBounds(120,530 , 80, 40);
        button_exit.setMnemonic(KeyEvent.VK_E);
        button_exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {


                try (Statement stmt = Main.conn.createStatement()) {
                    String sql = "TRUNCATE TABLE menu";
                    stmt.executeUpdate(sql);
                    System.out.println("All data deleted from menu");
                } catch (SQLException ex) {
                    // handle the exception
                    ex.printStackTrace();
                }
                //Login_in.frame.setVisible(true);
                GUI.frame.dispose();
                frame_print.dispose();
                button_rest.doClick();

                System.exit(0);
            }


        });

        wassl.add(button_exit);

    }
    void Add(){


        button_Add.setBounds(221,530 , 80, 40);
        button_Add.setMnemonic(KeyEvent.VK_A);

        button_Add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent exx) {

                if (Pizza.pizza_Margherita_CheckBox.isSelected()) {
                    if (Pizza.CheckBox_pizza_Margherita_size_S.isSelected()) {
                        if (Pizza.jTextArea_margarita_size_s.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Margherita_size_small           ");

                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("3.5"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Margherita_size_S[0]);
                                    updateStmt.setString(3, "pizza_Margherita_size_small           ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Margherita_size_small           ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("3.5"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Margherita_size_S[0]);
                                    double totalPrice = 3.5 * Pizza.value_pizza_Margherita_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    }
                    if (Pizza.CheckBox_pizza_Margherita_size_M.isSelected()) {
                        if (Pizza.jTextArea_margarita_size_M.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Margherita_size_medium       ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("7"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Margherita_size_M[0]);
                                    updateStmt.setString(3, "pizza_Margherita_size_medium       ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Margherita_size_medium       ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("7"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Margherita_size_M[0]);
                                    double totalPrice = 7 * Pizza.value_pizza_Margherita_size_M[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if (Pizza.CheckBox_pizza_Margherita_size_L.isSelected()) {
                        if (Pizza.jTextArea_margarita_size_L.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Margherita_size_Large          ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("9"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Margherita_size_L[0]);
                                    updateStmt.setString(3, "pizza_Margherita_size_Large          ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Margherita_size_Large          ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("9"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Margherita_size_L[0]);
                                    double totalPrice = 9 * Pizza.value_pizza_Margherita_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }


                }

                if (Pizza.pizza_BBQ_chicken_ChokeBox.isSelected()) {
                    if (Pizza.CheckBox_pizza_BBQ_chicken_size_S.isSelected()) {
                        if (Pizza.jTextArea_BBQ_chicken_size_s.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_BBQ chicken_size_small        ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("3.5"));
                                    updateStmt.setInt(2, Pizza.value_pizza_BBQ_chicken_size_S[0]);
                                    updateStmt.setString(3, "pizza_BBQ chicken_size_small        ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_BBQ chicken_size_small        ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("3.5"));
                                    insertStmt.setInt(3, Pizza.value_pizza_BBQ_chicken_size_S[0]);
                                    double totalPrice = 3.5 * Pizza.value_pizza_BBQ_chicken_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if (Pizza.CheckBox_pizza_BBQ_chicken_size_M.isSelected()) {
                        if (Pizza.jTextArea_BBQ_chicken_size_M.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_BBQ chicken_size_medium    ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("7"));
                                    updateStmt.setInt(2, Pizza.value_pizza_BBQ_chicken_size_M[0]);
                                    updateStmt.setString(3, "pizza_BBQ chicken_size_medium    ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_BBQ chicken_size_medium    ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("7"));
                                    insertStmt.setInt(3, Pizza.value_pizza_BBQ_chicken_size_M[0]);
                                    double totalPrice = 7 * Pizza.value_pizza_BBQ_chicken_size_M[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if (Pizza.CheckBox_pizza_BBQ_chicken_size_L.isSelected()) {
                        if (Pizza.jTextArea_BBQ_chicken_size_L.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_BBQ chicken_size_Large       ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("10"));
                                    updateStmt.setInt(2, Pizza.value_pizza_BBQ_chicken_size_L[0]);
                                    updateStmt.setString(3, "pizza_BBQ chicken_size_Large       ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_BBQ chicken_size_Large       ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("10"));
                                    insertStmt.setInt(3, Pizza.value_pizza_BBQ_chicken_size_L[0]);
                                    double totalPrice = 10 * Pizza.value_pizza_BBQ_chicken_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }

                if (Pizza.pizza_Mexican_ChokeBox.isSelected()) {
                    if (Pizza.CheckBox_pizza_Mexican_pizza_size_S.isSelected()) {
                        if (Pizza.jTextArea_Mexican_pizza_size_s.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Mexican_size_small               ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("5"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Mexican_pizza_size_S[0]);
                                    updateStmt.setString(3, "pizza_Mexican_size_small               ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Mexican_size_small               ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("5"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Mexican_pizza_size_S[0]);
                                    double totalPrice = 5 * Pizza.value_pizza_Mexican_pizza_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                    if (Pizza.CheckBox_pizza_Mexican_pizza_size_M.isSelected()) {
                        if (Pizza.jTextArea_Mexican_pizza_size_M.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Mexican_size_medium            ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("9"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Mexican_pizza_size_M[0]);
                                    updateStmt.setString(3, "pizza_Mexican_size_medium           ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Mexican_size_medium           ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("9"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Mexican_pizza_size_M[0]);
                                    double totalPrice = 9 * Pizza.value_pizza_Mexican_pizza_size_M[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if (Pizza.CheckBox_pizza_Mexican_pizza_size_L.isSelected()) {
                        if (Pizza.jTextArea_Mexican_pizza_size_L.getText().length() > 0) {
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "pizza_Mexican_size_Large               ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("13"));
                                    updateStmt.setInt(2, Pizza.value_pizza_Mexican_pizza_size_L[0]);
                                    updateStmt.setString(3, "pizza_Mexican_size_Large              ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "pizza_Mexican_size_Large              ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("13"));
                                    insertStmt.setInt(3, Pizza.value_pizza_Mexican_pizza_size_L[0]);
                                    double totalPrice = 13 * Pizza.value_pizza_Mexican_pizza_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }

                        }
                    }
                }

                ///////////////////////////////////////////////////////

                if(Burger.CheckBox_cheese_Chicken_Wrap.isSelected()){
                    if(Burger.checkBox_Cheese_Chicken_Wrap_size_S.isSelected()){
                        if(Burger.jTextArea_Cheese_Chicken_Wrap_size_S.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Cheese_Chicken_Wrap_size_Small  ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("3"));
                                    updateStmt.setInt(2, Burger.value_Cheese_Chicken_Wrap_size_S[0]);
                                    updateStmt.setString(3, "Cheese_Chicken_Wrap_size_Small ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Cheese_Chicken_Wrap_size_Small ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("3"));
                                    insertStmt.setInt(3, Burger.value_Cheese_Chicken_Wrap_size_S[0]);
                                    double totalPrice = 3  * Burger.value_Cheese_Chicken_Wrap_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                    if(Burger.checkBox_Cheese_Chicken_Wrap_size_L.isSelected()){
                        if(Burger.jTextArea_Cheese_Chicken_Wrap_size_L.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Cheese_Chicken_Wrap_size_Large ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("5"));
                                    updateStmt.setInt(2, Burger.value_Cheese_Chicken_Wrap_size_L[0]);
                                    updateStmt.setString(3, "Cheese_Chicken_Wrap_size_Large ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Cheese_Chicken_Wrap_size_Large ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("5"));
                                    insertStmt.setInt(3, Burger.value_Cheese_Chicken_Wrap_size_L[0]);
                                    double totalPrice = 5 * Burger.value_Cheese_Chicken_Wrap_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }

                }

                if(Burger.Cheese_Burger_CheckBox.isSelected()){
                    if(Burger.checkBox_Cheese_Burger_size_S.isSelected()){
                        if (Burger.jTextArea_Cheese_Burger_size_S.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Cheese_Burger_size_Small               ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("5"));
                                    updateStmt.setInt(2, Burger.value_Cheese_Chicken_Wrap_size_S[0]);
                                    updateStmt.setString(3, "Cheese_Burger_size_Small          ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Cheese_Burger_size_Small             ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("5"));
                                    insertStmt.setInt(3, Burger.value_Cheese_Chicken_Wrap_size_L[0]);
                                    double totalPrice =5 * Burger.value_Cheese_Chicken_Wrap_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                    if(Burger.checkBox_Cheese_Burger_size_L.isSelected()){
                        if (Burger.jTextArea_Cheese_Burger_size_L.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Cheese_Burger_size_Large              ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("8"));
                                    updateStmt.setInt(2, Burger.value_Cheese_Burger_size_L[0]);
                                    updateStmt.setString(3, "Cheese_Burger_size_Large             ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Cheese_Burger_size_Large             ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("8"));
                                    insertStmt.setInt(3, Burger.value_Cheese_Burger_size_L[0]);
                                    double totalPrice = 8 * Burger.value_Cheese_Burger_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                }

                if(Burger.Farm_Burger_CheckBox.isSelected()){
                    if(Burger.checkBox_Farm_Burger_size_S.isSelected()){
                        if (Burger.jTextArea_Farm_Burger_size_S.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Farm_Burger_size_Small                ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("6.5"));
                                    updateStmt.setInt(2, Burger.value_Farm_Burger_size_S[0]);
                                    updateStmt.setString(3, "Farm_Burger_size_Small                ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Farm_Burger_size_Small                ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("6.5"));
                                    insertStmt.setInt(3, Burger.value_Farm_Burger_size_S[0]);
                                    double totalPrice = 6.5 * Burger.value_Farm_Burger_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                    if(Burger.checkBox_Farm_Burger_size_L.isSelected()){
                        if (Burger.jTextArea_Farm_Burger_size_L.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Farm_Burger_size_Large                ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("9.5"));
                                    updateStmt.setInt(2, Burger.value_Farm_Burger_size_L[0]);
                                    updateStmt.setString(3, "Farm_Burger_size_Large               ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Farm_Burger_size_Large               ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("9.5"));
                                    insertStmt.setInt(3, Burger.value_Farm_Burger_size_L[0]);
                                    double totalPrice = 9.5 * Burger.value_Farm_Burger_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                }

                if(Burger.Double_Cheese_Burger_CheckBox.isSelected()){
                    if(Burger.checkBox_Double_Cheese_Burger_size_S.isSelected()){
                        if (Burger.jTextArea_Double_Cheese_Burger_size_S.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Double_Cheese_Burger_size_Small");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("9"));
                                    updateStmt.setInt(2, Burger.value_Double_Cheese_Burger_size_S[0]);
                                    updateStmt.setString(3, "Double_Cheese_Burger_size_Small");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Double_Cheese_Burger_size_Small");
                                    insertStmt.setBigDecimal(2, new BigDecimal("9"));
                                    insertStmt.setInt(3, Burger.value_Double_Cheese_Burger_size_S[0]);
                                    double totalPrice = 9 * Burger.value_Double_Cheese_Burger_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                    if(Burger.checkBox_Double_Cheese_Burger_size_L.isSelected()){
                        if (Burger.jTextArea_Double_Cheese_Burger_size_L.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Double_Cheese_Burger_size_Large");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("12"));
                                    updateStmt.setInt(2, Burger.value_Double_Cheese_Burger_size_L[0]);
                                    updateStmt.setString(3, "Double_Cheese_Burger_size_Large");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Double_Cheese_Burger_size_Large");
                                    insertStmt.setBigDecimal(2, new BigDecimal("12"));
                                    insertStmt.setInt(3, Burger.value_Double_Cheese_Burger_size_L[0]);
                                    double totalPrice = 12 * Burger.value_Double_Cheese_Burger_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);


                            }
                        }
                    }
                }

                ///////////////////////////////////////////////////////

                if(Lasagna.lasagna_meat_CheckBox.isSelected()){
                    if (Lasagna.checkBox_lasagna_meat_size_S.isSelected()){
                        if(Lasagna.jTextArea_lasagna_meat_size_S.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "lasagna_meat_size_Small            ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("6.5"));
                                    updateStmt.setInt(2, Lasagna.value_lasagna_meat_size_S[0]);
                                    updateStmt.setString(3, "lasagna_meat_size_Small               ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "lasagna_meat_size_Small               ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("6.5"));
                                    insertStmt.setInt(3, Lasagna.value_lasagna_meat_size_S[0]);
                                    double totalPrice = 6.5* Lasagna.value_lasagna_meat_size_S[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if (Lasagna.checkBox_lasagna_meat_size_L.isSelected()){
                        if(Lasagna.jTextArea_lasagna_meat_size_L.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "lasagna_meat_size_Large            ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("9.5"));
                                    updateStmt.setInt(2, Lasagna.value_lasagna_meat_size_L[0]);
                                    updateStmt.setString(3, "lasagna_meat_size_Large               ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "lasagna_meat_size_Large               ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("9.5"));
                                    insertStmt.setInt(3, Lasagna.value_lasagna_meat_size_L[0]);
                                    double totalPrice = 9.5 * Lasagna.value_lasagna_meat_size_L[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }

                ////////////////////////////////////////////////////////

                if(Potato_finger.potato_CheckBox.isSelected()){
                    if (Potato_finger.checkBox_potato1.isSelected()){
                        if(Potato_finger.jTextArea_potato1.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Potato_Small                                 ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("2"));
                                    updateStmt.setInt(2, Potato_finger.value_potato1[0]);
                                    updateStmt.setString(3, "Potato_Small                                 ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Potato_Small                                 ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("2"));
                                    insertStmt.setInt(3, Potato_finger.value_potato1[0]);
                                    double totalPrice = 2 * Potato_finger.value_potato1[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    if(Potato_finger.checkBox_potato2.isSelected()){
                        if(Potato_finger.jTextArea_potato2.getText().length()>0){
                            String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                            String username = "root";
                            String password = "";
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(url, username, password);

                                // Check if the data already exists in the table
                                String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                                checkStmt.setString(1, "Potato_Large                                  ");
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // If the data already exists, update the existing record
                                    String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                    updateStmt.setBigDecimal(1, new BigDecimal("5"));
                                    updateStmt.setInt(2, Potato_finger.value_potato2[0]);
                                    updateStmt.setString(3, "Potato_Large                                  ");
                                    int rowsAffected = updateStmt.executeUpdate();
                                } else {
                                    // If the data does not exist, insert a new record
                                    String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                    insertStmt.setString(1, "Potato_large                                  ");
                                    insertStmt.setBigDecimal(2, new BigDecimal("5"));
                                    insertStmt.setInt(3, Potato_finger.value_potato2[0]);
                                    double totalPrice = 5 * Potato_finger.value_potato2[0];
                                    insertStmt.setFloat(4, (float) totalPrice);
                                    int rowsAffected = insertStmt.executeUpdate();
                                }
                                conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    }

                }

                ////////////////////////////////////////////////////////

                if(Combo.combo1_CheckBox.isSelected()){
                    if(!Combo.jSpinner_combo1.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "combo 1                                        ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("7.5"));
                                updateStmt.setInt(2, Combo.value_jSpinner_combo1[0]);
                                updateStmt.setString(3, "combo 1                                        ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "combo 1                                        ");
                                insertStmt.setBigDecimal(2, new BigDecimal("7.5"));
                                insertStmt.setInt(3, Combo.value_jSpinner_combo1[0]);
                                double totalPrice = 7.5* Combo.value_jSpinner_combo1[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }

                if(Combo.combo2_CheckBox.isSelected()){
                    if(!Combo.jSpinner_combo2.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "combo 2                                        ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("23"));
                                updateStmt.setInt(2, Combo.value_jSpinner_combo2[0]);
                                updateStmt.setString(3, "combo 2                                        ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "combo 2                                        ");
                                insertStmt.setBigDecimal(2, new BigDecimal("23"));
                                insertStmt.setInt(3, Combo.value_jSpinner_combo2[0]);
                                double totalPrice = 23 *Combo.value_jSpinner_combo2[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }

                ////////////////////////////////////////////////////////

                if(Drink.water_ChakeBox.isSelected()){
                    if(!Drink.water_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "water                                             ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("0.250"));
                                updateStmt.setInt(2, Drink.value_water[0]);
                                updateStmt.setString(3, "water                                             ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "water                                             ");
                                insertStmt.setBigDecimal(2, new BigDecimal("0.250"));
                                insertStmt.setInt(3, Drink.value_water[0]);
                                double totalPrice = 0.250 * Drink.value_water[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if(Drink.cocaCola_ChakeBox.isSelected()){
                    if(!Drink.coca_Cola_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "coca_Cola                                      ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("1"));
                                updateStmt.setInt(2, Drink.value_coca_Cola[0]);
                                updateStmt.setString(3, "coca_Cola                                      ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "coca_Cola                                      ");
                                insertStmt.setBigDecimal(2, new BigDecimal("1"));
                                insertStmt.setInt(3, Drink.value_coca_Cola[0]);
                                double totalPrice = 1* Drink.value_coca_Cola[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if(Drink.pepsi_ChakeBox.isSelected()){
                    if(!Drink.pepsi_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "pepsi                                              ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("0.500"));
                                updateStmt.setInt(2, Drink.value_pepsi[0]);
                                updateStmt.setString(3, "pepsi                                              ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "pepsi                                              ");
                                insertStmt.setBigDecimal(2, new BigDecimal("0.500"));
                                insertStmt.setInt(3, Drink.value_pepsi[0]);
                                double totalPrice = 0.500 * Drink.value_pepsi[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if(Drink.dew_ChakeBox.isSelected()){
                    if(!Drink.dew_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "dew                                               ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("0.500"));
                                updateStmt.setInt(2, Drink.value_dew[0]);
                                updateStmt.setString(3, "dew                                               ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "dew                                               ");
                                insertStmt.setBigDecimal(2, new BigDecimal("0.500"));
                                insertStmt.setInt(3, Drink.value_dew[0]);
                                double totalPrice = 0.500 * Drink.value_dew[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if(Drink.sprite_ChakeBox.isSelected()){
                    if(!Drink.sprite_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "sprite                                            ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("0.500"));
                                updateStmt.setInt(2, Drink.value_sprite[0]);
                                updateStmt.setString(3, "sprite                                              ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "sprite                                             ");
                                insertStmt.setBigDecimal(2, new BigDecimal("0.500"));
                                insertStmt.setInt(3, Drink.value_sprite[0]);
                                double totalPrice = 0.500 * Drink.value_sprite[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if(Drink.fanta_ChakeBox.isSelected()){
                    if(!Drink.fanta_JSpinner.getValue().equals(0)){
                        String url = "jdbc:mysql://localhost:3306/restaurant_menu";
                        String username = "root";
                        String password = "";
                        Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url, username, password);

                            // Check if the data already exists in the table
                            String checkSql = "SELECT * FROM menu WHERE food_name = ?";
                            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                            checkStmt.setString(1, "fanta                                          ");
                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                // If the data already exists, update the existing record
                                String updateSql = "UPDATE menu SET food_price = ?, food_quantity = ? WHERE food_name = ?";
                                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                                updateStmt.setBigDecimal(1, new BigDecimal("0.500"));
                                updateStmt.setInt(2, Drink.value_fanta[0]);
                                updateStmt.setString(3, "fanta                                            ");
                                int rowsAffected = updateStmt.executeUpdate();
                            } else {
                                // If the data does not exist, insert a new record
                                String insertSql = "INSERT INTO menu (food_name, food_price, food_quantity,total_price) VALUES (?, ?, ?,?)";
                                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                                insertStmt.setString(1, "fanta                                             ");
                                insertStmt.setBigDecimal(2, new BigDecimal("0.500"));
                                insertStmt.setInt(3, Drink.value_fanta[0]);
                                double totalPrice = 0.500 * Drink.value_fanta[0];
                                insertStmt.setFloat(4, (float) totalPrice);
                                int rowsAffected = insertStmt.executeUpdate();
                            }
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                button_total.doClick();

                if(sum>0){
                    Button_print.setEnabled(true);
                }


            }
        });

        wassl.add(button_Add);

    }
}
