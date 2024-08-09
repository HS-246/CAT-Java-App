import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class myFrame extends JFrame implements ActionListener {
    
    myFrame() {
        this.setTitle("CAT Inspection Tool");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1000, 600);


        ImageIcon titleLogo = new ImageIcon("src/main/resources/titleLogo.png");
        this.setIconImage(titleLogo.getImage());

        // Load the image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/titleLogo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image resizedImage = image.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizedImage);

        JPanel header = new JPanel();
        header.setBackground(Color.lightGray);
        header.setPreferredSize(new Dimension(1000,150));
        header.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel();
        headerLabel.setText("Internal Product Inspection Tool");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setIcon(icon);
        //headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(headerLabel);

        JPanel content = new JPanel();
        content.setBackground(Color.pink);
        content.setLayout(new GridLayout(0,2,0,10));// 0 rows for dynamic adding

        //Form Elements

        // HEADER
        content.add(new JLabel("Header")); // Header label
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Truck Serial Number"));
        content.add(new JTextField(20));

        content.add(new JLabel("Truck Model"));
        content.add(new JTextField(20));

        content.add(new JLabel("Inspection ID"));
        content.add(new JLabel("Auto-generated")); // Display-only, example

        content.add(new JLabel("Inspector Name"));
        content.add(new JTextField(20));

        content.add(new JLabel("Inspection Employee ID"));
        content.add(new JTextField(20));

        content.add(new JLabel("Date & Time of Inspection"));
        content.add(new JTextField(20)); // Consider using a date/time picker

        content.add(new JLabel("Location of Inspection"));
        content.add(new JTextField(20));

        content.add(new JLabel("Geo Coordinates of Inspection (optional)"));
        content.add(new JTextField(20));

        content.add(new JLabel("Service Meter Hours (Odometer reading)"));
        content.add(new JTextField(20));

        content.add(new JLabel("Inspector Signature"));
        content.add(new JTextField(20)); // Could be a signature capture component

        content.add(new JLabel("Customer Name / Company name"));
        content.add(new JTextField(20));

        content.add(new JLabel("CAT Customer ID"));
        content.add(new JTextField(20));

        // TIRES
        content.add(new JLabel("<html><b>Tires</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Tire Pressure for Left Front"));
        content.add(new JTextField(20));

        content.add(new JLabel("Tire Pressure for Right Front"));
        content.add(new JTextField(20));

        content.add(new JLabel("Tire Condition for Left Front"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Tire Condition for Right Front"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Tire Pressure for Left Rear"));
        content.add(new JTextField(20));

        content.add(new JLabel("Tire Pressure for Right Rear"));
        content.add(new JTextField(20));

        content.add(new JLabel("Tire Condition for Left Rear"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Tire Condition for Right Rear"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Overall Tire Summary"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Attached images of each tire"));
        content.add(new JButton("Attach Images"));

        // BATTERY
        content.add(new JLabel("<html><b>Battery</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Battery Make"));
        content.add(new JTextField(20));

        content.add(new JLabel("Battery Replacement Date"));
        content.add(new JTextField(20)); // Consider using a date picker

        content.add(new JLabel("Battery Voltage"));
        content.add(new JTextField(20));

        content.add(new JLabel("Battery Water Level"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Low"}));

        content.add(new JLabel("Condition of Battery (Any damage)"));
        content.add(new JCheckBox());

        content.add(new JLabel("Any Leak / Rust in Battery"));
        content.add(new JCheckBox());

        content.add(new JLabel("Battery Overall Summary"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));

        // EXTERIOR
        content.add(new JLabel("<html><b>Exterior</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Rust, Dent or Damage to Exterior"));
        content.add(new JCheckBox());

        content.add(new JLabel("Oil Leak in Suspension"));
        content.add(new JCheckBox());

        content.add(new JLabel("Overall Summary"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));

        // BRAKES
        content.add(new JLabel("<html><b>Brakes</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Brake Fluid Level"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Low"}));

        content.add(new JLabel("Brake Condition for Front"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Brake Condition for Rear"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"}));

        content.add(new JLabel("Emergency Brake"));
        content.add(new JComboBox<>(new String[]{"Good", "Ok", "Low"}));

        content.add(new JLabel("Brake Overall Summary"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));

        // ENGINE
        content.add(new JLabel("<html><b>Engine</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Rust, Dents or Damage in Engine"));
        content.add(new JCheckBox());

        content.add(new JLabel("Engine Oil Condition"));
        content.add(new JComboBox<>(new String[]{"Good", "Bad"}));

        content.add(new JLabel("Engine Oil Color"));
        content.add(new JComboBox<>(new String[]{"Clean", "Brown", "Black"}));

        content.add(new JLabel("Brake Fluid Condition"));
        content.add(new JComboBox<>(new String[]{"Good", "Bad"}));

        content.add(new JLabel("Brake Fluid Color"));
        content.add(new JComboBox<>(new String[]{"Clean", "Brown", "Black"}));

        content.add(new JLabel("Any Oil Leak in Engine"));
        content.add(new JCheckBox());

        content.add(new JLabel("Overall Summary"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));

        // Voice of Customer
        content.add(new JLabel("<html><b>Voice of Customer</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Any feedback from Customer"));
        content.add(new JTextArea(5, 20));

        content.add(new JLabel("Images related to issues discussed with customer"));
        content.add(new JButton("Attach Images"));

        content.add(new JLabel(""));
        content.add(new JButton("Submit"));


        JScrollPane formscrl = new JScrollPane(content);
        formscrl.createVerticalScrollBar();
        formscrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        this.add(header, BorderLayout.NORTH);
        this.add(formscrl, BorderLayout.CENTER);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
