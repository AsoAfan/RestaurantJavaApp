import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
public class GUI {
    public static JFrame frame;
    public static JPanel fastFood = new JPanel();
    public static JPanel grill = new JPanel();
    public static JPanel sweet = new JPanel();
    public static JPanel Admin=new JPanel();
    public static JLabel PizzaImage_all = new JLabel();
    public static JLabel BurgerImage = new JLabel();
    public static JLabel LasagnaImage = new JLabel();
    public static JLabel potato_fingerImage = new JLabel();
    public static JLabel nugget_comboImage = new JLabel();
    public static JLabel admin_1 = new JLabel();
    GUI() throws InterruptedException, ParseException {
        frame = new JFrame("restaurant menu");
        ImageIcon Icon = new ImageIcon("II.jpg");
        frame.setBounds(-10, 0, 2190, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setExtendedState(6);
        frame.setResizable(false);
        frame.setIconImage(Icon.getImage());

        this.JTabbedPane();

        frame.setLayout((LayoutManager)null);
        frame.setVisible(true);
    }
    void JTabbedPane() throws ParseException {
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0, 0, 2000, 1070);
        tp.add("fast food", fastFood);
        //tp.add("Grill", grill);
        //tp.add("Sweet", sweet);
        tp.add("Admin",Admin);
        this.FastFood();
        this.Grill();
        this.Sweet();
        this.Admin();
        frame.add(tp);
    }
    void FastFood() {
        fastFood.setBackground(new Color(153, 0, 0));

        PizzaImage_all.setIcon(new ImageIcon("PizzaImageP.png"));
        PizzaImage_all.setBounds(30, 30, 500, 150);

        new Pizza();


        BurgerImage.setIcon(new ImageIcon("burger_Background.png"));
        BurgerImage.setBounds(30, 475, 500, 150);

        new Burger();


        LasagnaImage.setIcon(new ImageIcon("lasagna_Background.png"));
        LasagnaImage.setBounds(675, 30, 500, 150);

        new Lasagna();


        potato_fingerImage.setIcon(new ImageIcon("potato_finger.png"));
        potato_fingerImage.setBounds(675, 275, 500, 150);

        new Potato_finger();


        nugget_comboImage.setIcon(new ImageIcon("nugget_combo_background.png"));
        nugget_comboImage.setBounds(675, 450, 500, 350);

        new Combo();
        new Drink();
        new Wassl();

        fastFood.add(PizzaImage_all);
        fastFood.add(BurgerImage);
        fastFood.add(LasagnaImage);
        fastFood.add(potato_fingerImage);
        fastFood.add(nugget_comboImage);
        fastFood.setLayout((LayoutManager)null);
    }
    void Grill() {
        grill.setBackground(new Color(255,165,0));
        JLabel kababImage = new JLabel();
        kababImage.setIcon(new ImageIcon("Grill kabab.png"));
        kababImage.setBounds(30, 30, 500, 150);


        new Kebab();

        JLabel BurgerImage = new JLabel();
        BurgerImage.setIcon(new ImageIcon("burger_Background.png"));
        BurgerImage.setBounds(30, 475, 500, 150);



        Wassl w=new Wassl();

        grill.setLayout(null);
        grill.add(kababImage);
        grill.add(BurgerImage);

    }
    void Sweet() {
        this.sweet.setBackground(new Color(255,127,80));

    }
    void Admin() throws ParseException {
        Admin.setBackground(new Color(153, 0, 0));

        admin_1.setIcon(new ImageIcon("Admin1.png"));
        admin_1.setBounds(850, 30, 500, 190);

        new AdminClass();

        Admin.setLayout(null);
        Admin.add(admin_1);
    }
}