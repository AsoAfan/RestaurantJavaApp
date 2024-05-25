

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Kebab {

    static double temp=0;
    int value_JSpinner_Pizza_margarita=0;

    public static JCheckBox Kebab1_CheckBox =new JCheckBox();
    public static JCheckBox CheckBox_Kebab1 =new JCheckBox();
    public static JLabel jlabel_price_Kebab1 =new JLabel();
    public static JTextArea jTextArea_Kebab1 =new JTextArea();
    public static JLabel jlabel_wassl_Kebab1 =new JLabel();
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static JCheckBox Kebab2_CheckBox =new JCheckBox();
    public static JCheckBox CheckBox_Kebab2 =new JCheckBox();
    public static JLabel jlabel_price_Kebab2 =new JLabel();
    public static JTextArea jTextArea_Kebab2 =new JTextArea();
    public static JLabel jlabel_wassl_Kebab2 =new JLabel();


    JPanel kabab =new JPanel();
    Kebab(){

        kabab.setBackground(Color.WHITE);
        kabab.setBorder(new LineBorder(Color.BLACK));
        kabab.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        kabab.setBounds(120,120,550,240);

        Kebab1();
        Kebab2();
        //Mexican_pizza();

        kabab.setLayout(null);

        GUI.grill.add(kabab);

    }

    void Kebab1(){

        JPanel panel_Kebab =new JPanel();
        panel_Kebab.setBounds(20, 20, 510,100 );
        panel_Kebab.setBackground(new Color(153, 0,0 ));
        panel_Kebab.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        JLabel KebabImage = new JLabel();
        KebabImage.setIcon(new ImageIcon("Kabab1.png"));
        KebabImage.setBounds(5, -30, 500, 150);

        Kebab1_CheckBox.setBounds(205,5,18,15);

        JLabel Kebab_name=new JLabel();
        Kebab_name.setText(" Kebab ");
        Kebab_name.setBounds(225, 5, 75, 15);
        Kebab_name.setBackground(Color.white);
        Kebab_name.setOpaque(true);

        Kebab1_CheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Kebab1_CheckBox.isSelected()){
                    CheckBox_Kebab1.setEnabled(true);
                    jlabel_price_Kebab1.setEnabled(true);
                }else{
                    CheckBox_Kebab1.setEnabled(false);
                    jlabel_price_Kebab1.setEnabled(false);
                    if(!Kebab1_CheckBox.isSelected()){
                        CheckBox_Kebab1.setSelected(false);
                        jlabel_price_Kebab1.setEnabled(false);
                        jTextArea_Kebab1.setText("");
                        jlabel_wassl_Kebab1.setEnabled(false);
                        jlabel_wassl_Kebab1.setText(0+" IQD");
                    }
                }
            }
        });

        CheckBox_Kebab1.setBounds(250,25,18,18);
        CheckBox_Kebab1.setEnabled(false);

        jlabel_price_Kebab1.setText(" one 3,500 IQD");
        jlabel_price_Kebab1.setBounds(275, 25, 115, 18);
        jlabel_price_Kebab1.setBackground(Color.white);
        jlabel_price_Kebab1.setOpaque(true);
        jlabel_price_Kebab1.setEnabled(false);

        jTextArea_Kebab1.setBounds(320, 50, 65, 20);
        jTextArea_Kebab1.setEnabled(false);

        jlabel_wassl_Kebab1.setBounds(400, 50, 80, 20);
        jlabel_wassl_Kebab1.setBackground(Color.WHITE);
        jlabel_wassl_Kebab1.setText("0 IQD");
        jlabel_wassl_Kebab1.setEnabled(false);
        jlabel_wassl_Kebab1.setOpaque(true);

        CheckBox_Kebab1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_Kebab1.isSelected()){
                    jlabel_wassl_Kebab1.setEnabled(true);
                    jTextArea_Kebab1.setEnabled(true);
                }else {
                    jlabel_wassl_Kebab1.setEnabled(false);
                    jlabel_wassl_Kebab1.setText(0+" IQD");
                    jTextArea_Kebab1.setText("");
                    jTextArea_Kebab1.setEnabled(false);
                }
            }
        });

        final double[] value = {0};
        final int[] num = new int[1];

        jTextArea_Kebab1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Kebab1.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    num[0] = 0;
                    jlabel_wassl_Kebab1.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        num[0] = Integer.parseInt(text);

                        num[0] = Integer.parseInt(String.valueOf(num[0]));

                        value[0] =(int) num[0] *3.5;
                        jlabel_wassl_Kebab1.setText(value[0] +" IQD");
                        temp+= value[0];
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Kebab1.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Kebab1.setText("0 IQD");
                }
            }
        });
        panel_Kebab.add(jTextArea_Kebab1);
        panel_Kebab.add(jlabel_wassl_Kebab1);
        panel_Kebab.add(CheckBox_Kebab1);
        panel_Kebab.add(jlabel_price_Kebab1);

        panel_Kebab.add(Kebab_name);
        panel_Kebab.add(Kebab1_CheckBox);
        panel_Kebab.add(KebabImage);
        panel_Kebab.setLayout(null);
        kabab.add(panel_Kebab);
    }

    void Kebab2(){
        /*JPanel BBQ_chicken =new JPanel();
        BBQ_chicken.setBounds(20, 125, 510,100 );
        BBQ_chicken.setBackground(new Color(153, 0,0 ));
        BBQ_chicken.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        JLabel PizzaImage = new JLabel();
        PizzaImage.setIcon(new ImageIcon("BBQ_chicken2.png"));
        PizzaImage.setBounds(-75, -10, 450, 120);


        Kebab2_CheckBox.setBounds(135,5,18,15);

        JLabel BBQ_chicken_Name=new JLabel();
        BBQ_chicken_Name.setText(" BBQ chicken ");
        BBQ_chicken_Name.setBounds(153, 5, 80, 15);
        BBQ_chicken_Name.setBackground(Color.white);
        BBQ_chicken_Name.setOpaque(true);


        Kebab2_CheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Kebab2_CheckBox.isSelected()){
                    CheckBox_Kebab2.setEnabled(true);
                    CheckBox_pizza_BBQ_chicken_size_M.setEnabled(true);
                    CheckBox_pizza_BBQ_chicken_size_L.setEnabled(true);


                    jlabel_price_Kebab2.setEnabled(true);
                    jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(true);
                    jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(true);
                }else{
                    CheckBox_Kebab2.setEnabled(false);
                    CheckBox_pizza_BBQ_chicken_size_M.setEnabled(false);
                    CheckBox_pizza_BBQ_chicken_size_L.setEnabled(false);

                    jlabel_price_Kebab2.setEnabled(false);
                    jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);
                    jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

                    if(!Kebab2_CheckBox.isSelected()){
                        CheckBox_Kebab2.setSelected(false);
                        CheckBox_pizza_BBQ_chicken_size_M.setSelected(false);
                        CheckBox_pizza_BBQ_chicken_size_L.setSelected(false);

                        jlabel_price_Kebab2.setEnabled(false);
                        jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);
                        jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

                        jTextArea_Kebab2.setText("");
                        jTextArea_BBQ_chicken_size_M.setText("");
                        jTextArea_BBQ_chicken_size_L.setText("");


                        jlabel_wassl_Kebab2.setEnabled(false);
                        jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);
                        jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);

                        jlabel_wassl_Kebab2.setText(0+" IQD");
                        jlabel_wassl_BBQ_chicken_size_L.setText(0+" IQD");
                        jlabel_wassl_BBQ_chicken_size_M.setText(0+" IQD");
                    }

                }
            }
        });

        CheckBox_Kebab2.setBounds(175,25,18,18);
        CheckBox_Kebab2.setEnabled(false);

        jlabel_price_Kebab2.setText(" small 3,500 IQD");
        jlabel_price_Kebab2.setBounds(192, 25, 115, 18);
        jlabel_price_Kebab2.setBackground(Color.white);
        jlabel_price_Kebab2.setOpaque(true);
        jlabel_price_Kebab2.setEnabled(false);

        jTextArea_Kebab2.setBounds(320, 25, 65, 20);
        jTextArea_Kebab2.setEnabled(false);

        jlabel_wassl_Kebab2.setBounds(400, 25, 80, 20);
        jlabel_wassl_Kebab2.setBackground(Color.WHITE);
        jlabel_wassl_Kebab2.setText("0 IQD");
        jlabel_wassl_Kebab2.setEnabled(false);
        jlabel_wassl_Kebab2.setOpaque(true);


        CheckBox_Kebab2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_Kebab2.isSelected()){
                    jlabel_wassl_Kebab2.setEnabled(true);
                    jTextArea_Kebab2.setEnabled(true);
                }else {
                    jlabel_wassl_Kebab2.setEnabled(false);
                    jlabel_wassl_Kebab2.setText(0+" IQD");
                    jTextArea_Kebab2.setEnabled(false);
                    jTextArea_Kebab2.setText("");
                }
            }
        });


        jTextArea_Kebab2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Kebab2.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    int num= 0;
                    jlabel_wassl_Kebab2.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        num = Integer.parseInt(text);

                        num= Integer.parseInt(String.valueOf(num));

                        double value=(int)num*3.5;
                        jlabel_wassl_Kebab2.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Kebab2.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Kebab2.setText("0 IQD");
                }



            }
        });






        CheckBox_pizza_BBQ_chicken_size_M.setBounds(175,50,18,18);
        CheckBox_pizza_BBQ_chicken_size_M.setEnabled(false);


        jlabel_price_pizza_BBQ_chicken_size_M.setText(" medium 7,000 IQD");
        jlabel_price_pizza_BBQ_chicken_size_M.setBounds(192, 50, 115, 18);
        jlabel_price_pizza_BBQ_chicken_size_M.setBackground(Color.white);
        jlabel_price_pizza_BBQ_chicken_size_M.setOpaque(true);
        jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);

        jTextArea_BBQ_chicken_size_M.setBounds(320, 50, 65, 20);
        jTextArea_BBQ_chicken_size_M.setEnabled(false);


        jlabel_wassl_BBQ_chicken_size_M.setBounds(400, 50, 80, 20);
        jlabel_wassl_BBQ_chicken_size_M.setBackground(Color.WHITE);
        jlabel_wassl_BBQ_chicken_size_M.setText("0 IQD");
        jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);
        jlabel_wassl_BBQ_chicken_size_M.setOpaque(true);

        CheckBox_pizza_BBQ_chicken_size_M.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_BBQ_chicken_size_M.isSelected()){
                    jlabel_wassl_BBQ_chicken_size_M.setEnabled(true);
                    jTextArea_BBQ_chicken_size_M.setEnabled(true);
                }else {
                    jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);
                    jlabel_wassl_BBQ_chicken_size_M.setText(0+" IQD");
                    jTextArea_BBQ_chicken_size_M.setEnabled(false);
                    jTextArea_BBQ_chicken_size_M.setText("");
                }
            }
        });


        jTextArea_BBQ_chicken_size_M.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_BBQ_chicken_size_M.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    int num= 0;
                    jlabel_wassl_BBQ_chicken_size_M.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        num = Integer.parseInt(text);

                        num= Integer.parseInt(String.valueOf(num));

                        double value=(int)num*7;
                        jlabel_wassl_BBQ_chicken_size_M.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_BBQ_chicken_size_M.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_BBQ_chicken_size_M.setText("0 IQD");
                }
            }
        });







        CheckBox_pizza_BBQ_chicken_size_L.setBounds(175,75,18,18);
        CheckBox_pizza_BBQ_chicken_size_L.setEnabled(false);


        jlabel_price_pizza_BBQ_chicken_size_L.setText(" lage 10,000 IQD");
        jlabel_price_pizza_BBQ_chicken_size_L.setBounds(192, 75, 115, 18);
        jlabel_price_pizza_BBQ_chicken_size_L.setBackground(Color.white);
        jlabel_price_pizza_BBQ_chicken_size_L.setOpaque(true);
        jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

        jTextArea_BBQ_chicken_size_L.setBounds(320, 75, 65, 20);
        jTextArea_BBQ_chicken_size_L.setEnabled(false);


        jlabel_wassl_BBQ_chicken_size_L.setBounds(400, 75, 80, 20);
        jlabel_wassl_BBQ_chicken_size_L.setBackground(Color.WHITE);
        jlabel_wassl_BBQ_chicken_size_L.setText("0 IQD");
        jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);
        jlabel_wassl_BBQ_chicken_size_L.setOpaque(true);


        CheckBox_pizza_BBQ_chicken_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_BBQ_chicken_size_L.isSelected()){
                    jlabel_wassl_BBQ_chicken_size_L.setEnabled(true);
                    jTextArea_BBQ_chicken_size_L.setEnabled(true);
                }else {
                    jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);
                    jlabel_wassl_BBQ_chicken_size_L.setText(0+" IQD");
                    jTextArea_BBQ_chicken_size_L.setEnabled(false);
                    jTextArea_BBQ_chicken_size_L.setText("");
                }
            }
        });


        jTextArea_BBQ_chicken_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_BBQ_chicken_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    int num= 0;
                    jlabel_wassl_BBQ_chicken_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        num = Integer.parseInt(text);

                        num= Integer.parseInt(String.valueOf(num));

                        double value=(int)num*10;
                        jlabel_wassl_BBQ_chicken_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_BBQ_chicken_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_BBQ_chicken_size_L.setText("0 IQD");
                }
            }
        });

        BBQ_chicken.add(jTextArea_Kebab2);
        BBQ_chicken.add(jlabel_wassl_Kebab2);
        BBQ_chicken.add(CheckBox_Kebab2);
        BBQ_chicken.add(jlabel_price_Kebab2);

        BBQ_chicken.add(jTextArea_BBQ_chicken_size_M);
        BBQ_chicken.add(jlabel_wassl_BBQ_chicken_size_M);
        BBQ_chicken.add(CheckBox_pizza_BBQ_chicken_size_M);
        BBQ_chicken.add(jlabel_price_pizza_BBQ_chicken_size_M);

        BBQ_chicken.add(jTextArea_BBQ_chicken_size_L);
        BBQ_chicken.add(jlabel_wassl_BBQ_chicken_size_L);
        BBQ_chicken.add(CheckBox_pizza_BBQ_chicken_size_L);
        BBQ_chicken.add(jlabel_price_pizza_BBQ_chicken_size_L);




        ////////////////////
        BBQ_chicken.add(BBQ_chicken_Name);
        BBQ_chicken.add(Kebab2_CheckBox);
        BBQ_chicken.add(PizzaImage);
        BBQ_chicken.setLayout(null);
        kabab.add(BBQ_chicken);*/

        JPanel panel_Kebab =new JPanel();
        panel_Kebab.setBounds(20, 125, 510,100 );
        panel_Kebab.setBackground(new Color(153, 0,0 ));
        panel_Kebab.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));


        JLabel KebabImage = new JLabel();
        KebabImage.setIcon(new ImageIcon("Kabab2.png"));
        KebabImage.setBounds(0, -25, 500, 150);



        Kebab2_CheckBox.setBounds(205,5,18,15);



        JLabel Kebab_name=new JLabel();
        Kebab_name.setText(" Kebab ");
        Kebab_name.setBounds(225, 5, 75, 15);
        Kebab_name.setBackground(Color.white);
        Kebab_name.setOpaque(true);

        Kebab2_CheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Kebab2_CheckBox.isSelected()){
                    CheckBox_Kebab2.setEnabled(true);
                    jlabel_price_Kebab2.setEnabled(true);
                }else{
                    CheckBox_Kebab2.setEnabled(false);
                    jlabel_price_Kebab2.setEnabled(false);
                    if(!Kebab2_CheckBox.isSelected()){
                        CheckBox_Kebab2.setSelected(false);
                        jlabel_price_Kebab2.setEnabled(false);
                        jTextArea_Kebab2.setText("");
                        jlabel_wassl_Kebab2.setEnabled(false);
                        jlabel_wassl_Kebab2.setText(0+" IQD");
                    }
                }
            }
        });

        CheckBox_Kebab2.setBounds(250,25,18,18);
        CheckBox_Kebab2.setEnabled(false);

        jlabel_price_Kebab2.setText(" one 3,500 IQD");
        jlabel_price_Kebab2.setBounds(275, 25, 115, 18);
        jlabel_price_Kebab2.setBackground(Color.white);
        jlabel_price_Kebab2.setOpaque(true);
        jlabel_price_Kebab2.setEnabled(false);

        jTextArea_Kebab2.setBounds(320, 50, 65, 20);
        jTextArea_Kebab2.setEnabled(false);


        jlabel_wassl_Kebab2.setBounds(400, 50, 80, 20);
        jlabel_wassl_Kebab2.setBackground(Color.WHITE);
        jlabel_wassl_Kebab2.setText("0 IQD");
        jlabel_wassl_Kebab2.setEnabled(false);
        jlabel_wassl_Kebab2.setOpaque(true);

        CheckBox_Kebab2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_Kebab2.isSelected()){
                    jlabel_wassl_Kebab2.setEnabled(true);
                    jTextArea_Kebab2.setEnabled(true);
                }else {
                    jlabel_wassl_Kebab2.setEnabled(false);
                    jlabel_wassl_Kebab2.setText(0+" IQD");
                    jTextArea_Kebab2.setText("");
                    jTextArea_Kebab2.setEnabled(false);
                }
            }
        });
        final double[] value = {0};
        final int[] num = new int[1];

        jTextArea_Kebab2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Kebab2.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    num[0] = 0;
                    jlabel_wassl_Kebab2.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        num[0] = Integer.parseInt(text);

                        num[0] = Integer.parseInt(String.valueOf(num[0]));

                        value[0] =(int) num[0] *3.5;
                        jlabel_wassl_Kebab2.setText(value[0] +" IQD");
                        temp+= value[0];
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Kebab2.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Kebab2.setText("0 IQD");
                }
            }
        });
        panel_Kebab.add(jTextArea_Kebab2);
        panel_Kebab.add(jlabel_wassl_Kebab2);
        panel_Kebab.add(CheckBox_Kebab2);
        panel_Kebab.add(jlabel_price_Kebab2);

        panel_Kebab.add(Kebab_name);
        panel_Kebab.add(Kebab2_CheckBox);
        panel_Kebab.add(KebabImage);
        panel_Kebab.setLayout(null);
        kabab.add(panel_Kebab);
    }

}
