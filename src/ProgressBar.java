import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
public class ProgressBar {
    public JFrame Pframe;
    public JProgressBar progressBar;
    public JLabel lblNewLabel;
    public static JPanel panel = new JPanel();
    public static JPanel panel_1 = new JPanel();
    public static JLabel lblMgFinance = new JLabel("Welcome to the program");
    public ProgressBar() throws InterruptedException {
        initialize();
    }
    private void initialize() {
        Pframe = new JFrame();
        Pframe.setBounds(100, 100, 450, 300);
        Pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Pframe.getContentPane().setLayout(null);

        panel.setBounds(0, 0, 2500, 705);
        Pframe.getContentPane().add(panel);
        panel.setLayout(null);

        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(250, 646, 1362, 59);
        panel.add(panel_1);
        panel_1.setLayout(null);

        lblNewLabel = new JLabel("Loading...");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(625, 0, 144, 34);
        panel_1.add(lblNewLabel);

        progressBar = new JProgressBar();
        progressBar.setBackground(new Color(0, 51, 51));
        progressBar.setBounds(0, 34, 1362, 14);
        panel_1.add(progressBar);

        lblMgFinance.setHorizontalAlignment(SwingConstants.CENTER);
        lblMgFinance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        lblMgFinance.setForeground(Color.red);
        lblMgFinance.setBounds(225, 11, 1362, 635);
        panel.add(lblMgFinance);

        Pframe.setVisible(true);
    }

}