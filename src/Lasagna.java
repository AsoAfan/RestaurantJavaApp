import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Lasagna {

    double temp=0;
    public static JPanel lasagna =new JPanel();
    public static final int[] value_lasagna_meat_size_S = new int[1];
    public static final int[] value_lasagna_meat_size_L = new int[1];
    public static JPanel lasagna_panel =new JPanel();
    public static JLabel lasagna_meat_Image = new JLabel();
    public static JLabel lasagna_meat_Name=new JLabel();

    public static JCheckBox lasagna_meat_CheckBox=new JCheckBox("lasagna_meat_CheckBox");

    public static JCheckBox checkBox_lasagna_meat_size_S =new JCheckBox();
    public static JCheckBox checkBox_lasagna_meat_size_L =new JCheckBox();

    public static JLabel jlabel_price_lasagna_meat_size_s =new JLabel();
    public static JLabel jlabel_price_lasagna_meat_size_L =new JLabel();

    public static JTextArea jTextArea_lasagna_meat_size_S=new JTextArea();
    public static JTextArea jTextArea_lasagna_meat_size_L =new JTextArea();

    public static JLabel jlabel_wassl_lasagna_meat_size_s=new JLabel();
    public static JLabel jlabel_wassl_lasagna_meat_size_L =new JLabel();





    Lasagna(){

        lasagna.setBackground(Color.white);
        lasagna.setBorder(new LineBorder(Color.BLACK));
        lasagna.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        lasagna.setBounds(800,120,550,140);




        lasagna_meat();


        lasagna.setLayout(null);
        GUI.fastFood.add(lasagna);

    }

    void lasagna_meat(){

        lasagna_panel.setBounds(20, 20, 510,100 );
        lasagna_panel.setBackground(new Color(153, 0,0 ));
        lasagna_panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));


        lasagna_meat_Image.setIcon(new ImageIcon("lasagna_image.png"));
        lasagna_meat_Image.setBounds(-80, -10, 500, 150);

        lasagna_meat_CheckBox.setBounds(135,10,20,20);

        lasagna_meat_Name.setText(" lasagna Meat ");
        lasagna_meat_Name.setBounds(160, 10, 100, 20);
        lasagna_meat_Name.setBackground(Color.white);
        lasagna_meat_Name.setOpaque(true);




        lasagna_meat_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lasagna_meat_CheckBox.isSelected()) {
                    checkBox_lasagna_meat_size_S.setEnabled(true);
                    checkBox_lasagna_meat_size_L.setEnabled(true);

                    jlabel_price_lasagna_meat_size_s.setEnabled(true);
                    jlabel_price_lasagna_meat_size_L.setEnabled(true);

                    if(checkBox_lasagna_meat_size_S.isSelected()){
                        jTextArea_lasagna_meat_size_S.setEnabled(true);
                        jTextArea_lasagna_meat_size_S.setText("");
                        jTextArea_lasagna_meat_size_S.setEditable(true);
                    }else if(!checkBox_lasagna_meat_size_S.isSelected()){
                        jTextArea_lasagna_meat_size_S.setEnabled(false);
                        jTextArea_lasagna_meat_size_S.setText("");
                        jTextArea_lasagna_meat_size_S.setEditable(false);
                    }
                    if(checkBox_lasagna_meat_size_L.isSelected()){
                        jTextArea_lasagna_meat_size_L.setEnabled(true);
                        jTextArea_lasagna_meat_size_L.setText("");
                        jTextArea_lasagna_meat_size_L.setEditable(true);
                    }else if(!checkBox_lasagna_meat_size_L.isSelected()){
                        jTextArea_lasagna_meat_size_L.setEnabled(false);
                        jTextArea_lasagna_meat_size_L.setText("");
                        jTextArea_lasagna_meat_size_L.setEditable(false);
                    }

                }else {
                    checkBox_lasagna_meat_size_S.setEnabled(false);
                    checkBox_lasagna_meat_size_L.setEnabled(false);

                    jlabel_price_lasagna_meat_size_s.setEnabled(false);
                    jlabel_price_lasagna_meat_size_L.setEnabled(false);

                    if(!lasagna_meat_CheckBox.isSelected()){
                        checkBox_lasagna_meat_size_S.setSelected(false);
                        checkBox_lasagna_meat_size_L.setSelected(false);

                        jlabel_price_lasagna_meat_size_s.setEnabled(false);
                        jlabel_price_lasagna_meat_size_L.setEnabled(false);

                        jTextArea_lasagna_meat_size_S.setText("");
                        jTextArea_lasagna_meat_size_L.setText("");

                        jTextArea_lasagna_meat_size_S.setEditable(false);
                        jTextArea_lasagna_meat_size_L.setEditable(false);

                        jTextArea_lasagna_meat_size_S.setEnabled(false);
                        jTextArea_lasagna_meat_size_L.setEnabled(false);


                        jlabel_wassl_lasagna_meat_size_s.setEnabled(false);
                        jlabel_wassl_lasagna_meat_size_L.setEnabled(false);

                        jlabel_wassl_lasagna_meat_size_s.setText(0+" IQD");
                        jlabel_wassl_lasagna_meat_size_L.setText(0+" IQD");
                    }

                }

            }
        });

        checkBox_lasagna_meat_size_S.setBounds(175,40,18,20);
        checkBox_lasagna_meat_size_S.setEnabled(false);

        jlabel_price_lasagna_meat_size_s.setText(" small 6,500 IQD");
        jlabel_price_lasagna_meat_size_s.setBounds(192, 40, 95, 20);
        jlabel_price_lasagna_meat_size_s.setBackground(Color.white);
        jlabel_price_lasagna_meat_size_s.setOpaque(true);
        jlabel_price_lasagna_meat_size_s.setEnabled(false);

        jTextArea_lasagna_meat_size_S.setBackground(Color.WHITE);
        jTextArea_lasagna_meat_size_S.setBounds(300, 40, 75, 20);
        jTextArea_lasagna_meat_size_S.setText("");
        jTextArea_lasagna_meat_size_S.setEnabled(false);

        jlabel_wassl_lasagna_meat_size_s.setBounds(390,40,80,20);
        jlabel_wassl_lasagna_meat_size_s.setBackground(Color.white);
        jlabel_wassl_lasagna_meat_size_s.setText("0 IQD");
        jlabel_wassl_lasagna_meat_size_s.setEnabled(false);
        jlabel_wassl_lasagna_meat_size_s.setOpaque(true);


        checkBox_lasagna_meat_size_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_lasagna_meat_size_S.isSelected()) {
                    jlabel_price_lasagna_meat_size_s.setEnabled(true);
                    jTextArea_lasagna_meat_size_S.setEnabled(true);
                    jlabel_wassl_lasagna_meat_size_s.setEnabled(true);
                    jTextArea_lasagna_meat_size_S.setText("");
                    jTextArea_lasagna_meat_size_S.setEditable(true);
                }else {
                    jlabel_price_lasagna_meat_size_s.setEnabled(false);
                    jTextArea_lasagna_meat_size_S.setEnabled(false);
                    jlabel_wassl_lasagna_meat_size_s.setEnabled(false);
                    jTextArea_lasagna_meat_size_S.setText("");
                    jTextArea_lasagna_meat_size_S.setEditable(false);
                    jlabel_wassl_lasagna_meat_size_s.setText(0+" IQD");
                }
            }
        });
        jTextArea_lasagna_meat_size_S.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_lasagna_meat_size_S.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_lasagna_meat_size_s.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_lasagna_meat_size_S[0] = Integer.parseInt(text);

                        value_lasagna_meat_size_S[0] = Integer.parseInt(String.valueOf(value_lasagna_meat_size_S[0]));

                        double value=(int) value_lasagna_meat_size_S[0] *6.5;
                        jlabel_wassl_lasagna_meat_size_s.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_lasagna_meat_size_S.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_lasagna_meat_size_s.setText("0 IQD");
                }



            }
        });


        checkBox_lasagna_meat_size_L.setBounds(175,70,18,20);
        checkBox_lasagna_meat_size_L.setEnabled(false);

        jlabel_price_lasagna_meat_size_L.setText(" Large 9,500 IQD");
        jlabel_price_lasagna_meat_size_L.setBounds(192, 70, 95, 20);
        jlabel_price_lasagna_meat_size_L.setBackground(Color.white);
        jlabel_price_lasagna_meat_size_L.setOpaque(true);
        jlabel_price_lasagna_meat_size_L.setEnabled(false);

        jTextArea_lasagna_meat_size_L.setBackground(Color.WHITE);
        jTextArea_lasagna_meat_size_L.setBounds(300, 70, 75, 20);
        jTextArea_lasagna_meat_size_L.setText("");
        jTextArea_lasagna_meat_size_L.setEnabled(false);


        jlabel_wassl_lasagna_meat_size_L.setBounds(390,70,80,20);
        jlabel_wassl_lasagna_meat_size_L.setBackground(Color.white);
        jlabel_wassl_lasagna_meat_size_L.setText("0 IQD");
        jlabel_wassl_lasagna_meat_size_L.setEnabled(false);
        jlabel_wassl_lasagna_meat_size_L.setOpaque(true);

        checkBox_lasagna_meat_size_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox_lasagna_meat_size_L.isSelected()) {
                    jlabel_price_lasagna_meat_size_L.setEnabled(true);
                    jTextArea_lasagna_meat_size_L.setEnabled(true);
                    jlabel_wassl_lasagna_meat_size_L.setEnabled(true);
                    jTextArea_lasagna_meat_size_L.setText("");
                    jTextArea_lasagna_meat_size_L.setEditable(true);
                }else {
                    jlabel_price_lasagna_meat_size_L.setEnabled(false);
                    jTextArea_lasagna_meat_size_L.setEnabled(false);
                    jlabel_wassl_lasagna_meat_size_L.setEnabled(false);
                    jTextArea_lasagna_meat_size_L.setText("");
                    jTextArea_lasagna_meat_size_L.setEditable(false);
                    jlabel_wassl_lasagna_meat_size_L.setText(0+" IQD");

                }
            }
        });


        jTextArea_lasagna_meat_size_L.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextArea_lasagna_meat_size_L.getText();

                if (text.matches("\\d*")) { // checks if the text only contains digits (or is empty)

                    jlabel_wassl_lasagna_meat_size_L.setText("0 IQD");
                    if (!text.isEmpty()) { // check if the text is not empty before parsing it
                        value_lasagna_meat_size_L[0] = Integer.parseInt(text);

                        value_lasagna_meat_size_L[0] = Integer.parseInt(String.valueOf(value_lasagna_meat_size_L[0]));

                        double value=(int) value_lasagna_meat_size_L[0] *9.5;
                        jlabel_wassl_lasagna_meat_size_L.setText(value+" IQD");
                        temp+=value;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextArea_lasagna_meat_size_L.setText(""); // clears the text area if invalid input is entered
                    jlabel_wassl_lasagna_meat_size_L.setText("0 IQD");
                }



            }
        });


        lasagna_panel.add(checkBox_lasagna_meat_size_S);
        lasagna_panel.add(jlabel_price_lasagna_meat_size_s);
        lasagna_panel.add(jTextArea_lasagna_meat_size_S);
        lasagna_panel.add(jlabel_wassl_lasagna_meat_size_s);

        lasagna_panel.add(checkBox_lasagna_meat_size_L);
        lasagna_panel.add(jlabel_price_lasagna_meat_size_L);
        lasagna_panel.add(jTextArea_lasagna_meat_size_L);
        lasagna_panel.add(jlabel_wassl_lasagna_meat_size_L);




        lasagna_panel.add(lasagna_meat_Name);
        lasagna_panel.add(lasagna_meat_CheckBox);
        lasagna_panel.add(lasagna_meat_Image);
        lasagna_panel.setLayout(null);
        lasagna.add(lasagna_panel);
    }


}
