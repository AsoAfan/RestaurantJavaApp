import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pizza {

    static double temp=0;
    public static final int[] value_pizza_Margherita_size_S = new int[1];
    public static final int[] value_pizza_Margherita_size_M = new int[1];
    public static final int[] value_pizza_Margherita_size_L = new int[1];
    public static JPanel Margherita =new JPanel();
    public static JLabel Margherita_Name=new JLabel();
    public static JLabel PizzaImage = new JLabel();
    public static JCheckBox pizza_Margherita_CheckBox=new JCheckBox();
    public static JCheckBox CheckBox_pizza_Margherita_size_S =new JCheckBox();
    public static JCheckBox CheckBox_pizza_Margherita_size_M =new JCheckBox();
    public static JCheckBox CheckBox_pizza_Margherita_size_L =new JCheckBox();
    public static JLabel jlabel_price_pizza_Margherita_size_s =new JLabel();
    public static JLabel jlabel_price_pizza_Margherita_size_M =new JLabel();
    public static JLabel jlabel_price_pizza_Margherita_size_L =new JLabel();
    public static JTextArea jTextArea_margarita_size_s =new JTextArea();
    public static JTextArea jTextArea_margarita_size_M =new JTextArea();
    public static JTextArea jTextArea_margarita_size_L =new JTextArea();

    public static JLabel jlabel_wassl_margarita_size_M =new JLabel();
    public static JLabel jlabel_wassl_margarita_size_s =new JLabel();
    public static JLabel jlabel_wassl_margarita_size_L =new JLabel();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int[] value_pizza_BBQ_chicken_size_S = new int[1];
    public static final int[] value_pizza_BBQ_chicken_size_M = new int[1];
    public static final int[] value_pizza_BBQ_chicken_size_L = new int[1];
    public static JPanel BBQ_chicken =new JPanel();
    public static JLabel PizzaImage_BBQ = new JLabel();
    public static JLabel BBQ_chicken_Name=new JLabel();
    public static JCheckBox pizza_BBQ_chicken_ChokeBox =new JCheckBox("BBQ chicken");
    public static JCheckBox CheckBox_pizza_BBQ_chicken_size_S =new JCheckBox();
    public static JCheckBox CheckBox_pizza_BBQ_chicken_size_M =new JCheckBox();
    public static JCheckBox CheckBox_pizza_BBQ_chicken_size_L =new JCheckBox();

    public static JLabel jlabel_price_pizza_BBQ_chicken_size_s =new JLabel();
    public static JLabel jlabel_price_pizza_BBQ_chicken_size_M =new JLabel();
    public static JLabel jlabel_price_pizza_BBQ_chicken_size_L =new JLabel();


    public static JTextArea jTextArea_BBQ_chicken_size_s =new JTextArea();
    public static JTextArea jTextArea_BBQ_chicken_size_M =new JTextArea();
    public static JTextArea jTextArea_BBQ_chicken_size_L =new JTextArea();

    public static JLabel jlabel_wassl_BBQ_chicken_size_s =new JLabel();
    public static JLabel jlabel_wassl_BBQ_chicken_size_M =new JLabel();
    public static JLabel jlabel_wassl_BBQ_chicken_size_L =new JLabel();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int[] value_pizza_Mexican_pizza_size_S = new int[1];
    public static final int[] value_pizza_Mexican_pizza_size_M = new int[1];
    public static final int[] value_pizza_Mexican_pizza_size_L = new int[1];
    public static JLabel Mexican_pizza_Name=new JLabel();
    public static JPanel Mexican=new JPanel();
    public static JLabel PizzaImage_Mexican = new JLabel();

    public static JCheckBox pizza_Mexican_ChokeBox =new JCheckBox("Mexican");
    public static JCheckBox CheckBox_pizza_Mexican_pizza_size_S =new JCheckBox();
    public static JCheckBox CheckBox_pizza_Mexican_pizza_size_M =new JCheckBox();
    public static JCheckBox CheckBox_pizza_Mexican_pizza_size_L =new JCheckBox();

    public static JLabel jlabel_price_pizza_Mexican_pizza_size_s =new JLabel();
    public static JLabel jlabel_price_pizza_Mexican_pizza_size_M =new JLabel();
    public static JLabel jlabel_price_pizza_Mexican_pizza_size_L =new JLabel();

    public static JTextArea jTextArea_Mexican_pizza_size_s =new JTextArea();
    public static JTextArea jTextArea_Mexican_pizza_size_M =new JTextArea();
    public static JTextArea jTextArea_Mexican_pizza_size_L =new JTextArea();

    public static JLabel jlabel_wassl_Mexican_pizza_size_s =new JLabel();
    public static JLabel jlabel_wassl_Mexican_pizza_size_M =new JLabel();
    public static JLabel jlabel_wassl_Mexican_pizza_size_L =new JLabel();
    public static JPanel pizza=new JPanel();
    Pizza(){

        pizza.setBackground(Color.WHITE);
        pizza.setBorder(new LineBorder(Color.BLACK));
        pizza.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        pizza.setBounds(120,120,550,350);

        Margherita();
        BBQ_chicken();
        Mexican_pizza();

        pizza.setLayout(null);

        GUI.fastFood.add(pizza);

    }
    void Margherita(){


        Margherita.setBounds(20, 20, 510,100 );
        Margherita.setBackground(new Color(153, 0,0 ));
        Margherita.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        PizzaImage.setIcon(new ImageIcon("Margherita2.png"));
        PizzaImage.setBounds(-115, -10, 500, 150);

        pizza_Margherita_CheckBox.setBounds(135,5,18,15);

        Margherita_Name.setText(" Margherita ");
        Margherita_Name.setBounds(153, 5, 75, 15);
        Margherita_Name.setBackground(Color.white);
        Margherita_Name.setOpaque(true);



        CheckBox_pizza_Margherita_size_S.setBounds(175,25,18,18);
        CheckBox_pizza_Margherita_size_S.setEnabled(false);

        jlabel_price_pizza_Margherita_size_s.setText(" small 3,500 IQD");
        jlabel_price_pizza_Margherita_size_s.setBounds(192, 25, 115, 18);
        jlabel_price_pizza_Margherita_size_s.setBackground(Color.white);
        jlabel_price_pizza_Margherita_size_s.setOpaque(true);
        jlabel_price_pizza_Margherita_size_s.setEnabled(false);

        jTextArea_margarita_size_s.setBounds(320, 25, 65, 20);
        jTextArea_margarita_size_s.setEnabled(false);


        jlabel_wassl_margarita_size_s.setBounds(400, 25, 80, 20);
        jlabel_wassl_margarita_size_s.setBackground(Color.WHITE);
        jlabel_wassl_margarita_size_s.setText("0 IQD");
        jlabel_wassl_margarita_size_s.setEnabled(false);
        jlabel_wassl_margarita_size_s.setOpaque(true);


        pizza_Margherita_CheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pizza_Margherita_CheckBox.isSelected()){
                    CheckBox_pizza_Margherita_size_S.setEnabled(true);
                    CheckBox_pizza_Margherita_size_M.setEnabled(true);
                    CheckBox_pizza_Margherita_size_L.setEnabled(true);

                    jlabel_price_pizza_Margherita_size_s.setEnabled(true);
                    jlabel_price_pizza_Margherita_size_M.setEnabled(true);
                    jlabel_price_pizza_Margherita_size_L.setEnabled(true);


                    if(CheckBox_pizza_Margherita_size_S.isSelected()){
                        jTextArea_margarita_size_s.setEnabled(true);
                        jTextArea_margarita_size_s.setText("");
                        jTextArea_margarita_size_s.setEditable(true);
                    }else if(!CheckBox_pizza_Margherita_size_S.isSelected()){
                        jTextArea_margarita_size_s.setEnabled(false);
                        jTextArea_margarita_size_s.setText("");
                        jTextArea_margarita_size_s.setEditable(false);
                    }
                    if(CheckBox_pizza_Margherita_size_M.isSelected()){
                        jTextArea_margarita_size_M.setEnabled(true);
                        jTextArea_margarita_size_M.setText("");
                        jTextArea_margarita_size_M.setEditable(true);
                    }else if(!CheckBox_pizza_Margherita_size_M.isSelected()){
                        jTextArea_margarita_size_M.setEnabled(false);
                        jTextArea_margarita_size_M.setText("");
                        jTextArea_margarita_size_M.setEditable(false);
                    }
                    if(CheckBox_pizza_Margherita_size_L.isSelected()){
                        jTextArea_margarita_size_L.setEnabled(true);
                        jTextArea_margarita_size_L.setText("");
                        jTextArea_margarita_size_L.setEditable(true);
                    }else if(!CheckBox_pizza_Margherita_size_L.isSelected()){
                        jTextArea_margarita_size_L.setEnabled(false);
                        jTextArea_margarita_size_L.setText("");
                        jTextArea_margarita_size_L.setEditable(false);
                    }
                }else{
                    CheckBox_pizza_Margherita_size_S.setEnabled(false);
                    CheckBox_pizza_Margherita_size_M.setEnabled(false);
                    CheckBox_pizza_Margherita_size_L.setEnabled(false);

                    jlabel_price_pizza_Margherita_size_L.setEnabled(false);
                    jlabel_price_pizza_Margherita_size_s.setEnabled(false);
                    jlabel_price_pizza_Margherita_size_M.setEnabled(false);

                    if(!pizza_Margherita_CheckBox.isSelected()){
                        CheckBox_pizza_Margherita_size_S.setSelected(false);
                        CheckBox_pizza_Margherita_size_M.setSelected(false);
                        CheckBox_pizza_Margherita_size_L.setSelected(false);

                        jlabel_price_pizza_Margherita_size_s.setEnabled(false);
                        jlabel_price_pizza_Margherita_size_M.setEnabled(false);
                        jlabel_price_pizza_Margherita_size_L.setEnabled(false);

                        jTextArea_margarita_size_s.setText("");
                        jTextArea_margarita_size_M.setText("");
                        jTextArea_margarita_size_L.setText("");

                        jTextArea_margarita_size_s.setEditable(false);
                        jTextArea_margarita_size_M.setEditable(false);
                        jTextArea_margarita_size_L.setEditable(false);

                        jTextArea_margarita_size_s.setEnabled(false);
                        jTextArea_margarita_size_M.setEnabled(false);
                        jTextArea_margarita_size_L.setEnabled(false);


                        jlabel_wassl_margarita_size_s.setEnabled(false);
                        jlabel_wassl_margarita_size_M.setEnabled(false);
                        jlabel_wassl_margarita_size_L.setEnabled(false);

                        jlabel_wassl_margarita_size_s.setText(0+" IQD");
                        jlabel_wassl_margarita_size_M.setText(0+" IQD");
                        jlabel_wassl_margarita_size_L.setText(0+" IQD");

                    }
                }
            }
        });

        CheckBox_pizza_Margherita_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Margherita_size_S.isSelected()){
                    jlabel_wassl_margarita_size_s.setEnabled(true);
                    jTextArea_margarita_size_s.setEnabled(true);
                    jTextArea_margarita_size_s.setEditable(true);
                }else {

                    jlabel_wassl_margarita_size_s.setEnabled(false);
                    jlabel_wassl_margarita_size_s.setText(0+" IQD");
                    jTextArea_margarita_size_s.setEditable(false);
                    jTextArea_margarita_size_s.setText("");
                    jTextArea_margarita_size_s.setEnabled(false);


                }
            }
        });
        final double[] value = {0};


        jTextArea_margarita_size_s.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_margarita_size_s.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)
                    value_pizza_Margherita_size_S[0] = 0;
                    jlabel_wassl_margarita_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_Margherita_size_S[0] = Integer.parseInt(text);

                        value_pizza_Margherita_size_S[0] = Integer.parseInt(String.valueOf(value_pizza_Margherita_size_S[0]));

                        value[0] =(int) value_pizza_Margherita_size_S[0] *3.5;
                        jlabel_wassl_margarita_size_s.setText(value[0] +" IQD");
                        temp+= value[0];
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_margarita_size_s.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_margarita_size_s.setText("0 IQD");
                }
            }
        });

        CheckBox_pizza_Margherita_size_M.setBounds(175,50,18,18);
        CheckBox_pizza_Margherita_size_M.setEnabled(false);


        jlabel_price_pizza_Margherita_size_M.setText(" medium 7,000 IQD");
        jlabel_price_pizza_Margherita_size_M.setBounds(192, 50, 115, 18);
        jlabel_price_pizza_Margherita_size_M.setBackground(Color.white);
        jlabel_price_pizza_Margherita_size_M.setOpaque(true);
        jlabel_price_pizza_Margherita_size_M.setEnabled(false);

        jTextArea_margarita_size_M.setBounds(320, 50, 65, 20);
        jTextArea_margarita_size_M.setEnabled(false);
        jTextArea_margarita_size_M.setEditable(false);
        jTextArea_margarita_size_M.setText("");

        jlabel_wassl_margarita_size_M.setBounds(400, 50, 80, 20);
        jlabel_wassl_margarita_size_M.setBackground(Color.WHITE);
        jlabel_wassl_margarita_size_M.setText("0 IQD");
        jlabel_wassl_margarita_size_M.setEnabled(false);
        jlabel_wassl_margarita_size_M.setOpaque(true);
        CheckBox_pizza_Margherita_size_M.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Margherita_size_M.isSelected()){
                    jlabel_wassl_margarita_size_M.setEnabled(true);
                    jTextArea_margarita_size_M.setEnabled(true);
                    jTextArea_margarita_size_M.setEditable(true);
                    jTextArea_margarita_size_M.setText("");
                }else {
                    jlabel_wassl_margarita_size_M.setEnabled(false);
                    jlabel_wassl_margarita_size_M.setText(0+" IQD");
                    jTextArea_margarita_size_M.setEditable(false);
                    jTextArea_margarita_size_M.setText("");
                    jTextArea_margarita_size_M.setEnabled(false);
                }
            }
        });
        jTextArea_margarita_size_M.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_margarita_size_M.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_margarita_size_M.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                         value_pizza_Margherita_size_M[0] = Integer.parseInt(text);

                         value_pizza_Margherita_size_M[0] = Integer.parseInt(String.valueOf(value_pizza_Margherita_size_M[0]));

                        double value=(int) value_pizza_Margherita_size_M[0] *7;
                        jlabel_wassl_margarita_size_M.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_margarita_size_M.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_margarita_size_M.setText("0 IQD");
                }



            }
        });


        CheckBox_pizza_Margherita_size_L.setBounds(175,75,18,18);
        CheckBox_pizza_Margherita_size_L.setEnabled(false);


        jlabel_price_pizza_Margherita_size_L.setText(" large 9,000 IQD");
        jlabel_price_pizza_Margherita_size_L.setBounds(192, 75, 115, 18);
        jlabel_price_pizza_Margherita_size_L.setBackground(Color.white);
        jlabel_price_pizza_Margherita_size_L.setOpaque(true);
        jlabel_price_pizza_Margherita_size_L.setEnabled(false);

        jTextArea_margarita_size_L.setBounds(320, 75, 65, 20);
        jTextArea_margarita_size_L.setEnabled(false);


        jlabel_wassl_margarita_size_L.setBounds(400, 75, 80, 20);
        jlabel_wassl_margarita_size_L.setBackground(Color.WHITE);
        jlabel_wassl_margarita_size_L.setText("0 IQD");
        jlabel_wassl_margarita_size_L.setEnabled(false);
        jlabel_wassl_margarita_size_L.setOpaque(true);



        CheckBox_pizza_Margherita_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Margherita_size_L.isSelected()){
                    jlabel_wassl_margarita_size_L.setEnabled(true);
                    jTextArea_margarita_size_L.setEnabled(true);
                    jTextArea_margarita_size_L.setEditable(true);
                }else {
                    jlabel_wassl_margarita_size_L.setEnabled(false);
                    jlabel_wassl_margarita_size_L.setText(0+" IQD");
                    jTextArea_margarita_size_L.setEditable(false);
                    jTextArea_margarita_size_L.setText("");
                    jTextArea_margarita_size_L.setEnabled(false);

                }
            }
        });


        jTextArea_margarita_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_margarita_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_margarita_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_Margherita_size_L[0] = Integer.parseInt(text);

                        value_pizza_Margherita_size_L[0] = Integer.parseInt(String.valueOf(value_pizza_Margherita_size_L[0]));

                        double value=(int) value_pizza_Margherita_size_L[0] *9;
                        jlabel_wassl_margarita_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_margarita_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_margarita_size_L.setText("0 IQD");
                }



            }
        });



        Margherita.add(jTextArea_margarita_size_s);
        Margherita.add(jlabel_wassl_margarita_size_s);
        Margherita.add(CheckBox_pizza_Margherita_size_S);
        Margherita.add(jlabel_price_pizza_Margherita_size_s);

        Margherita.add(jTextArea_margarita_size_M);
        Margherita.add(jlabel_wassl_margarita_size_M);
        Margherita.add(CheckBox_pizza_Margherita_size_M);
        Margherita.add(jlabel_price_pizza_Margherita_size_M);

        Margherita.add(jTextArea_margarita_size_L);
        Margherita.add(jlabel_wassl_margarita_size_L);
        Margherita.add(CheckBox_pizza_Margherita_size_L);
        Margherita.add(jlabel_price_pizza_Margherita_size_L);



        Margherita.add(Margherita_Name);
        Margherita.add(pizza_Margherita_CheckBox);
        Margherita.add(PizzaImage);
        Margherita.setLayout(null);
        pizza.add(Margherita);
    }
    void BBQ_chicken(){

        BBQ_chicken.setBounds(20, 125, 510,100 );
        BBQ_chicken.setBackground(new Color(153, 0,0 ));
        BBQ_chicken.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        PizzaImage_BBQ.setIcon(new ImageIcon("BBQ_chicken2.png"));
        PizzaImage_BBQ.setBounds(-75, -10, 450, 120);

        pizza_BBQ_chicken_ChokeBox.setBounds(135,5,18,15);

        BBQ_chicken_Name.setText(" BBQ chicken ");
        BBQ_chicken_Name.setBounds(153, 5, 80, 15);
        BBQ_chicken_Name.setBackground(Color.white);
        BBQ_chicken_Name.setOpaque(true);


        pizza_BBQ_chicken_ChokeBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                if(pizza_BBQ_chicken_ChokeBox.isSelected()){
                    CheckBox_pizza_BBQ_chicken_size_S.setEnabled(true);
                    CheckBox_pizza_BBQ_chicken_size_M.setEnabled(true);
                    CheckBox_pizza_BBQ_chicken_size_L.setEnabled(true);


                    jlabel_price_pizza_BBQ_chicken_size_s.setEnabled(true);
                    jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(true);
                    jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(true);

                    if(CheckBox_pizza_BBQ_chicken_size_S.isSelected()){
                        jTextArea_BBQ_chicken_size_s.setEnabled(true);
                        jTextArea_BBQ_chicken_size_s.setText("");
                        jTextArea_BBQ_chicken_size_s.setEditable(true);
                    }else if(!CheckBox_pizza_BBQ_chicken_size_S.isSelected()){
                        jTextArea_BBQ_chicken_size_s.setEnabled(false);
                        jTextArea_BBQ_chicken_size_s.setText("");
                        jTextArea_BBQ_chicken_size_s.setEditable(false);
                    }
                    if(CheckBox_pizza_BBQ_chicken_size_L.isSelected()){
                        jTextArea_BBQ_chicken_size_M.setEnabled(true);
                        jTextArea_BBQ_chicken_size_M.setText("");
                        jTextArea_BBQ_chicken_size_M.setEditable(true);
                    }else if(!CheckBox_pizza_BBQ_chicken_size_L.isSelected()){
                        jTextArea_BBQ_chicken_size_M.setEnabled(false);
                        jTextArea_BBQ_chicken_size_M.setText("");
                        jTextArea_BBQ_chicken_size_M.setEditable(false);
                    }
                    if(CheckBox_pizza_BBQ_chicken_size_L.isSelected()){
                        jTextArea_BBQ_chicken_size_L.setEnabled(true);
                        jTextArea_BBQ_chicken_size_L.setText("");
                        jTextArea_BBQ_chicken_size_L.setEditable(true);
                    }else if(!CheckBox_pizza_BBQ_chicken_size_L.isSelected()){
                        jTextArea_BBQ_chicken_size_L.setEnabled(false);
                        jTextArea_BBQ_chicken_size_L.setText("");
                        jTextArea_BBQ_chicken_size_L.setEditable(false);
                    }
                }else{
                    CheckBox_pizza_BBQ_chicken_size_S.setEnabled(false);
                    CheckBox_pizza_BBQ_chicken_size_M.setEnabled(false);
                    CheckBox_pizza_BBQ_chicken_size_L.setEnabled(false);

                    jlabel_price_pizza_BBQ_chicken_size_s.setEnabled(false);
                    jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);
                    jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

                    if(!pizza_BBQ_chicken_ChokeBox.isSelected()){
                        CheckBox_pizza_BBQ_chicken_size_S.setSelected(false);
                        CheckBox_pizza_BBQ_chicken_size_M.setSelected(false);
                        CheckBox_pizza_BBQ_chicken_size_L.setSelected(false);

                        jlabel_price_pizza_BBQ_chicken_size_s.setEnabled(false);
                        jlabel_price_pizza_BBQ_chicken_size_M.setEnabled(false);
                        jlabel_price_pizza_BBQ_chicken_size_L.setEnabled(false);

                        jTextArea_BBQ_chicken_size_s.setText("");
                        jTextArea_BBQ_chicken_size_M.setText("");
                        jTextArea_BBQ_chicken_size_L.setText("");

                        jTextArea_BBQ_chicken_size_s.setEditable(false);
                        jTextArea_BBQ_chicken_size_M.setEditable(false);
                        jTextArea_BBQ_chicken_size_L.setEditable(false);

                        jTextArea_BBQ_chicken_size_s.setEnabled(false);
                        jTextArea_BBQ_chicken_size_M.setEnabled(false);
                        jTextArea_BBQ_chicken_size_L.setEnabled(false);

                        jlabel_wassl_BBQ_chicken_size_s.setEnabled(false);
                        jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);
                        jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);

                        jlabel_wassl_BBQ_chicken_size_s.setText(0+" IQD");
                        jlabel_wassl_BBQ_chicken_size_L.setText(0+" IQD");
                        jlabel_wassl_BBQ_chicken_size_M.setText(0+" IQD");
                    }

                }
            }
        });

        CheckBox_pizza_BBQ_chicken_size_S.setBounds(175,25,18,18);
        CheckBox_pizza_BBQ_chicken_size_S.setEnabled(false);

        jlabel_price_pizza_BBQ_chicken_size_s.setText(" small 3,500 IQD");
        jlabel_price_pizza_BBQ_chicken_size_s.setBounds(192, 25, 115, 18);
        jlabel_price_pizza_BBQ_chicken_size_s.setBackground(Color.white);
        jlabel_price_pizza_BBQ_chicken_size_s.setOpaque(true);
        jlabel_price_pizza_BBQ_chicken_size_s.setEnabled(false);

        jTextArea_BBQ_chicken_size_s.setBounds(320, 25, 65, 20);
        jTextArea_BBQ_chicken_size_s.setEnabled(false);


        jlabel_wassl_BBQ_chicken_size_s.setBounds(400, 25, 80, 20);
        jlabel_wassl_BBQ_chicken_size_s.setBackground(Color.WHITE);
        jlabel_wassl_BBQ_chicken_size_s.setText("0 IQD");
        jlabel_wassl_BBQ_chicken_size_s.setEnabled(false);
        jlabel_wassl_BBQ_chicken_size_s.setOpaque(true);


        CheckBox_pizza_BBQ_chicken_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_BBQ_chicken_size_S.isSelected()){
                    jlabel_wassl_BBQ_chicken_size_s.setEnabled(true);
                    jTextArea_BBQ_chicken_size_s.setEnabled(true);
                    jTextArea_BBQ_chicken_size_s.setText("");
                    jTextArea_BBQ_chicken_size_s.setEditable(true);
                }else {
                    jlabel_wassl_BBQ_chicken_size_s.setEnabled(false);
                    jlabel_wassl_BBQ_chicken_size_s.setText(0+" IQD");
                    jTextArea_BBQ_chicken_size_s.setEnabled(false);
                    jTextArea_BBQ_chicken_size_s.setText("");
                    jTextArea_BBQ_chicken_size_s.setEditable(false);
                }
            }
        });
        jTextArea_BBQ_chicken_size_s.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_BBQ_chicken_size_s.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_BBQ_chicken_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_BBQ_chicken_size_S[0] = Integer.parseInt(text);

                        value_pizza_BBQ_chicken_size_S[0] = Integer.parseInt(String.valueOf(value_pizza_BBQ_chicken_size_S[0]));

                        double value=(int) value_pizza_BBQ_chicken_size_S[0] *3.5;
                        jlabel_wassl_BBQ_chicken_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_BBQ_chicken_size_s.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_BBQ_chicken_size_s.setText("0 IQD");
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
                    jTextArea_BBQ_chicken_size_M.setText("");
                    jTextArea_BBQ_chicken_size_M.setEditable(true);
                }else {
                    jlabel_wassl_BBQ_chicken_size_M.setEnabled(false);
                    jlabel_wassl_BBQ_chicken_size_M.setText(0+" IQD");
                    jTextArea_BBQ_chicken_size_M.setEnabled(false);
                    jTextArea_BBQ_chicken_size_M.setText("");
                    jTextArea_BBQ_chicken_size_M.setEditable(false);
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

                    jlabel_wassl_BBQ_chicken_size_M.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_BBQ_chicken_size_M[0] = Integer.parseInt(text);

                        value_pizza_BBQ_chicken_size_M[0] = Integer.parseInt(String.valueOf(value_pizza_BBQ_chicken_size_M[0]));

                        double value=(int) value_pizza_BBQ_chicken_size_M[0] *7;
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


        jlabel_price_pizza_BBQ_chicken_size_L.setText(" large 10,000 IQD");
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
                    jTextArea_BBQ_chicken_size_L.setText("");
                    jTextArea_BBQ_chicken_size_L.setEditable(true);
                }else {
                    jlabel_wassl_BBQ_chicken_size_L.setEnabled(false);
                    jlabel_wassl_BBQ_chicken_size_L.setText(0+" IQD");
                    jTextArea_BBQ_chicken_size_L.setEnabled(false);
                    jTextArea_BBQ_chicken_size_L.setText("");
                    jTextArea_BBQ_chicken_size_L.setEditable(false);
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

                    jlabel_wassl_BBQ_chicken_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_BBQ_chicken_size_L[0] = Integer.parseInt(text);

                        value_pizza_BBQ_chicken_size_L[0] = Integer.parseInt(String.valueOf(value_pizza_BBQ_chicken_size_L[0]));

                        double value=(int) value_pizza_BBQ_chicken_size_L[0] *10;
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

        BBQ_chicken.add(jTextArea_BBQ_chicken_size_s);
        BBQ_chicken.add(jlabel_wassl_BBQ_chicken_size_s);
        BBQ_chicken.add(CheckBox_pizza_BBQ_chicken_size_S);
        BBQ_chicken.add(jlabel_price_pizza_BBQ_chicken_size_s);

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
        BBQ_chicken.add(pizza_BBQ_chicken_ChokeBox);
        BBQ_chicken.add(PizzaImage_BBQ);
        BBQ_chicken.setLayout(null);
        pizza.add(BBQ_chicken);
    }
    void Mexican_pizza(){




        Mexican.setBounds(20, 230, 510,100 );
        Mexican.setBackground(new Color(153, 0,0 ));
        Mexican.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));



        PizzaImage_Mexican.setIcon(new ImageIcon("Mexican.png"));
        PizzaImage_Mexican.setBounds(-90, -10, 450, 120);


        pizza_Mexican_ChokeBox.setBounds(135,5,18,15);


        Mexican_pizza_Name.setText(" Mexican Pizza ");
        Mexican_pizza_Name.setBounds(153, 5, 90, 15);
        Mexican_pizza_Name.setBackground(Color.white);
        Mexican_pizza_Name.setOpaque(true);


        pizza_Mexican_ChokeBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pizza_Mexican_ChokeBox.isSelected()){
                    CheckBox_pizza_Mexican_pizza_size_S.setEnabled(true);
                    CheckBox_pizza_Mexican_pizza_size_M.setEnabled(true);
                    CheckBox_pizza_Mexican_pizza_size_L.setEnabled(true);

                    jlabel_price_pizza_Mexican_pizza_size_s.setEnabled(true);
                    jlabel_price_pizza_Mexican_pizza_size_M.setEnabled(true);
                    jlabel_price_pizza_Mexican_pizza_size_L.setEnabled(true);

                    if(CheckBox_pizza_Mexican_pizza_size_S.isSelected()){
                        jTextArea_Mexican_pizza_size_s.setEnabled(true);
                        jTextArea_Mexican_pizza_size_s.setText("");
                        jTextArea_Mexican_pizza_size_s.setEditable(true);
                    }else if(!CheckBox_pizza_Mexican_pizza_size_S.isSelected()){
                        jTextArea_Mexican_pizza_size_s.setEnabled(false);
                        jTextArea_Mexican_pizza_size_s.setText("");
                        jTextArea_Mexican_pizza_size_s.setEditable(false);
                    }
                    if(CheckBox_pizza_Mexican_pizza_size_M.isSelected()){
                        jTextArea_Mexican_pizza_size_M.setEnabled(true);
                        jTextArea_Mexican_pizza_size_M.setText("");
                        jTextArea_Mexican_pizza_size_M.setEditable(true);
                    }else if(!CheckBox_pizza_Mexican_pizza_size_M.isSelected()){
                        jTextArea_Mexican_pizza_size_M.setEnabled(false);
                        jTextArea_Mexican_pizza_size_M.setText("");
                        jTextArea_Mexican_pizza_size_M.setEditable(false);
                    }
                    if(CheckBox_pizza_Mexican_pizza_size_L.isSelected()){
                        jTextArea_Mexican_pizza_size_L.setEnabled(true);
                        jTextArea_Mexican_pizza_size_L.setText("");
                        jTextArea_Mexican_pizza_size_L.setEditable(true);
                    }else if(!CheckBox_pizza_Mexican_pizza_size_L.isSelected()){
                        jTextArea_Mexican_pizza_size_L.setEnabled(false);
                        jTextArea_Mexican_pizza_size_L.setText("");
                        jTextArea_Mexican_pizza_size_L.setEditable(false);
                    }

                }else{
                    CheckBox_pizza_Mexican_pizza_size_S.setEnabled(false);
                    CheckBox_pizza_Mexican_pizza_size_M.setEnabled(false);
                    CheckBox_pizza_Mexican_pizza_size_L.setEnabled(false);

                    jlabel_price_pizza_Mexican_pizza_size_s.setEnabled(false);
                    jlabel_price_pizza_Mexican_pizza_size_M.setEnabled(false);
                    jlabel_price_pizza_Mexican_pizza_size_L.setEnabled(false);

                    if(!pizza_Mexican_ChokeBox.isSelected()){
                        CheckBox_pizza_Mexican_pizza_size_S.setSelected(false);
                        CheckBox_pizza_Mexican_pizza_size_M.setSelected(false);
                        CheckBox_pizza_Mexican_pizza_size_L.setSelected(false);

                        jlabel_price_pizza_Mexican_pizza_size_s.setEnabled(false);
                        jlabel_price_pizza_Mexican_pizza_size_M.setEnabled(false);
                        jlabel_price_pizza_Mexican_pizza_size_L.setEnabled(false);

                        jTextArea_Mexican_pizza_size_s.setText("");
                        jTextArea_Mexican_pizza_size_M.setText("");
                        jTextArea_Mexican_pizza_size_L.setText("");

                        jTextArea_Mexican_pizza_size_s.setEditable(false);
                        jTextArea_Mexican_pizza_size_M.setEditable(false);
                        jTextArea_Mexican_pizza_size_L.setEditable(false);

                        jTextArea_Mexican_pizza_size_s.setEnabled(false);
                        jTextArea_Mexican_pizza_size_M.setEnabled(false);
                        jTextArea_Mexican_pizza_size_L.setEnabled(false);


                        jlabel_wassl_Mexican_pizza_size_s.setEnabled(false);
                        jlabel_wassl_Mexican_pizza_size_M.setEnabled(false);
                        jlabel_wassl_Mexican_pizza_size_L.setEnabled(false);

                        jlabel_wassl_Mexican_pizza_size_s.setText(0+" IQD");
                        jlabel_wassl_Mexican_pizza_size_M.setText(0+" IQD");
                        jlabel_wassl_Mexican_pizza_size_L.setText(0+" IQD");
                    }
                }
            }
        });



        CheckBox_pizza_Mexican_pizza_size_S.setBounds(175,25,18,18);
        CheckBox_pizza_Mexican_pizza_size_S.setEnabled(false);

        jlabel_price_pizza_Mexican_pizza_size_s.setText(" small 5,000 IQD");
        jlabel_price_pizza_Mexican_pizza_size_s.setBounds(192, 25, 115, 18);
        jlabel_price_pizza_Mexican_pizza_size_s.setBackground(Color.white);
        jlabel_price_pizza_Mexican_pizza_size_s.setOpaque(true);
        jlabel_price_pizza_Mexican_pizza_size_s.setEnabled(false);

        jTextArea_Mexican_pizza_size_s.setBounds(320, 25, 65, 20);
        jTextArea_Mexican_pizza_size_s.setEnabled(false);

        jlabel_wassl_Mexican_pizza_size_s.setBounds(400, 25, 80, 20);
        jlabel_wassl_Mexican_pizza_size_s.setBackground(Color.WHITE);
        jlabel_wassl_Mexican_pizza_size_s.setText("0 IQD");
        jlabel_wassl_Mexican_pizza_size_s.setEnabled(false);
        jlabel_wassl_Mexican_pizza_size_s.setOpaque(true);


        CheckBox_pizza_Mexican_pizza_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Mexican_pizza_size_S.isSelected()){
                    jlabel_wassl_Mexican_pizza_size_s.setEnabled(true);
                    jTextArea_Mexican_pizza_size_s.setEnabled(true);
                    jTextArea_Mexican_pizza_size_s.setEditable(true);
                    jTextArea_Mexican_pizza_size_s.setText("");
                }else {
                    jlabel_wassl_Mexican_pizza_size_s.setEnabled(false);
                    jlabel_wassl_Mexican_pizza_size_s.setText(0+" IQD");
                    jTextArea_Mexican_pizza_size_s.setEditable(false);
                    jTextArea_Mexican_pizza_size_s.setEnabled(false);
                    jTextArea_Mexican_pizza_size_s.setText("");
                }
            }
        });


        jTextArea_Mexican_pizza_size_s.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Mexican_pizza_size_s.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Mexican_pizza_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_Mexican_pizza_size_S[0] = Integer.parseInt(text);

                        value_pizza_Mexican_pizza_size_S[0] = Integer.parseInt(String.valueOf(value_pizza_Mexican_pizza_size_S[0]));

                        double value=(int) value_pizza_Mexican_pizza_size_S[0] *5;
                        jlabel_wassl_Mexican_pizza_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Mexican_pizza_size_s.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Mexican_pizza_size_s.setText("0 IQD");
                }
            }
        });






        CheckBox_pizza_Mexican_pizza_size_M.setBounds(175,50,18,18);
        CheckBox_pizza_Mexican_pizza_size_M.setEnabled(false);


        jlabel_price_pizza_Mexican_pizza_size_M.setText(" medium 9,000 IQD");
        jlabel_price_pizza_Mexican_pizza_size_M.setBounds(192, 50, 115, 18);
        jlabel_price_pizza_Mexican_pizza_size_M.setBackground(Color.white);
        jlabel_price_pizza_Mexican_pizza_size_M.setOpaque(true);
        jlabel_price_pizza_Mexican_pizza_size_M.setEnabled(false);

        jTextArea_Mexican_pizza_size_M.setBounds(320, 50, 65, 20);
        jTextArea_Mexican_pizza_size_M.setEnabled(false);


        jlabel_wassl_Mexican_pizza_size_M.setBounds(400, 50, 80, 20);
        jlabel_wassl_Mexican_pizza_size_M.setBackground(Color.WHITE);
        jlabel_wassl_Mexican_pizza_size_M.setText("0 IQD");
        jlabel_wassl_Mexican_pizza_size_M.setEnabled(false);
        jlabel_wassl_Mexican_pizza_size_M.setOpaque(true);
        CheckBox_pizza_Mexican_pizza_size_M.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Mexican_pizza_size_M.isSelected()){
                    jlabel_wassl_Mexican_pizza_size_M.setEnabled(true);
                    jTextArea_Mexican_pizza_size_M.setEnabled(true);
                    jTextArea_Mexican_pizza_size_M.setEditable(true);
                    jTextArea_Mexican_pizza_size_M.setText("");
                }else {
                    jlabel_wassl_Mexican_pizza_size_M.setEnabled(false);
                    jlabel_wassl_Mexican_pizza_size_M.setText(0+" IQD");
                    jTextArea_Mexican_pizza_size_M.setEditable(false);
                    jTextArea_Mexican_pizza_size_M.setEnabled(false);
                    jTextArea_Mexican_pizza_size_M.setText("");
                }
            }
        });


        jTextArea_Mexican_pizza_size_M.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Mexican_pizza_size_M.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Mexican_pizza_size_M.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_Mexican_pizza_size_M[0] = Integer.parseInt(text);

                        value_pizza_Mexican_pizza_size_M[0] = Integer.parseInt(String.valueOf(value_pizza_Mexican_pizza_size_M[0]));

                        double value=(int) value_pizza_Mexican_pizza_size_M[0] *9;
                        jlabel_wassl_Mexican_pizza_size_M.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Mexican_pizza_size_M.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Mexican_pizza_size_M.setText("0 IQD");
                }
            }
        });


        CheckBox_pizza_Mexican_pizza_size_L.setBounds(175,75,18,18);
        CheckBox_pizza_Mexican_pizza_size_L.setEnabled(false);


        jlabel_price_pizza_Mexican_pizza_size_L.setText(" large 13,000 IQD");
        jlabel_price_pizza_Mexican_pizza_size_L.setBounds(192, 75, 115, 18);
        jlabel_price_pizza_Mexican_pizza_size_L.setBackground(Color.white);
        jlabel_price_pizza_Mexican_pizza_size_L.setOpaque(true);
        jlabel_price_pizza_Mexican_pizza_size_L.setEnabled(false);

        jTextArea_Mexican_pizza_size_L.setBounds(320, 75, 65, 20);
        jTextArea_Mexican_pizza_size_L.setEnabled(false);


        jlabel_wassl_Mexican_pizza_size_L.setBounds(400, 75, 80, 20);
        jlabel_wassl_Mexican_pizza_size_L.setBackground(Color.WHITE);
        jlabel_wassl_Mexican_pizza_size_L.setText("0 IQD");
        jlabel_wassl_Mexican_pizza_size_L.setEnabled(false);
        jlabel_wassl_Mexican_pizza_size_L.setOpaque(true);

        CheckBox_pizza_Mexican_pizza_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckBox_pizza_Mexican_pizza_size_L.isSelected()){
                    jlabel_wassl_Mexican_pizza_size_L.setEnabled(true);
                    jTextArea_Mexican_pizza_size_L.setEnabled(true);
                    jTextArea_Mexican_pizza_size_L.setEditable(true);
                    jTextArea_Mexican_pizza_size_L.setText("");
                }else {
                    jlabel_wassl_Mexican_pizza_size_L.setEnabled(false);
                    jlabel_wassl_Mexican_pizza_size_L.setText(0+" IQD");
                    jTextArea_Mexican_pizza_size_L.setEditable(false);
                    jTextArea_Mexican_pizza_size_L.setEnabled(false);
                    jTextArea_Mexican_pizza_size_L.setText("");
                }
            }
        });


        jTextArea_Mexican_pizza_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Mexican_pizza_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Mexican_pizza_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_pizza_Mexican_pizza_size_L[0] = Integer.parseInt(text);

                        value_pizza_Mexican_pizza_size_L[0] = Integer.parseInt(String.valueOf(value_pizza_Mexican_pizza_size_L[0]));

                        double value=(int) value_pizza_Mexican_pizza_size_L[0] *13;
                        jlabel_wassl_Mexican_pizza_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Mexican_pizza_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Mexican_pizza_size_L.setText("0 IQD");
                }
            }
        });

        Mexican.add(jTextArea_Mexican_pizza_size_s);
        Mexican.add(jlabel_wassl_Mexican_pizza_size_s);
        Mexican.add(CheckBox_pizza_Mexican_pizza_size_S);
        Mexican.add(jlabel_price_pizza_Mexican_pizza_size_s);

        Mexican.add(jTextArea_Mexican_pizza_size_M);
        Mexican.add(jlabel_wassl_Mexican_pizza_size_M);
        Mexican.add(CheckBox_pizza_Mexican_pizza_size_M);
        Mexican.add(jlabel_price_pizza_Mexican_pizza_size_M);

        Mexican.add(jTextArea_Mexican_pizza_size_L);
        Mexican.add(jlabel_wassl_Mexican_pizza_size_L);
        Mexican.add(CheckBox_pizza_Mexican_pizza_size_L);
        Mexican.add(jlabel_price_pizza_Mexican_pizza_size_L);



        ////////////////////////////////////

        Mexican.add(Mexican_pizza_Name);
        Mexican.add(pizza_Mexican_ChokeBox);
        Mexican.add(PizzaImage_Mexican);
        Mexican.setLayout(null);
        pizza.add(Mexican);

    }
}
