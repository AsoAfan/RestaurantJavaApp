import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drink implements ActionListener {
    public static JLabel water_bottle_Image = new JLabel();
    public static JLabel coca_cola_Image=new JLabel();
    public static JLabel pepsi_Image=new JLabel();
    public static JLabel Dew_Image=new JLabel();
    public static JLabel sprite_Image=new JLabel();
    public static JLabel Fanta_Image=new JLabel();

    double temp=0.0;
    public static final int[] value_water = new int[1];
    public static final int[] value_coca_Cola = new int[1];
    public static final int[] value_pepsi = new int[1];
    public static final int[] value_dew = new int[1];
    public static final int[] value_sprite = new int[1];
    public static final int[] value_fanta = new int[1];

    public static int water_JSpinner_Value=0;
    public static JLabel water_JLable=new JLabel("0 IQD");
    public static JPanel water=new JPanel();
    public static JSpinner water_JSpinner=new JSpinner(new SpinnerNumberModel(water_JSpinner_Value, 0, 30, 1));
    public static JCheckBox water_ChakeBox=new JCheckBox("water");
    public static JLabel water_prise_JL=new JLabel();
    public static JLabel water_Name=new JLabel();

    public static JPanel cocaCola=new JPanel();
    public static JLabel coca_cola_Name=new JLabel();
    public static JLabel Coca_cola_prise_JL=new JLabel();
    public static int coca_Cola_JSpinner_Value=0;
    public static JLabel coca_Cola_JLable=new JLabel("0 IQD");
    public static JSpinner coca_Cola_JSpinner=new JSpinner(new SpinnerNumberModel(coca_Cola_JSpinner_Value, 0, 30, 1));
    public static JCheckBox cocaCola_ChakeBox=new JCheckBox(" Coca Cola");


    public static JPanel pepsi=new JPanel();
    public static JLabel pepsi_Name=new JLabel();
    public static JLabel pepsi_prise_JL=new JLabel();
    public static int pepsi_JSpinner_Value=0;
    public static JLabel pepsi_JLable=new JLabel("0 IQD");
    public static JSpinner pepsi_JSpinner=new JSpinner(new SpinnerNumberModel(pepsi_JSpinner_Value, 0, 30, 1));
    public static JCheckBox pepsi_ChakeBox=new JCheckBox(" pepsi");


    public static JPanel Dew=new JPanel();
    public static JLabel dew_Name=new JLabel();
    public static JLabel dew_prise_JL=new JLabel();
    public static int dew_JSpinner_Value=0;
    public static JLabel dew_JLable=new JLabel("0 IQD");
    public static JSpinner dew_JSpinner=new JSpinner(new SpinnerNumberModel(dew_JSpinner_Value, 0, 30, 1));
    public static JCheckBox dew_ChakeBox=new JCheckBox(" Dew");


    public static JPanel sprite=new JPanel();
    public static JLabel sprite_Name=new JLabel();
    public static JLabel sprite_prise_JL=new JLabel();
    public static int sprite_JSpinner_Value=0;
    public static JLabel sprite_JLable=new JLabel("0 IQD");
    public static JSpinner sprite_JSpinner=new JSpinner(new SpinnerNumberModel(sprite_JSpinner_Value, 0, 30, 1));
    public static JCheckBox sprite_ChakeBox=new JCheckBox(" sprite");

    public static JPanel fanta=new JPanel();
    public static JLabel fanta_Name=new JLabel();
    public static JLabel fanta_prise_JL=new JLabel();
    public static int fanta_JSpinner_Value=0;
    public static JLabel fanta_JLable=new JLabel("0 IQD");
    public static JSpinner fanta_JSpinner=new JSpinner(new SpinnerNumberModel(fanta_JSpinner_Value, 0, 30, 1));
    public static  JCheckBox fanta_ChakeBox=new JCheckBox(" fanta");

    public static JPanel drink=new JPanel();

    Drink(){
        drink.setBackground(Color.white);
        drink.setBorder(new LineBorder(Color.BLACK));
        drink.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        drink.setBounds(1375,30,525,330);

        water_bottle_Image.setIcon(new ImageIcon("water_bottle.png"));
        water_bottle_Image.setBounds(5, 5, 500, 150);
        Water();

        coca_cola_Image.setIcon(new ImageIcon("coca_cola_bottle.png"));
        coca_cola_Image.setBounds(160, 5, 150, 150);
        Coca_cola();

        pepsi_Image.setIcon(new ImageIcon("pepsi.png"));
        pepsi_Image.setBounds(320, 5, 120, 145);
        pepsi();

        Dew_Image.setIcon(new ImageIcon("dew.png"));
        Dew_Image.setBounds(5, 160, 120, 140);
        dew();

        sprite_Image.setIcon(new ImageIcon("sprite.png"));
        sprite_Image.setBounds(145, 140, 100, 170);
        sprite();

        Fanta_Image.setIcon(new ImageIcon("Fanta.png"));
        Fanta_Image.setBounds(230, 155, 200, 170);
        fanta();


        drink.add(sprite_Image);
        drink.add(Fanta_Image);
        drink.add(Dew_Image);
        drink.add(pepsi_Image);
        drink.add(coca_cola_Image);
        drink.add(water_bottle_Image);

        drink.setLayout(null);
        GUI.fastFood.add(drink);
    }
    void Water(){


        water.setBackground(new Color(153, 0,0 ));
        water.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        water.setBounds(50, 50,100 , 105);

        water_ChakeBox.setBounds(10,10,20,20);

        water_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (water_ChakeBox.isSelected()) {
                    water_JSpinner.setEnabled(true);
                    water_JLable.setEnabled(true);

                } else {
                    water_JSpinner.setEnabled(false);
                    water_JSpinner.setValue(0);
                    water_JLable.setEnabled(false);
                }
            }
        });
        water_Name.setText(" water ");
        water_Name.setBounds(30, 10, 50, 20);
        water_Name.setBackground(Color.white);
        water_Name.setOpaque(true);

        water_prise_JL.setText(" 0.250 IQD");
        water_prise_JL.setBounds(10, 30, 70, 20);
        water_prise_JL.setBackground(Color.WHITE);
        water_prise_JL.setOpaque(true);

        water_JSpinner.setBounds(10, 52, 70, 20);
        water_JSpinner.setEnabled(false);
        if ( water_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) water_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }
        water_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_water[0] = (int) water_JSpinner.getValue();
                double value2=(int) value_water[0] *0.250;
                water_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        water_JLable.setBounds(10, 75, 70, 20);
        water_JLable.setBackground(Color.WHITE);
        water_JLable.setOpaque(true);
        water_JLable.setEnabled(false);

        water.add(water_JLable);
        water.add(water_prise_JL);
        water.add(water_JSpinner);
        water.add(water_Name);
        water.add(water_ChakeBox);
        water.setLayout(null);
        drink.add(water);
    }
    void Coca_cola(){

        cocaCola.setBackground(new Color(153, 0,0 ));
        cocaCola.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        cocaCola.setBounds(200, 50,110 , 105);

        cocaCola_ChakeBox.setBounds(10,10,20,20);

        cocaCola_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cocaCola_ChakeBox.isSelected()) {
                    coca_Cola_JSpinner.setEnabled(true);
                    coca_Cola_JLable.setEnabled(true);
                } else {
                    coca_Cola_JSpinner.setEnabled(false);
                    coca_Cola_JSpinner.setValue(0);
                    coca_Cola_JLable.setEnabled(false);
                }
            }
        });


        coca_cola_Name.setText(" coca Cola ");
        coca_cola_Name.setBounds(30, 10, 70, 20);
        coca_cola_Name.setBackground(Color.white);
        coca_cola_Name.setOpaque(true);


        Coca_cola_prise_JL.setText(" 1,000 IQD");
        Coca_cola_prise_JL.setBounds(10, 30, 70, 20);
        Coca_cola_prise_JL.setBackground(Color.WHITE);
        Coca_cola_prise_JL.setOpaque(true);

        coca_Cola_JSpinner.setBounds(10, 52, 70, 20);
        coca_Cola_JSpinner.setEnabled(false);

        if ( coca_Cola_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) coca_Cola_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }


        coca_Cola_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 value_coca_Cola[0] = (int) coca_Cola_JSpinner.getValue();
                double value2=(int) value_coca_Cola[0] *1.000;
                coca_Cola_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        coca_Cola_JLable.setBounds(10, 75, 70, 20);
        coca_Cola_JLable.setBackground(Color.WHITE);
        coca_Cola_JLable.setOpaque(true);
        coca_Cola_JLable.setEnabled(false);

        cocaCola.add(coca_Cola_JLable);
        cocaCola.add(Coca_cola_prise_JL);
        cocaCola.add(coca_Cola_JSpinner);
        cocaCola.add(coca_cola_Name);
        cocaCola.add(cocaCola_ChakeBox);
        cocaCola.setLayout(null);
        drink.add(cocaCola);
    }
    void pepsi(){



        pepsi.setBackground(new Color(153, 0,0 ));
        pepsi.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        pepsi.setBounds(400, 50,100 , 105);

        pepsi_ChakeBox.setBounds(10,10,20,20);

        pepsi_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pepsi_ChakeBox.isSelected()) {
                    pepsi_JSpinner.setEnabled(true);
                    pepsi_JLable.setEnabled(true);
                } else {
                    pepsi_JSpinner.setEnabled(false);
                    pepsi_JSpinner.setValue(0);
                    pepsi_JLable.setEnabled(false);
                }
            }
        });

        pepsi_Name.setText(" pepsi ");
        pepsi_Name.setBounds(30, 10, 60, 20);
        pepsi_Name.setBackground(Color.white);
        pepsi_Name.setOpaque(true);

        pepsi_prise_JL.setText(" 0.500 IQD");
        pepsi_prise_JL.setBounds(10, 30, 70, 20);
        pepsi_prise_JL.setBackground(Color.WHITE);
        pepsi_prise_JL.setOpaque(true);

        pepsi_JSpinner.setBounds(10, 52, 70, 20);
        pepsi_JSpinner.setEnabled(false);
        if ( pepsi_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) pepsi_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }


        pepsi_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_pepsi[0] = (int) pepsi_JSpinner.getValue();
                double value2=(int) value_pepsi[0] *0.500;
                pepsi_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        pepsi_JLable.setBounds(10, 75, 70, 20);
        pepsi_JLable.setBackground(Color.WHITE);
        pepsi_JLable.setOpaque(true);
        pepsi_JLable.setEnabled(false);

        pepsi.add(pepsi_JLable);
        pepsi.add(pepsi_prise_JL);
        pepsi.add(pepsi_JSpinner);
        pepsi.add(pepsi_Name);
        pepsi.add(pepsi_ChakeBox);
        pepsi.setLayout(null);
        drink.add(pepsi);
    }
    void dew(){


        Dew.setBackground(new Color(153, 0,0 ));
        Dew.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        Dew.setBounds(50, 200,100 , 105);

        dew_ChakeBox.setBounds(10,10,20,20);

        dew_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dew_ChakeBox.isSelected()) {
                    dew_JSpinner.setEnabled(true);
                    dew_JLable.setEnabled(true);
                } else {
                    dew_JSpinner.setEnabled(false);
                    dew_JSpinner.setValue(0);
                    dew_JLable.setEnabled(false);
                }
            }
        });


        dew_Name.setText(" Dew ");
        dew_Name.setBounds(30, 10, 60, 20);
        dew_Name.setBackground(Color.white);
        dew_Name.setOpaque(true);

        dew_prise_JL.setText(" 0.500 IQD");
        dew_prise_JL.setBounds(10, 30, 70, 20);
        dew_prise_JL.setBackground(Color.WHITE);
        dew_prise_JL.setOpaque(true);

        dew_JSpinner.setBounds(10, 52, 70, 20);
        dew_JSpinner.setEnabled(false);
        if ( dew_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) dew_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }


        dew_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_dew[0] = (int) dew_JSpinner.getValue();
                double value2=(int) value_dew[0] *0.500;
                dew_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        dew_JLable.setBounds(10, 75, 70, 20);
        dew_JLable.setBackground(Color.WHITE);
        dew_JLable.setOpaque(true);
        dew_JLable.setEnabled(false);

        Dew.add(dew_JLable);
        Dew.add(dew_prise_JL);
        Dew.add(dew_JSpinner);
        Dew.add(dew_Name);
        Dew.add(dew_ChakeBox);
        Dew.setLayout(null);
        drink.add(Dew);
    }
    void sprite(){


        sprite.setBackground(new Color(153, 0,0 ));
        sprite.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        sprite.setBounds(200, 200,110 , 105);

        sprite_ChakeBox.setBounds(10,10,20,20);

        sprite_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sprite_ChakeBox.isSelected()) {
                    sprite_JSpinner.setEnabled(true);
                    sprite_JLable.setEnabled(true);
                } else {
                    sprite_JSpinner.setEnabled(false);
                    sprite_JSpinner.setValue(0);
                    sprite_JLable.setEnabled(false);
                }
            }
        });

        sprite_Name.setText(" sprite ");
        sprite_Name.setBounds(30, 10, 60, 20);
        sprite_Name.setBackground(Color.white);
        sprite_Name.setOpaque(true);

        sprite_prise_JL.setText(" 0.500 IQD");
        sprite_prise_JL.setBounds(10, 30, 70, 20);
        sprite_prise_JL.setBackground(Color.WHITE);
        sprite_prise_JL.setOpaque(true);

        sprite_JSpinner.setBounds(10, 52, 70, 20);
        sprite_JSpinner.setEnabled(false);
        if ( sprite_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) sprite_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }
        sprite_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_sprite[0] = (int) sprite_JSpinner.getValue();
                double value2=(int) value_sprite[0] *0.500;
                sprite_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });

        sprite_JLable.setBounds(10, 75, 70, 20);
        sprite_JLable.setBackground(Color.WHITE);
        sprite_JLable.setOpaque(true);
        sprite_JLable.setEnabled(false);

        sprite.add(sprite_JLable);
        sprite.add(sprite_prise_JL);
        sprite.add(sprite_JSpinner);
        sprite.add(sprite_Name);
        sprite.add(sprite_ChakeBox);
        sprite.setLayout(null);
        drink.add(sprite);
    }
    void fanta(){

        fanta.setBackground(new Color(153, 0,0 ));
        fanta.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
        fanta.setBounds(400, 200,100 , 105);


        fanta_ChakeBox.setBounds(10,10,20,20);

        fanta_ChakeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fanta_ChakeBox.isSelected()) {
                    fanta_JSpinner.setEnabled(true);
                    fanta_JLable.setEnabled(true);
                } else {
                    fanta_JSpinner.setEnabled(false);
                    fanta_JSpinner.setValue(0);
                    fanta_JLable.setEnabled(false);
                }
            }
        });

        fanta_Name.setText(" fanta ");
        fanta_Name.setBounds(30, 10, 60, 20);
        fanta_Name.setBackground(Color.white);
        fanta_Name.setOpaque(true);

        fanta_prise_JL.setText(" 0.500 IQD");
        fanta_prise_JL.setBounds(10, 30, 70, 20);
        fanta_prise_JL.setBackground(Color.WHITE);
        fanta_prise_JL.setOpaque(true);




        fanta_JSpinner.setBounds(10, 52, 70, 20);
        fanta_JSpinner.setEnabled(false);
        if ( fanta_JSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) fanta_JSpinner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }
        fanta_JSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                value_fanta[0] = (int) fanta_JSpinner.getValue();
                double value2=(int) value_fanta[0] *0.500;
                fanta_JLable.setText( value2 +" IQD");
                temp+=value2;
            }
        });


        fanta_JLable.setBounds(10, 75, 70, 20);
        fanta_JLable.setBackground(Color.WHITE);
        fanta_JLable.setOpaque(true);
        fanta_JLable.setEnabled(false);

        fanta.add(fanta_JLable);
        fanta.add(fanta_prise_JL);
        fanta.add(fanta_JSpinner);
        fanta.add(fanta_Name);
        fanta.add(fanta_ChakeBox);
        fanta.setLayout(null);
        drink.add(fanta);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
