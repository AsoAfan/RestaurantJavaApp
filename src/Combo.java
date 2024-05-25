import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Combo {
    double temp=0;
    public static final int[] value_jSpinner_combo1 = new int[1];
    public static int combo1_value=0;
    public static JSpinner jSpinner_combo1=new JSpinner(new SpinnerNumberModel(combo1_value, 0, 11, 1));
    public static JLabel jLabel_price_combo1=new JLabel(" 0 IQD");
    public static JLabel combo1_Image = new JLabel();
    public static JPanel combo1 =new JPanel();
    public static JCheckBox combo1_CheckBox=new JCheckBox("combo1_CheckBox");
    public static JLabel combo1_Name=new JLabel();
    public static JLabel jTextArea_structure_combo1=new JLabel("<html>1 One BBQ chicken Burger" +
            "<br>1 KFC Potato<br>" +
            "1 Drink On your request</html>");


    public static JLabel combo2_Name=new JLabel();
    public static JLabel combo2_Image = new JLabel();
    public static JPanel combo2 =new JPanel();

    public static final int[] value_jSpinner_combo2 = new int[1];
    public static JSpinner jSpinner_combo2=new JSpinner(new SpinnerNumberModel(combo1_value, 0, 11, 1));
    public static JLabel jLabel_price_combo2=new JLabel(" 0 IQD");
    public static JCheckBox combo2_CheckBox=new JCheckBox();
    public static JLabel jTextArea_structure_combo2=new JLabel("<html>3 One BBQ chicken Burger" +
            "<br>2 KFCPotato<br>" +
            "3 Drink On your request" +
            "<br>5 Kentucky<br></html>");

    public static ArrayList<String> drinks;

    public static JComboBox<String> jcomboBox_drinkList;

    public static JLabel jlale_drinkPhoto;

    public static ArrayList<String> drinks2;

    public static JComboBox<String> jcomboBox_drinkList2;

    public static JLabel jlale_drinkPhoto2;

    public static JPanel Combo =new JPanel();

    Combo(){

        Combo.setBackground(Color.white);
        Combo.setBorder(new LineBorder(Color.BLACK));
        Combo.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        Combo.setBounds(800,550,550,410);

        combo1();
        combo2();


        Combo.setLayout(null);
        GUI.fastFood.add(Combo);

    }

    void combo1(){


        combo1.setBounds(20, 20, 510,170 );
        combo1.setBackground(new Color(153, 0,0 ));
        combo1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

        combo1_Image.setIcon(new ImageIcon("combo1.png"));
        combo1_Image.setBounds(-30, -10, 500, 190);

        combo1_CheckBox.setBounds(135,10,20,20);


        combo1_Name.setText(" Offer 1  7,500 IQD ");
        combo1_Name.setBounds(160, 10, 110, 20);
        combo1_Name.setBackground(Color.white);
        combo1_Name.setOpaque(true);


        jTextArea_structure_combo1.setBounds(210, 40, 160, 50);
        jTextArea_structure_combo1.setBackground(Color.WHITE);
        jTextArea_structure_combo1.setOpaque(true);
        jTextArea_structure_combo1.setEnabled(false);


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        drinks = new ArrayList<>();

        jcomboBox_drinkList= new JComboBox<String>();


        jlale_drinkPhoto= new JLabel(new ImageIcon("white.jpg"));

        drinks.add("select one");
        drinks.add("Coca Cola");
        drinks.add("Pepsi");
        drinks.add("Sprite");
        drinks.add("Dew");
        drinks.add("Fanta");

        for (String item : drinks) {
            jcomboBox_drinkList.addItem(item);
        }

        jcomboBox_drinkList.setBounds(400,40,100,20);
        jcomboBox_drinkList.setEnabled(false);


        jlale_drinkPhoto.setBounds(400,70,90,90);
        jlale_drinkPhoto.setEnabled(false);

        jcomboBox_drinkList.addActionListener(e -> {
            String selectedDrink = (String) jcomboBox_drinkList.getSelectedItem();

            switch (selectedDrink) {
                case "select one" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("white.jpg"));
                    jlale_drinkPhoto.setSize(90, 90);
                }
                case "Coca Cola" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("coca_cola_bottle2.png"));
                    jlale_drinkPhoto.setLocation(400, 70);
                }
                case "Pepsi" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("pepsi2.jpg"));
                    jlale_drinkPhoto.setLocation(400, 70);
                }
                case "Sprite" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("sprite2.jpg"));
                    jlale_drinkPhoto.setLocation(400, 70);
                }
                case "Dew" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("Dew2.jpg"));
                    jlale_drinkPhoto.setLocation(400, 70);
                }
                case "Fanta" -> {
                    jlale_drinkPhoto.setIcon(new ImageIcon("Fanta2.jpg"));
                    jlale_drinkPhoto.setLocation(400, 70);
                }
            }
        });

        combo1_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo1_CheckBox.isSelected()){
                    jTextArea_structure_combo1.setEnabled(true);
                    jcomboBox_drinkList.setEnabled(true);
                    //jcomboBox_drinkList.setEditable(true);
                    jlale_drinkPhoto.setEnabled(true);
                    jSpinner_combo1.setEnabled(true);
                    jLabel_price_combo1.setEnabled(true);
                }else {
                    jTextArea_structure_combo1.setEnabled(false);
                    //jcomboBox_drinkList.setEditable(false);
                    jcomboBox_drinkList.setEnabled(false);

                    jlale_drinkPhoto.setEnabled(false);
                    jlale_drinkPhoto.setIcon(new ImageIcon("white.jpg"));

                    jSpinner_combo1.setEnabled(false);
                    jLabel_price_combo1.setEnabled(false);
                    jLabel_price_combo1.setText(" 0 IQD");
                    jcomboBox_drinkList.setSelectedItem("select one");
                    jSpinner_combo1.setValue(0);

                }
            }
        });

        jSpinner_combo1.setBounds(210,100 , 80, 20);
        jSpinner_combo1.setBackground(Color.WHITE);
        jSpinner_combo1.setEnabled( false );
        if ( jSpinner_combo1.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) jSpinner_combo1.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }


        jLabel_price_combo1.setBounds(210, 130, 80, 20);
        jLabel_price_combo1.setBackground(Color.WHITE);
        jLabel_price_combo1.setOpaque(true);
        jLabel_price_combo1.setEnabled(false);


        jSpinner_combo1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) jSpinner_combo1.getValue(); // get the current value of the JSpinner
                if (value > 10) {
                    JOptionPane.showMessageDialog(null, "Maximum value is 10.", "Error", JOptionPane.ERROR_MESSAGE); // display error message
                    jSpinner_combo1.setValue(10); // set the value of the JSpinner to the maximum value if user enters a value greater than 30

                }

            }
        });

        jSpinner_combo1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_jSpinner_combo1[0] = (int) jSpinner_combo1.getValue();
                double value2=(int) value_jSpinner_combo1[0] *7.5;
                jLabel_price_combo1.setText( value2 +" IQD");
                temp+=value2;
            }
        });


        combo1.add(jLabel_price_combo1);
        combo1.add(jSpinner_combo1);
        combo1.add(jTextArea_structure_combo1);
        combo1.add(jcomboBox_drinkList);
        combo1.add(jlale_drinkPhoto);
        combo1.add(combo1_Name);
        combo1.add(combo1_CheckBox);
        combo1.add(combo1_Image);
        combo1.setLayout(null);
        Combo.add(combo1);
    }
    void combo2(){

        combo2.setBounds(20, 210, 510,170 );
        combo2.setBackground(new Color(153, 0,0 ));
        combo2.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));


        combo2_Image.setIcon(new ImageIcon("combo2.png"));
        combo2_Image.setBounds(-30, -10, 500, 190);


        combo2_CheckBox.setBounds(135,10,20,20);

        combo2_Name.setText(" Offer 2  23,000 IQD ");
        combo2_Name.setBounds(160, 10, 115, 20);
        combo2_Name.setBackground(Color.white);
        combo2_Name.setOpaque(true);



        jTextArea_structure_combo2.setBounds(210, 35, 160, 70);
        jTextArea_structure_combo2.setBackground(Color.WHITE);
        jTextArea_structure_combo2.setOpaque(true);
        jTextArea_structure_combo2.setEnabled(false);

        drinks2 = new ArrayList<>();
        drinks2.add("select one");
        drinks2.add("Coca Cola");
        drinks2.add("Pepsi");
        drinks2.add("Sprite");
        drinks2.add("Dew");
        drinks2.add("Fanta");

        jcomboBox_drinkList2= new JComboBox<>(drinks.toArray(new String[0]));
        jcomboBox_drinkList2.setBounds(400,40,100,20);
        jcomboBox_drinkList2.setEnabled(false);

        jlale_drinkPhoto2= new JLabel(new ImageIcon("white.jpg"));
        jlale_drinkPhoto2.setBounds(400,70,90,90);
        jlale_drinkPhoto2.setEnabled(false);

        jcomboBox_drinkList2.addActionListener(e -> {
            String selectedDrink = (String) jcomboBox_drinkList2.getSelectedItem();

            switch (selectedDrink) {
                case "select one" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("white.jpg"));
                    jlale_drinkPhoto2.setSize(90, 90);
                }
                case "Coca Cola" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("coca_cola_bottle2.png"));
                    jlale_drinkPhoto2.setLocation(400, 70);
                }
                case "Pepsi" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("pepsi2.jpg"));
                    jlale_drinkPhoto2.setLocation(400, 70);
                }
                case "Sprite" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("sprite2.jpg"));
                    jlale_drinkPhoto2.setLocation(400, 70);
                }
                case "Dew" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("Dew2.jpg"));
                    jlale_drinkPhoto2.setLocation(400, 70);
                }
                case "Fanta" -> {
                    jlale_drinkPhoto2.setIcon(new ImageIcon("Fanta2.jpg"));
                    jlale_drinkPhoto2.setLocation(400, 70);
                }
            }
        });

        combo2_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo2_CheckBox.isSelected()){
                    jTextArea_structure_combo2.setEnabled(true);
                    jcomboBox_drinkList2.setEnabled(true);
                    jlale_drinkPhoto2.setEnabled(true);
                    jSpinner_combo2.setEnabled(true);
                    jLabel_price_combo2.setEnabled(true);
                }else {
                    jTextArea_structure_combo2.setEnabled(false);
                    jcomboBox_drinkList2.setEnabled(false);
                    jlale_drinkPhoto2.setEnabled(false);
                    jlale_drinkPhoto2.setIcon(new ImageIcon("white.jpg"));
                    jSpinner_combo2.setEnabled(false);
                    jLabel_price_combo2.setEnabled(false);
                    jLabel_price_combo2.setText(" 0 IQD");
                    jcomboBox_drinkList.setSelectedItem("select one");
                    jSpinner_combo2.setValue(0);
                }
            }
        });

        jSpinner_combo2.setBounds(210,113 , 80, 20);
        jSpinner_combo2.setBackground(Color.WHITE);
        jSpinner_combo2.setEnabled( false );
        if ( jSpinner_combo2.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) jSpinner_combo2.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }

        jLabel_price_combo2.setBounds(210, 140, 80, 20);
        jLabel_price_combo2.setBackground(Color.WHITE);
        jLabel_price_combo2.setOpaque(true);
        jLabel_price_combo2.setEnabled(false);

        jSpinner_combo2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) jSpinner_combo2.getValue(); // get the current value of the JSpinner
                if (value > 10) {
                    JOptionPane.showMessageDialog(null, "Maximum value is 10.", "Error", JOptionPane.ERROR_MESSAGE); // display error message
                    jSpinner_combo2.setValue(10); // set the value of the JSpinner to the maximum value if user enters a value greater than 30
                }
            }
        });

        jSpinner_combo2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 value_jSpinner_combo2[0] = (int) jSpinner_combo2.getValue();
                double value2=(int) value_jSpinner_combo2[0] *23;
                jLabel_price_combo2.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        combo2.add(jLabel_price_combo2);
        combo2.add(jSpinner_combo2);
        combo2.add(jTextArea_structure_combo2);
        combo2.add(jcomboBox_drinkList2);
        combo2.add(jlale_drinkPhoto2);

        combo2.add(combo2_Name);
        combo2.add(combo2_CheckBox);
        combo2.add(combo2_Image);
        combo2.setLayout(null);
        Combo.add(combo2);
    }




}
