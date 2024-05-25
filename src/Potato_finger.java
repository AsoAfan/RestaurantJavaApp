import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Potato_finger {
    double temp=0;
    public static final int[] value_potato1 = new int[1];
    public static final int[] value_potato2 = new int[1];
    public static JLabel potato1_Name=new JLabel();
    public static JLabel potato1_Image = new JLabel();
    public static JPanel potato1 =new JPanel();
    public static JLabel lasagna_meat_Name=new JLabel();
    public static JCheckBox potato_CheckBox =new JCheckBox();

    public static JCheckBox checkBox_potato1 =new JCheckBox();
    public static JCheckBox checkBox_potato2 =new JCheckBox();

    public static JLabel jlabel_price_potato1 =new JLabel();
    public static JLabel jlabel_price_potato2 =new JLabel();

    public static JTextArea jTextArea_potato1=new JTextArea();
    public static JTextArea jTextArea_potato2 =new JTextArea();

    public static JLabel jlabel_wassl_potato1=new JLabel();
    public static JLabel jlabel_wassl_potato2 =new JLabel();
    public static JPanel potato_finger =new JPanel();
    Potato_finger(){

        potato_finger.setBackground(Color.white);
        potato_finger.setBorder(new LineBorder(Color.BLACK));
        potato_finger.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        potato_finger.setBounds(800,330,550,140);


        potato1();


        potato_finger.setLayout(null);
        GUI.fastFood.add(potato_finger);

    }

    void potato1(){
        potato1.setBounds(20, 20, 510,100 );
        potato1.setBackground(new Color(153, 0,0 ));
        potato1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        potato1_Image.setIcon(new ImageIcon("potato1.png"));
        potato1_Image.setBounds(-30, -10, 500, 150);

        potato1_Name.setText(" Potato  ");
        potato1_Name.setBounds(160, 10, 50, 20);
        potato1_Name.setBackground(Color.white);
        potato1_Name.setOpaque(true);

        potato_CheckBox.setBounds(135,10,20,20);


        lasagna_meat_Name.setText(" lasagna Meat ");
        lasagna_meat_Name.setBounds(160, 10, 100, 20);
        lasagna_meat_Name.setBackground(Color.white);
        lasagna_meat_Name.setOpaque(true);




        potato_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (potato_CheckBox.isSelected()) {
                    checkBox_potato1.setEnabled(true);
                    checkBox_potato2.setEnabled(true);


                    jlabel_price_potato1.setEnabled(true);
                    jlabel_price_potato2.setEnabled(true);

                    if(checkBox_potato1.isSelected()){
                        jTextArea_potato1.setEnabled(true);
                        jTextArea_potato1.setText("");
                        jTextArea_potato1.setEditable(true);
                    }else if(!checkBox_potato1.isSelected()){
                        jTextArea_potato1.setEnabled(false);
                        jTextArea_potato1.setText("");
                        jTextArea_potato1.setEditable(false);
                    }
                    if(checkBox_potato1.isSelected()){
                        jTextArea_potato2.setEnabled(true);
                        jTextArea_potato2.setText("");
                        jTextArea_potato2.setEditable(true);
                    }else if(!checkBox_potato1.isSelected()){
                        jTextArea_potato2.setEnabled(false);
                        jTextArea_potato2.setText("");
                        jTextArea_potato2.setEditable(false);
                    }


                }else {
                    checkBox_potato1.setEnabled(false);
                    checkBox_potato2.setEnabled(false);

                    jlabel_price_potato1.setEnabled(false);
                    jlabel_price_potato2.setEnabled(false);

                    if(!potato_CheckBox.isSelected()){
                        checkBox_potato1.setSelected(false);
                        checkBox_potato2.setSelected(false);

                        jlabel_price_potato1.setEnabled(false);
                        jlabel_price_potato2.setEnabled(false);

                        jTextArea_potato1.setText("");
                        jTextArea_potato2.setText("");

                        jTextArea_potato1.setEditable(false);
                        jTextArea_potato2.setEditable(false);

                        jlabel_wassl_potato1.setEnabled(false);
                        jlabel_wassl_potato2.setEnabled(false);

                        jlabel_wassl_potato1.setText(0+" IQD");
                        jlabel_wassl_potato2.setText(0+" IQD");
                    }

                }

            }
        });

        checkBox_potato1.setBounds(175,40,18,20);
        checkBox_potato1.setEnabled(false);

        jlabel_price_potato1.setText(" small 2,000 IQD");
        jlabel_price_potato1.setBounds(192, 40, 95, 20);
        jlabel_price_potato1.setBackground(Color.white);
        jlabel_price_potato1.setOpaque(true);
        jlabel_price_potato1.setEnabled(false);

        jTextArea_potato1.setBackground(Color.WHITE);
        jTextArea_potato1.setBounds(300, 40, 75, 20);
        jTextArea_potato1.setText("");
        jTextArea_potato1.setEnabled(false);

        jlabel_wassl_potato1.setBounds(390,40,80,20);
        jlabel_wassl_potato1.setBackground(Color.white);
        jlabel_wassl_potato1.setText("0 IQD");
        jlabel_wassl_potato1.setEnabled(false);
        jlabel_wassl_potato1.setOpaque(true);


        checkBox_potato1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_potato1.isSelected()) {
                    jlabel_price_potato1.setEnabled(true);
                    jTextArea_potato1.setEnabled(true);
                    jTextArea_potato1.setText("");
                    jTextArea_potato1.setEditable(true);
                    jlabel_wassl_potato1.setEnabled(true);
                }else {
                    jlabel_price_potato1.setEnabled(false);
                    jlabel_wassl_potato1.setEnabled(false);
                    jTextArea_potato1.setEnabled(false);
                    jTextArea_potato1.setText("");
                    jTextArea_potato1.setEditable(false);
                    jlabel_wassl_potato1.setText(0+" IQD");
                }
            }
        });
        jTextArea_potato1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_potato1.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_potato1.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_potato1[0] = Integer.parseInt(text);

                        value_potato1[0] = Integer.parseInt(String.valueOf(value_potato1[0]));

                        double value=(int) value_potato1[0] *2;
                        jlabel_wassl_potato1.setText(value+" IQD");
                        temp+=value;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_potato1.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_potato1.setText("0 IQD");
                }
            }
        });


        checkBox_potato2.setBounds(175,70,18,20);
        checkBox_potato2.setEnabled(false);

        jlabel_price_potato2.setText(" Large 5,000 IQD");
        jlabel_price_potato2.setBounds(192, 70, 95, 20);
        jlabel_price_potato2.setBackground(Color.white);
        jlabel_price_potato2.setOpaque(true);
        jlabel_price_potato2.setEnabled(false);

        jTextArea_potato2.setBackground(Color.WHITE);
        jTextArea_potato2.setBounds(300, 70, 75, 20);
        jTextArea_potato2.setText("");
        jTextArea_potato2.setEnabled(false);


        jlabel_wassl_potato2.setBounds(390,70,80,20);
        jlabel_wassl_potato2.setBackground(Color.white);
        jlabel_wassl_potato2.setText("0 IQD");
        jlabel_wassl_potato2.setEnabled(false);
        jlabel_wassl_potato2.setOpaque(true);

        checkBox_potato2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_potato2.isSelected()) {
                    jlabel_price_potato2.setEnabled(true);
                    jTextArea_potato2.setEnabled(true);
                    jTextArea_potato2.setEditable(true);
                    jTextArea_potato2.setText("");
                    jlabel_wassl_potato2.setEnabled(true);
                }else {
                    jlabel_price_potato2.setEnabled(false);
                    jlabel_wassl_potato2.setEnabled(false);
                    jTextArea_potato2.setEditable(false);
                    jTextArea_potato2.setEnabled(false);
                    jTextArea_potato2.setText("");
                    jlabel_wassl_potato2.setText(0+" IQD");

                }
            }
        });



        jTextArea_potato2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_potato2.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_potato2.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_potato2[0] = Integer.parseInt(text);

                        value_potato2[0] = Integer.parseInt(String.valueOf(value_potato2[0]));

                        double value=(int) value_potato2[0] *5;
                        jlabel_wassl_potato2.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_potato2.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_potato2.setText("0 IQD");
                }



            }
        });
        potato1.add(checkBox_potato1);
        potato1.add(jlabel_price_potato1);
        potato1.add(jTextArea_potato1);
        potato1.add(jlabel_wassl_potato1);
        potato1.add(checkBox_potato2);
        potato1.add(jlabel_price_potato2);
        potato1.add(jTextArea_potato2);
        potato1.add(jlabel_wassl_potato2);

        potato1.add(potato1_Name);
        potato1.add(potato_CheckBox);
        potato1.add(potato1_Image);
        potato1.setLayout(null);
        potato_finger.add(potato1);
    }
}
