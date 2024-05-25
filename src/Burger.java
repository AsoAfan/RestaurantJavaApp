import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Burger {
    double temp=0;
    public static JPanel Burger=new JPanel();

    public static final int[] value_Cheese_Chicken_Wrap_size_S = new int[1];
    public static final int[] value_Cheese_Chicken_Wrap_size_L = new int[1];
    public static JPanel Cheese_Chicken_Wrap =new JPanel();
    public static JLabel cheese_Chicken_Wrap_Name=new JLabel();
    public static JLabel cheese_Chicken_WrapImage = new JLabel();

    public static JCheckBox CheckBox_cheese_Chicken_Wrap=new JCheckBox();

    public static JCheckBox checkBox_Cheese_Chicken_Wrap_size_S =new JCheckBox();
    public static JCheckBox checkBox_Cheese_Chicken_Wrap_size_L =new JCheckBox();

    public static JLabel jlabel_price_Cheese_Chicken_Wrap_size_s =new JLabel();
    public static JLabel jlabel_price_Cheese_Chicken_Wrap_size_L =new JLabel();

    public static JTextArea jTextArea_Cheese_Chicken_Wrap_size_S=new JTextArea();
    public static JTextArea jTextArea_Cheese_Chicken_Wrap_size_L=new JTextArea();

    public static JLabel jlabel_wassl_Cheese_Chicken_Wrap_size_s=new JLabel();
    public static JLabel jlabel_wassl_Cheese_Chicken_Wrap_size_L=new JLabel();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final int[] value_Cheese_Burger_size_S = new int[1];
    public static final int[] value_Cheese_Burger_size_L = new int[1];
    public static JLabel Cheese_BurgerImage = new JLabel();
    public static JLabel Cheese_Burger_Name=new JLabel();
    public static JPanel Cheese_Burger =new JPanel();
    public static JCheckBox Cheese_Burger_CheckBox=new JCheckBox("BBQ_chicken");

    public static JCheckBox checkBox_Cheese_Burger_size_S =new JCheckBox();
    public static JCheckBox checkBox_Cheese_Burger_size_L =new JCheckBox();

    public static JLabel jlabel_price_Cheese_Burger_size_s =new JLabel();
    public static JLabel jlabel_price_Cheese_Burger_size_L =new JLabel();

    public static JTextArea jTextArea_Cheese_Burger_size_S=new JTextArea();
    public static JTextArea jTextArea_Cheese_Burger_size_L=new JTextArea();

    public static JLabel jlabel_wassl_Cheese_Burger_size_s=new JLabel();
    public static JLabel jlabel_wassl_Cheese_Burger_size_L=new JLabel();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int[] value_Farm_Burger_size_S = new int[1];
    public static final int[] value_Farm_Burger_size_L = new int[1];

    public static JPanel Farm_Burger=new JPanel();
    public static JLabel Farm_BurgerImage = new JLabel();
    public static JLabel Farm_Burger_Name=new JLabel();
    public static JCheckBox Farm_Burger_CheckBox=new JCheckBox();

    public static JCheckBox checkBox_Farm_Burger_size_S =new JCheckBox();
    public static JCheckBox checkBox_Farm_Burger_size_L =new JCheckBox();

    public static JLabel jlabel_price_Farm_Burger_size_s =new JLabel();
    public static JLabel jlabel_price_Farm_Burger_size_L =new JLabel();

    public static JTextArea jTextArea_Farm_Burger_size_S=new JTextArea();
    public static JTextArea jTextArea_Farm_Burger_size_L=new JTextArea();

    public static JLabel jlabel_wassl_Farm_Burger_size_s=new JLabel();
    public static JLabel jlabel_wassl_Farm_Burger_size_L=new JLabel();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int[] value_Double_Cheese_Burger_size_S = new int[1];
    public static final int[] value_Double_Cheese_Burger_size_L = new int[1];
    public static JLabel Double_Cheese_Burger_Name=new JLabel();
    public static JLabel Double_Cheese_BurgerImage = new JLabel();
    public static JPanel Double_Cheese_Burger=new JPanel();
    public static JCheckBox Double_Cheese_Burger_CheckBox=new JCheckBox();

    public static JCheckBox checkBox_Double_Cheese_Burger_size_S =new JCheckBox();
    public static JCheckBox checkBox_Double_Cheese_Burger_size_L =new JCheckBox();

    public static JLabel jlabel_price_Double_Cheese_Burger_size_s =new JLabel();
    public static JLabel jlabel_price_Double_Cheese_Burger_size_L =new JLabel();

    public static JTextArea jTextArea_Double_Cheese_Burger_size_S=new JTextArea();
    public static JTextArea jTextArea_Double_Cheese_Burger_size_L=new JTextArea();

    public static JLabel jlabel_wassl_Double_Cheese_Burger_size_s=new JLabel();
    public static JLabel jlabel_wassl_Double_Cheese_Burger_size_L=new JLabel();
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Burger(){

        Burger.setBackground(Color.white);
        Burger.setBorder(new LineBorder(Color.BLACK));
        Burger.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        Burger.setBounds(120,550,550,450);

        Cheese_Chicken_Wrap();
        Cheese_Burger();
        Farm_Burger();
        Double_Cheese_Burger();

        Burger.setLayout(null);
        GUI.fastFood.add(Burger);

    }

    void Cheese_Chicken_Wrap(){
        Cheese_Chicken_Wrap.setBounds(20, 20, 510,100 );
        Cheese_Chicken_Wrap.setBackground(new Color(153, 0,0 ));
        Cheese_Chicken_Wrap.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));


        cheese_Chicken_WrapImage.setIcon(new ImageIcon("Cheese_Chicken_Wrap.png"));
        cheese_Chicken_WrapImage.setBounds(-80, -10, 500, 150);


        CheckBox_cheese_Chicken_Wrap.setBounds(135,10,20,20);


        cheese_Chicken_Wrap_Name.setText(" Cheese Chicken Wrap ");
        cheese_Chicken_Wrap_Name.setBounds(160, 10, 150, 20);
        cheese_Chicken_Wrap_Name.setBackground(Color.white);
        cheese_Chicken_Wrap_Name.setOpaque(true);



        CheckBox_cheese_Chicken_Wrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CheckBox_cheese_Chicken_Wrap.isSelected()) {
                    checkBox_Cheese_Chicken_Wrap_size_S.setEnabled(true);
                    checkBox_Cheese_Chicken_Wrap_size_L.setEnabled(true);

                    jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(true);
                    jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(true);

                    if(checkBox_Cheese_Chicken_Wrap_size_S.isSelected()){
                        jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(true);
                        jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                        jTextArea_Cheese_Chicken_Wrap_size_S.setEditable(true);
                    }else if(!checkBox_Cheese_Chicken_Wrap_size_S.isSelected()){
                        jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                        jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                        jTextArea_Cheese_Chicken_Wrap_size_S.setEditable(false);
                    }
                    if(checkBox_Cheese_Chicken_Wrap_size_L.isSelected()){
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(true);
                        jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEditable(true);
                    }else if(!checkBox_Cheese_Chicken_Wrap_size_L.isSelected()){
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                        jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEditable(false);
                    }
                }else {
                    checkBox_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                    checkBox_Cheese_Chicken_Wrap_size_L.setEnabled(false);

                    jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                    jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(false);

                    if(!CheckBox_cheese_Chicken_Wrap.isSelected()){
                        checkBox_Cheese_Chicken_Wrap_size_S.setSelected(false);
                        checkBox_Cheese_Chicken_Wrap_size_L.setSelected(false);

                        jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                        jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(false);

                        jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                        jTextArea_Cheese_Chicken_Wrap_size_L.setText("");

                        jTextArea_Cheese_Chicken_Wrap_size_S.setEditable(false);
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEditable(false);

                        jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                        jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(false);


                        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setEnabled(false);

                        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText(0+" IQD");
                        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText(0+" IQD");
                    }

                }

            }
        });

        checkBox_Cheese_Chicken_Wrap_size_S.setBounds(175,40,18,20);
        checkBox_Cheese_Chicken_Wrap_size_S.setEnabled(false);

        jlabel_price_Cheese_Chicken_Wrap_size_s.setText(" small 3,000 IQD");
        jlabel_price_Cheese_Chicken_Wrap_size_s.setBounds(192, 40, 95, 20);
        jlabel_price_Cheese_Chicken_Wrap_size_s.setBackground(Color.white);
        jlabel_price_Cheese_Chicken_Wrap_size_s.setOpaque(true);
        jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(false);

        jTextArea_Cheese_Chicken_Wrap_size_S.setBackground(Color.WHITE);
        jTextArea_Cheese_Chicken_Wrap_size_S.setBounds(300, 40, 75, 20);
        jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
        jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(false);

        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setBounds(390,40,80,20);
        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setBackground(Color.white);
        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText("0 IQD");
        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setEnabled(false);
        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setOpaque(true);


        checkBox_Cheese_Chicken_Wrap_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Cheese_Chicken_Wrap_size_S.isSelected()) {
                    jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(true);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(true);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setEditable(true);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                    jlabel_wassl_Cheese_Chicken_Wrap_size_s.setEnabled(true);
                }else {
                    jlabel_price_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setEnabled(false);
                    jlabel_wassl_Cheese_Chicken_Wrap_size_s.setEnabled(false);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setText("");
                    jTextArea_Cheese_Chicken_Wrap_size_S.setEditable(false);
                    jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText(0+" IQD");
                }
            }
        });

        jTextArea_Cheese_Chicken_Wrap_size_S.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Cheese_Chicken_Wrap_size_S.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Cheese_Chicken_Wrap_size_S[0] = Integer.parseInt(text);

                        value_Cheese_Chicken_Wrap_size_S[0] = Integer.parseInt(String.valueOf(value_Cheese_Chicken_Wrap_size_S[0]));

                        double value=(int) value_Cheese_Chicken_Wrap_size_S[0] *3;
                        jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Cheese_Chicken_Wrap_size_S.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Cheese_Chicken_Wrap_size_s.setText("0 IQD");
                }



            }
        });


        checkBox_Cheese_Chicken_Wrap_size_L.setBounds(175,70,18,20);
        checkBox_Cheese_Chicken_Wrap_size_L.setEnabled(false);

        jlabel_price_Cheese_Chicken_Wrap_size_L.setText(" Large 5,000 IQD");
        jlabel_price_Cheese_Chicken_Wrap_size_L.setBounds(192, 70, 95, 20);
        jlabel_price_Cheese_Chicken_Wrap_size_L.setBackground(Color.white);
        jlabel_price_Cheese_Chicken_Wrap_size_L.setOpaque(true);
        jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(false);

        jTextArea_Cheese_Chicken_Wrap_size_L.setBackground(Color.WHITE);
        jTextArea_Cheese_Chicken_Wrap_size_L.setBounds(300, 70, 75, 20);
        jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
        jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(false);


        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setBounds(390,70,80,20);
        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setBackground(Color.white);
        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText("0 IQD");
        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setEnabled(false);
        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setOpaque(true);

        checkBox_Cheese_Chicken_Wrap_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Cheese_Chicken_Wrap_size_L.isSelected()) {
                    jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(true);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(true);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setEditable(true);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
                    jlabel_wassl_Cheese_Chicken_Wrap_size_L.setEnabled(true);
                }else {
                    jlabel_price_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                    jlabel_wassl_Cheese_Chicken_Wrap_size_L.setEnabled(false);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setText("");
                    jTextArea_Cheese_Chicken_Wrap_size_L.setEditable(false);
                    jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText(0+" IQD");

                }
            }
        });



        jTextArea_Cheese_Chicken_Wrap_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Cheese_Chicken_Wrap_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Cheese_Chicken_Wrap_size_L[0] = Integer.parseInt(text);

                        value_Cheese_Chicken_Wrap_size_L[0] = Integer.parseInt(String.valueOf(value_Cheese_Chicken_Wrap_size_L[0]));

                        double value=(int) value_Cheese_Chicken_Wrap_size_L[0] *5;
                        jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Cheese_Chicken_Wrap_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Cheese_Chicken_Wrap_size_L.setText("0 IQD");
                }



            }
        });


        Cheese_Chicken_Wrap.add(checkBox_Cheese_Chicken_Wrap_size_S);
        Cheese_Chicken_Wrap.add(jlabel_price_Cheese_Chicken_Wrap_size_s);
        Cheese_Chicken_Wrap.add(jTextArea_Cheese_Chicken_Wrap_size_S);
        Cheese_Chicken_Wrap.add(jlabel_wassl_Cheese_Chicken_Wrap_size_s);

        Cheese_Chicken_Wrap.add(checkBox_Cheese_Chicken_Wrap_size_L);
        Cheese_Chicken_Wrap.add(jlabel_price_Cheese_Chicken_Wrap_size_L);
        Cheese_Chicken_Wrap.add(jTextArea_Cheese_Chicken_Wrap_size_L);
        Cheese_Chicken_Wrap.add(jlabel_wassl_Cheese_Chicken_Wrap_size_L);

        Cheese_Chicken_Wrap.add(cheese_Chicken_Wrap_Name);
        Cheese_Chicken_Wrap.add(CheckBox_cheese_Chicken_Wrap);
        Cheese_Chicken_Wrap.add(cheese_Chicken_WrapImage);

        Cheese_Chicken_Wrap.setLayout(null);
        Burger.add(Cheese_Chicken_Wrap);

    }
    void Cheese_Burger(){



        Cheese_Burger.setBounds(20, 125, 510,100 );
        Cheese_Burger.setBackground(new Color(153, 0,0 ));
        Cheese_Burger.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));



        Cheese_BurgerImage.setIcon(new ImageIcon("cheese Burger.png"));
        Cheese_BurgerImage.setBounds(-75, -10, 400, 120);


        Cheese_Burger_CheckBox.setBounds(135,10,20,20);


        Cheese_Burger_Name.setText(" Cheese Burger ");
        Cheese_Burger_Name.setBounds(160, 10, 150, 20);
        Cheese_Burger_Name.setBackground(Color.white);
        Cheese_Burger_Name.setOpaque(true);

        Cheese_Burger_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cheese_Burger_CheckBox.isSelected()) {
                    checkBox_Cheese_Burger_size_S.setEnabled(true);
                    checkBox_Cheese_Burger_size_L.setEnabled(true);

                    jlabel_price_Cheese_Burger_size_s.setEnabled(true);
                    jlabel_price_Cheese_Burger_size_L.setEnabled(true);

                    if(checkBox_Cheese_Burger_size_S.isSelected()){
                        jTextArea_Cheese_Burger_size_S.setEnabled(true);
                        jTextArea_Cheese_Burger_size_S.setText("");
                        jTextArea_Cheese_Burger_size_S.setEditable(true);
                    }else if(!checkBox_Cheese_Burger_size_S.isSelected()){
                        jTextArea_Cheese_Burger_size_S.setEnabled(false);
                        jTextArea_Cheese_Burger_size_S.setText("");
                        jTextArea_Cheese_Burger_size_S.setEditable(false);
                    }
                    if(checkBox_Cheese_Burger_size_L.isSelected()){
                        jTextArea_Cheese_Burger_size_L.setEnabled(true);
                        jTextArea_Cheese_Burger_size_L.setText("");
                        jTextArea_Cheese_Burger_size_L.setEditable(true);
                    }else if(!checkBox_Cheese_Burger_size_L.isSelected()){
                        jTextArea_Cheese_Burger_size_L.setEnabled(false);
                        jTextArea_Cheese_Burger_size_L.setText("");
                        jTextArea_Cheese_Burger_size_L.setEditable(false);
                    }
                }else {
                    checkBox_Cheese_Burger_size_S.setEnabled(false);
                    checkBox_Cheese_Burger_size_L.setEnabled(false);

                    jlabel_price_Cheese_Burger_size_s.setEnabled(false);
                    jlabel_price_Cheese_Burger_size_L.setEnabled(false);

                    if(!Cheese_Burger_CheckBox.isSelected()){
                        checkBox_Cheese_Burger_size_S.setSelected(false);
                        checkBox_Cheese_Burger_size_L.setSelected(false);

                        jlabel_price_Cheese_Burger_size_s.setEnabled(false);
                        jlabel_price_Cheese_Burger_size_L.setEnabled(false);

                        jTextArea_Cheese_Burger_size_S.setText("");
                        jTextArea_Cheese_Burger_size_L.setText("");

                        jTextArea_Cheese_Burger_size_S.setEditable(false);
                        jTextArea_Cheese_Burger_size_L.setEditable(false);

                        jTextArea_Cheese_Burger_size_S.setEnabled(false);
                        jTextArea_Cheese_Burger_size_L.setEnabled(false);

                        jlabel_wassl_Cheese_Burger_size_s.setEnabled(false);
                        jlabel_wassl_Cheese_Burger_size_L.setEnabled(false);

                        jlabel_wassl_Cheese_Burger_size_s.setText(0+" IQD");
                        jlabel_wassl_Cheese_Burger_size_L.setText(0+" IQD");
                    }

                }

            }
        });

        checkBox_Cheese_Burger_size_S.setBounds(175,40,18,20);
        checkBox_Cheese_Burger_size_S.setEnabled(false);

        jlabel_price_Cheese_Burger_size_s.setText(" small 5,000 IQD");
        jlabel_price_Cheese_Burger_size_s.setBounds(192, 40, 95, 20);
        jlabel_price_Cheese_Burger_size_s.setBackground(Color.white);
        jlabel_price_Cheese_Burger_size_s.setOpaque(true);
        jlabel_price_Cheese_Burger_size_s.setEnabled(false);

        jTextArea_Cheese_Burger_size_S.setBackground(Color.WHITE);
        jTextArea_Cheese_Burger_size_S.setBounds(300, 40, 75, 20);
        jTextArea_Cheese_Burger_size_S.setText("");
        jTextArea_Cheese_Burger_size_S.setEnabled(false);

        jlabel_wassl_Cheese_Burger_size_s.setBounds(390,40,80,20);
        jlabel_wassl_Cheese_Burger_size_s.setBackground(Color.white);
        jlabel_wassl_Cheese_Burger_size_s.setText("0 IQD");
        jlabel_wassl_Cheese_Burger_size_s.setEnabled(false);
        jlabel_wassl_Cheese_Burger_size_s.setOpaque(true);


        checkBox_Cheese_Burger_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Cheese_Burger_size_S.isSelected()) {
                    jlabel_price_Cheese_Burger_size_s.setEnabled(true);
                    jTextArea_Cheese_Burger_size_S.setEnabled(true);
                    jlabel_wassl_Cheese_Burger_size_s.setEnabled(true);
                    jTextArea_Cheese_Burger_size_S.setText("");
                    jTextArea_Cheese_Burger_size_S.setEditable(true);
                }else {

                    jlabel_price_Cheese_Burger_size_s.setEnabled(false);
                    jTextArea_Cheese_Burger_size_S.setEnabled(false);
                    jlabel_wassl_Cheese_Burger_size_s.setEnabled(false);
                    jTextArea_Cheese_Burger_size_S.setEditable(false);
                    jTextArea_Cheese_Burger_size_S.setText("");
                    jlabel_wassl_Cheese_Burger_size_s.setText(0+" IQD");
                }
            }
        });

        jTextArea_Cheese_Burger_size_S.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Cheese_Burger_size_S.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Cheese_Burger_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Cheese_Burger_size_S[0] = Integer.parseInt(text);

                        value_Cheese_Burger_size_S[0] = Integer.parseInt(String.valueOf(value_Cheese_Burger_size_S[0]));

                        double value=(int) value_Cheese_Burger_size_S[0] *5;
                        jlabel_wassl_Cheese_Burger_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Cheese_Burger_size_S.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Cheese_Burger_size_s.setText("0 IQD");
                }



            }
        });


        checkBox_Cheese_Burger_size_L.setBounds(175,70,18,20);
        checkBox_Cheese_Burger_size_L.setEnabled(false);

        jlabel_price_Cheese_Burger_size_L.setText(" Large 8,000 IQD");
        jlabel_price_Cheese_Burger_size_L.setBounds(192, 70, 95, 20);
        jlabel_price_Cheese_Burger_size_L.setBackground(Color.white);
        jlabel_price_Cheese_Burger_size_L.setOpaque(true);
        jlabel_price_Cheese_Burger_size_L.setEnabled(false);

        jTextArea_Cheese_Burger_size_L.setBackground(Color.WHITE);
        jTextArea_Cheese_Burger_size_L.setBounds(300, 70, 75, 20);
        jTextArea_Cheese_Burger_size_L.setText("");
        jTextArea_Cheese_Burger_size_L.setEnabled(false);


        jlabel_wassl_Cheese_Burger_size_L.setBounds(390,70,80,20);
        jlabel_wassl_Cheese_Burger_size_L.setBackground(Color.white);
        jlabel_wassl_Cheese_Burger_size_L.setText("0 IQD");
        jlabel_wassl_Cheese_Burger_size_L.setEnabled(false);
        jlabel_wassl_Cheese_Burger_size_L.setOpaque(true);

        checkBox_Cheese_Burger_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Cheese_Burger_size_L.isSelected()) {
                    jlabel_price_Cheese_Burger_size_L.setEnabled(true);
                    jTextArea_Cheese_Burger_size_L.setEnabled(true);
                    jlabel_wassl_Cheese_Burger_size_L.setEnabled(true);
                    jTextArea_Cheese_Burger_size_L.setText("");
                    jTextArea_Cheese_Burger_size_L.setEditable(true);
                }else {

                    jlabel_price_Cheese_Burger_size_L.setEnabled(false);
                    jTextArea_Cheese_Burger_size_L.setEnabled(false);
                    jlabel_wassl_Cheese_Burger_size_L.setEnabled(false);
                    jTextArea_Cheese_Burger_size_L.setEditable(false);
                    jTextArea_Cheese_Burger_size_L.setText("");
                    jlabel_wassl_Cheese_Burger_size_L.setText(0+" IQD");
                }

            }
        });



        jTextArea_Cheese_Burger_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Cheese_Burger_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Cheese_Burger_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Cheese_Burger_size_L[0] = Integer.parseInt(text);

                        value_Cheese_Burger_size_L[0] = Integer.parseInt(String.valueOf(value_Cheese_Burger_size_L[0]));

                        double value=(int) value_Cheese_Burger_size_L[0] *8;
                        jlabel_wassl_Cheese_Burger_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Cheese_Burger_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Cheese_Burger_size_L.setText("0 IQD");
                }



            }
        });


        Cheese_Burger.add(checkBox_Cheese_Burger_size_S);
        Cheese_Burger.add(jlabel_price_Cheese_Burger_size_s);
        Cheese_Burger.add(jTextArea_Cheese_Burger_size_S);
        Cheese_Burger.add(jlabel_wassl_Cheese_Burger_size_s);

        Cheese_Burger.add(checkBox_Cheese_Burger_size_L);
        Cheese_Burger.add(jlabel_price_Cheese_Burger_size_L);
        Cheese_Burger.add(jTextArea_Cheese_Burger_size_L);
        Cheese_Burger.add(jlabel_wassl_Cheese_Burger_size_L);


        Cheese_Burger.add(Cheese_Burger_Name);
        Cheese_Burger.add(Cheese_Burger_CheckBox);
        Cheese_Burger.add(Cheese_BurgerImage);
        Cheese_Burger.setLayout(null);
        Burger.add(Cheese_Burger);
    }
    void Farm_Burger(){
        Farm_Burger.setBounds(20, 230, 510,100 );
        Farm_Burger.setBackground(new Color(153, 0,0 ));
        Farm_Burger.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));


        Farm_BurgerImage.setIcon(new ImageIcon("Farm_Burger.png"));
        Farm_BurgerImage.setBounds(-130, -10, 450, 120);


        Farm_Burger_CheckBox.setBounds(135,10,20,20);

        Farm_Burger_Name.setText(" Farm Burger ");
        Farm_Burger_Name.setBounds(160, 10, 150, 20);
        Farm_Burger_Name.setBackground(Color.white);
        Farm_Burger_Name.setOpaque(true);

        Farm_Burger_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Farm_Burger_CheckBox.isSelected()) {
                    checkBox_Farm_Burger_size_S.setEnabled(true);
                    checkBox_Farm_Burger_size_L.setEnabled(true);

                    jlabel_price_Farm_Burger_size_s.setEnabled(true);
                    jlabel_price_Farm_Burger_size_L.setEnabled(true);


                    if(checkBox_Farm_Burger_size_S.isSelected()){
                        jTextArea_Farm_Burger_size_S.setEnabled(true);
                        jTextArea_Farm_Burger_size_S.setText("");
                        jTextArea_Farm_Burger_size_S.setEditable(true);
                    }else if(!checkBox_Farm_Burger_size_S.isSelected()){
                        jTextArea_Farm_Burger_size_S.setEnabled(false);
                        jTextArea_Farm_Burger_size_S.setText("");
                        jTextArea_Farm_Burger_size_S.setEditable(false);
                    }
                    if(checkBox_Farm_Burger_size_L.isSelected()){
                        jTextArea_Farm_Burger_size_L.setEnabled(true);
                        jTextArea_Farm_Burger_size_L.setText("");
                        jTextArea_Farm_Burger_size_L.setEditable(true);
                    }else if(!checkBox_Farm_Burger_size_L.isSelected()){
                        jTextArea_Farm_Burger_size_L.setEnabled(false);
                        jTextArea_Farm_Burger_size_L.setText("");
                        jTextArea_Farm_Burger_size_L.setEditable(false);
                    }

                }else {
                    checkBox_Farm_Burger_size_S.setEnabled(false);
                    checkBox_Farm_Burger_size_L.setEnabled(false);

                    jlabel_price_Farm_Burger_size_s.setEnabled(false);
                    jlabel_price_Farm_Burger_size_L.setEnabled(false);

                    if(!Farm_Burger_CheckBox.isSelected()){
                        checkBox_Farm_Burger_size_S.setSelected(false);
                        checkBox_Farm_Burger_size_L.setSelected(false);

                        jlabel_price_Farm_Burger_size_s.setEnabled(false);
                        jlabel_price_Farm_Burger_size_L.setEnabled(false);

                        jTextArea_Farm_Burger_size_S.setText("");
                        jTextArea_Farm_Burger_size_L.setText("");

                        jTextArea_Farm_Burger_size_S.setEnabled(false);
                        jTextArea_Farm_Burger_size_L.setEnabled(false);

                        jTextArea_Farm_Burger_size_S.setEditable(false);
                        jTextArea_Farm_Burger_size_L.setEditable(false);

                        jlabel_wassl_Farm_Burger_size_s.setEnabled(false);
                        jlabel_wassl_Farm_Burger_size_L.setEnabled(false);

                        jlabel_wassl_Farm_Burger_size_s.setText(0+" IQD");
                        jlabel_wassl_Farm_Burger_size_L.setText(0+" IQD");
                    }

                }

            }
        });

        checkBox_Farm_Burger_size_S.setBounds(175,40,18,20);
        checkBox_Farm_Burger_size_S.setEnabled(false);

        jlabel_price_Farm_Burger_size_s.setText(" small 6,500 IQD");
        jlabel_price_Farm_Burger_size_s.setBounds(192, 40, 95, 20);
        jlabel_price_Farm_Burger_size_s.setBackground(Color.white);
        jlabel_price_Farm_Burger_size_s.setOpaque(true);
        jlabel_price_Farm_Burger_size_s.setEnabled(false);

        jTextArea_Farm_Burger_size_S.setBackground(Color.WHITE);
        jTextArea_Farm_Burger_size_S.setBounds(300, 40, 75, 20);
        jTextArea_Farm_Burger_size_S.setText("");
        jTextArea_Farm_Burger_size_S.setEnabled(false);

        jlabel_wassl_Farm_Burger_size_s.setBounds(390,40,80,20);
        jlabel_wassl_Farm_Burger_size_s.setBackground(Color.white);
        jlabel_wassl_Farm_Burger_size_s.setText("0 IQD");
        jlabel_wassl_Farm_Burger_size_s.setEnabled(false);
        jlabel_wassl_Farm_Burger_size_s.setOpaque(true);


        checkBox_Farm_Burger_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Farm_Burger_size_S.isSelected()) {
                    jlabel_price_Farm_Burger_size_s.setEnabled(true);
                    jTextArea_Farm_Burger_size_S.setEnabled(true);
                    jlabel_wassl_Farm_Burger_size_s.setEnabled(true);
                    jTextArea_Farm_Burger_size_S.setEditable(true);
                    jTextArea_Farm_Burger_size_S.setText("");
                }else {
                    jlabel_price_Farm_Burger_size_s.setEnabled(false);
                    jTextArea_Farm_Burger_size_S.setEnabled(false);
                    jlabel_wassl_Farm_Burger_size_s.setEnabled(false);
                    jTextArea_Farm_Burger_size_S.setText("");
                    jTextArea_Farm_Burger_size_S.setEditable(false);
                    jlabel_wassl_Farm_Burger_size_s.setText(0+" IQD");
                }
            }
        });

        jTextArea_Farm_Burger_size_S.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Farm_Burger_size_S.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Farm_Burger_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Farm_Burger_size_S[0] = Integer.parseInt(text);

                        value_Farm_Burger_size_S[0] = Integer.parseInt(String.valueOf(value_Farm_Burger_size_S[0]));

                        double value=(int) value_Farm_Burger_size_S[0] *6.5;
                        jlabel_wassl_Farm_Burger_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Farm_Burger_size_S.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Farm_Burger_size_s.setText("0 IQD");
                }



            }
        });


        checkBox_Farm_Burger_size_L.setBounds(175,70,18,20);
        checkBox_Farm_Burger_size_L.setEnabled(false);

        jlabel_price_Farm_Burger_size_L.setText(" Large 9,500 IQD");
        jlabel_price_Farm_Burger_size_L.setBounds(192, 70, 95, 20);
        jlabel_price_Farm_Burger_size_L.setBackground(Color.white);
        jlabel_price_Farm_Burger_size_L.setOpaque(true);
        jlabel_price_Farm_Burger_size_L.setEnabled(false);

        jTextArea_Farm_Burger_size_L.setBackground(Color.WHITE);
        jTextArea_Farm_Burger_size_L.setBounds(300, 70, 75, 20);
        jTextArea_Farm_Burger_size_L.setText("");
        jTextArea_Farm_Burger_size_L.setEnabled(false);


        jlabel_wassl_Farm_Burger_size_L.setBounds(390,70,80,20);
        jlabel_wassl_Farm_Burger_size_L.setBackground(Color.white);
        jlabel_wassl_Farm_Burger_size_L.setText("0 IQD");
        jlabel_wassl_Farm_Burger_size_L.setEnabled(false);
        jlabel_wassl_Farm_Burger_size_L.setOpaque(true);

        checkBox_Farm_Burger_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Farm_Burger_size_L.isSelected()) {
                    jlabel_price_Farm_Burger_size_L.setEnabled(true);
                    jTextArea_Farm_Burger_size_L.setEnabled(true);
                    jlabel_wassl_Farm_Burger_size_L.setEnabled(true);
                    jTextArea_Farm_Burger_size_L.setEditable(true);
                }else {
                    jlabel_price_Farm_Burger_size_L.setEnabled(false);
                    jTextArea_Farm_Burger_size_L.setEnabled(false);
                    jlabel_wassl_Farm_Burger_size_L.setEnabled(false);
                    jTextArea_Farm_Burger_size_L.setText("");
                    jTextArea_Farm_Burger_size_L.setEditable(false);
                    jlabel_wassl_Farm_Burger_size_L.setText(0+" IQD");

                }
            }
        });


        jTextArea_Farm_Burger_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Farm_Burger_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Farm_Burger_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Farm_Burger_size_L[0] = Integer.parseInt(text);

                        value_Farm_Burger_size_L[0] = Integer.parseInt(String.valueOf(value_Farm_Burger_size_L[0]));

                        double value=(int) value_Farm_Burger_size_L[0] *9.5;
                        jlabel_wassl_Farm_Burger_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Farm_Burger_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Farm_Burger_size_L.setText("0 IQD");
                }



            }
        });


        Farm_Burger.add(checkBox_Farm_Burger_size_S);
        Farm_Burger.add(jlabel_price_Farm_Burger_size_s);
        Farm_Burger.add(jTextArea_Farm_Burger_size_S);
        Farm_Burger.add(jlabel_wassl_Farm_Burger_size_s);

        Farm_Burger.add(checkBox_Farm_Burger_size_L);
        Farm_Burger.add(jlabel_price_Farm_Burger_size_L);
        Farm_Burger.add(jTextArea_Farm_Burger_size_L);
        Farm_Burger.add(jlabel_wassl_Farm_Burger_size_L);


        Farm_Burger.add(Farm_Burger_Name);
        Farm_Burger.add(Farm_Burger_CheckBox);
        Farm_Burger.add(Farm_BurgerImage);
        Farm_Burger.setLayout(null);
        Burger.add(Farm_Burger);
    }
    void Double_Cheese_Burger() {
        Double_Cheese_Burger.setBounds(20, 335, 510, 100);
        Double_Cheese_Burger.setBackground(new Color(153, 0, 0));
        Double_Cheese_Burger.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        Double_Cheese_BurgerImage.setIcon(new ImageIcon("Double_Cheese_Burger.png"));
        Double_Cheese_BurgerImage.setBounds(-75, -10, 450, 120);

        Double_Cheese_Burger_CheckBox.setBounds(135, 10, 20, 20);

        Double_Cheese_Burger_Name.setText(" Double Cheese Burger ");
        Double_Cheese_Burger_Name.setBounds(160, 10, 150, 20);
        Double_Cheese_Burger_Name.setBackground(Color.white);
        Double_Cheese_Burger_Name.setOpaque(true);

        Double_Cheese_Burger_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Double_Cheese_Burger_CheckBox.isSelected()) {
                    checkBox_Double_Cheese_Burger_size_S.setEnabled(true);
                    checkBox_Double_Cheese_Burger_size_L.setEnabled(true);

                    jlabel_price_Double_Cheese_Burger_size_s.setEnabled(true);
                    jlabel_price_Double_Cheese_Burger_size_L.setEnabled(true);

                    if (checkBox_Double_Cheese_Burger_size_S.isSelected()) {
                        jTextArea_Double_Cheese_Burger_size_S.setEnabled(true);
                        jTextArea_Double_Cheese_Burger_size_S.setText("");
                        jTextArea_Double_Cheese_Burger_size_S.setEditable(true);
                    } else if (!checkBox_Double_Cheese_Burger_size_S.isSelected()) {
                        jTextArea_Double_Cheese_Burger_size_S.setEnabled(false);
                        jTextArea_Double_Cheese_Burger_size_S.setText("");
                        jTextArea_Double_Cheese_Burger_size_S.setEditable(false);
                    }
                    if (checkBox_Double_Cheese_Burger_size_L.isSelected()) {
                        jTextArea_Double_Cheese_Burger_size_L.setEnabled(true);
                        jTextArea_Double_Cheese_Burger_size_L.setText("");
                        jTextArea_Double_Cheese_Burger_size_L.setEditable(true);
                    } else if (!checkBox_Double_Cheese_Burger_size_L.isSelected()) {
                        jTextArea_Double_Cheese_Burger_size_L.setEnabled(false);
                        jTextArea_Double_Cheese_Burger_size_L.setText("");
                        jTextArea_Double_Cheese_Burger_size_L.setEditable(false);
                    }


                } else {
                    checkBox_Double_Cheese_Burger_size_S.setEnabled(false);
                    checkBox_Double_Cheese_Burger_size_L.setEnabled(false);

                    jlabel_price_Double_Cheese_Burger_size_s.setEnabled(false);
                    jlabel_price_Double_Cheese_Burger_size_L.setEnabled(false);

                    if (!Double_Cheese_Burger_CheckBox.isSelected()) {
                        checkBox_Double_Cheese_Burger_size_S.setSelected(false);
                        checkBox_Double_Cheese_Burger_size_L.setSelected(false);

                        jlabel_price_Double_Cheese_Burger_size_s.setEnabled(false);
                        jlabel_price_Double_Cheese_Burger_size_L.setEnabled(false);

                        jTextArea_Double_Cheese_Burger_size_S.setText("");
                        jTextArea_Double_Cheese_Burger_size_L.setText("");

                        jTextArea_Double_Cheese_Burger_size_S.setEditable(false);
                        jTextArea_Double_Cheese_Burger_size_L.setEditable(false);

                        jTextArea_Double_Cheese_Burger_size_S.setEnabled(false);
                        jTextArea_Double_Cheese_Burger_size_L.setEnabled(false);


                        jlabel_wassl_Double_Cheese_Burger_size_s.setEnabled(false);
                        jlabel_wassl_Double_Cheese_Burger_size_L.setEnabled(false);

                        jlabel_wassl_Double_Cheese_Burger_size_s.setText(0 + " IQD");
                        jlabel_wassl_Double_Cheese_Burger_size_L.setText(0 + " IQD");
                    }

                }

            }
        });

        checkBox_Double_Cheese_Burger_size_S.setBounds(175, 40, 18, 20);
        checkBox_Double_Cheese_Burger_size_S.setEnabled(false);

        jlabel_price_Double_Cheese_Burger_size_s.setText(" small 9,000 IQD");
        jlabel_price_Double_Cheese_Burger_size_s.setBounds(192, 40, 95, 20);
        jlabel_price_Double_Cheese_Burger_size_s.setBackground(Color.white);
        jlabel_price_Double_Cheese_Burger_size_s.setOpaque(true);
        jlabel_price_Double_Cheese_Burger_size_s.setEnabled(false);

        jTextArea_Double_Cheese_Burger_size_S.setBackground(Color.WHITE);
        jTextArea_Double_Cheese_Burger_size_S.setBounds(300, 40, 75, 20);
        jTextArea_Double_Cheese_Burger_size_S.setText("");
        jTextArea_Double_Cheese_Burger_size_S.setEnabled(false);

        jlabel_wassl_Double_Cheese_Burger_size_s.setBounds(390, 40, 80, 20);
        jlabel_wassl_Double_Cheese_Burger_size_s.setBackground(Color.white);
        jlabel_wassl_Double_Cheese_Burger_size_s.setText("0 IQD");
        jlabel_wassl_Double_Cheese_Burger_size_s.setEnabled(false);
        jlabel_wassl_Double_Cheese_Burger_size_s.setOpaque(true);


        checkBox_Double_Cheese_Burger_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Double_Cheese_Burger_size_S.isSelected()) {
                    jlabel_price_Double_Cheese_Burger_size_s.setEnabled(true);
                    jTextArea_Double_Cheese_Burger_size_S.setEnabled(true);
                    jTextArea_Double_Cheese_Burger_size_S.setEditable(true);
                    jlabel_wassl_Double_Cheese_Burger_size_s.setEnabled(true);
                    jTextArea_Double_Cheese_Burger_size_S.setText("");
                } else {
                    jlabel_price_Double_Cheese_Burger_size_s.setEnabled(false);
                    jTextArea_Double_Cheese_Burger_size_S.setEnabled(false);
                    jlabel_wassl_Double_Cheese_Burger_size_s.setEnabled(false);
                    jTextArea_Double_Cheese_Burger_size_S.setText("");
                    jTextArea_Double_Cheese_Burger_size_S.setEditable(false);
                    jlabel_wassl_Double_Cheese_Burger_size_s.setText(0 + " IQD");
                }
            }
        });

        jTextArea_Double_Cheese_Burger_size_S.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Double_Cheese_Burger_size_S.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Double_Cheese_Burger_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Double_Cheese_Burger_size_S[0] = Integer.parseInt(text);

                        value_Double_Cheese_Burger_size_S[0] = Integer.parseInt(String.valueOf(value_Double_Cheese_Burger_size_S[0]));

                        double value = (int) value_Double_Cheese_Burger_size_S[0] * 9;
                        jlabel_wassl_Double_Cheese_Burger_size_s.setText(value + " IQD");
                        temp += value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Double_Cheese_Burger_size_S.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Double_Cheese_Burger_size_s.setText("0 IQD");
                }


            }
        });


        checkBox_Double_Cheese_Burger_size_L.setBounds(175, 70, 18, 20);
        checkBox_Double_Cheese_Burger_size_L.setEnabled(false);

        jlabel_price_Double_Cheese_Burger_size_L.setText(" Large 12,000 IQD");
        jlabel_price_Double_Cheese_Burger_size_L.setBounds(192, 70, 95, 20);
        jlabel_price_Double_Cheese_Burger_size_L.setBackground(Color.white);
        jlabel_price_Double_Cheese_Burger_size_L.setOpaque(true);
        jlabel_price_Double_Cheese_Burger_size_L.setEnabled(false);

        jTextArea_Double_Cheese_Burger_size_L.setBackground(Color.WHITE);
        jTextArea_Double_Cheese_Burger_size_L.setBounds(300, 70, 75, 20);
        jTextArea_Double_Cheese_Burger_size_L.setText("");
        jTextArea_Double_Cheese_Burger_size_L.setEnabled(false);


        jlabel_wassl_Double_Cheese_Burger_size_L.setBounds(390, 70, 80, 20);
        jlabel_wassl_Double_Cheese_Burger_size_L.setBackground(Color.white);
        jlabel_wassl_Double_Cheese_Burger_size_L.setText("0 IQD");
        jlabel_wassl_Double_Cheese_Burger_size_L.setEnabled(false);
        jlabel_wassl_Double_Cheese_Burger_size_L.setOpaque(true);


        checkBox_Double_Cheese_Burger_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_Double_Cheese_Burger_size_L.isSelected()) {
                    jlabel_price_Double_Cheese_Burger_size_L.setEnabled(true);
                    jTextArea_Double_Cheese_Burger_size_L.setEnabled(true);
                    jlabel_wassl_Double_Cheese_Burger_size_L.setEnabled(true);
                    jTextArea_Double_Cheese_Burger_size_L.setEditable(true);
                    jTextArea_Double_Cheese_Burger_size_L.setText("");
                } else {
                    jlabel_price_Double_Cheese_Burger_size_L.setEnabled(false);
                    jTextArea_Double_Cheese_Burger_size_L.setEnabled(false);
                    jlabel_wassl_Double_Cheese_Burger_size_L.setEnabled(false);
                    jTextArea_Double_Cheese_Burger_size_L.setText("");
                    jTextArea_Double_Cheese_Burger_size_L.setEditable(false);
                    jlabel_wassl_Double_Cheese_Burger_size_L.setText(0 + " IQD");

                }
            }
        });

        jTextArea_Double_Cheese_Burger_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_Double_Cheese_Burger_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_Double_Cheese_Burger_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_Double_Cheese_Burger_size_L[0] = Integer.parseInt(text);

                        value_Double_Cheese_Burger_size_L[0] = Integer.parseInt(String.valueOf(value_Double_Cheese_Burger_size_L[0]));

                        double value = (int) value_Double_Cheese_Burger_size_L[0] * 12;
                        jlabel_wassl_Double_Cheese_Burger_size_L.setText(value + " IQD");
                        temp += value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_Double_Cheese_Burger_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_Double_Cheese_Burger_size_L.setText("0 IQD");
                }


            }
        });


        Double_Cheese_Burger.add(checkBox_Double_Cheese_Burger_size_S);
        Double_Cheese_Burger.add(jlabel_price_Double_Cheese_Burger_size_s);
        Double_Cheese_Burger.add(jTextArea_Double_Cheese_Burger_size_S);
        Double_Cheese_Burger.add(jlabel_wassl_Double_Cheese_Burger_size_s);

        Double_Cheese_Burger.add(checkBox_Double_Cheese_Burger_size_L);
        Double_Cheese_Burger.add(jlabel_price_Double_Cheese_Burger_size_L);
        Double_Cheese_Burger.add(jTextArea_Double_Cheese_Burger_size_L);
        Double_Cheese_Burger.add(jlabel_wassl_Double_Cheese_Burger_size_L);


        Double_Cheese_Burger.add(Double_Cheese_Burger_Name);
        Double_Cheese_Burger.add(Double_Cheese_Burger_CheckBox);
        Double_Cheese_Burger.add(Double_Cheese_BurgerImage);
        Double_Cheese_Burger.setLayout(null);
        Burger.add(Double_Cheese_Burger);
    }
}
