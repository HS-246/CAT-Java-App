import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;


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


        //Content Panel

        // Create a NumberFormat instance for integers
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setMinimum(0);
        numberFormatter.setAllowsInvalid(false); // Prevents invalid input


        JPanel content = new JPanel();
        content.setBackground(Color.pink);
        content.setLayout(new GridLayout(0,2,0,10));// 0 rows for dynamic adding

        //Form Elements

        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 20));

        // HEADER
        content.add(new JLabel("Header")); // Header label
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Truck Serial Number"));
        JTextField truckSerialNumber = new JTextField();
        content.add(truckSerialNumber);

        content.add(new JLabel("Truck Model"));
        JTextField truckModel = new JTextField();
        content.add(truckModel);

        content.add(new JLabel("Inspection ID"));
        content.add(new JLabel("Auto-generated after upload")); // Display-only

        content.add(new JLabel("Inspector Name"));
        JTextField inspectorName= new JTextField();
        content.add(inspectorName);

        content.add(new JLabel("Inspection Employee ID"));
        JFormattedTextField empID = new JFormattedTextField(numberFormatter);
        content.add(empID);

        content.add(new JLabel("Date & Time of Inspection"));
        Date date= new Date();
        content.add(new JLabel(date.toString())); // Consider using a date/time picker

        content.add(new JLabel("Location of Inspection"));
        JTextField location = new JTextField();
        content.add(location);

        content.add(new JLabel("Geo Coordinates of Inspection (optional)"));
        JTextField coordinates = new JTextField();
        content.add(coordinates);

        content.add(new JLabel("Service Meter Hours (Odometer reading)"));
        JFormattedTextField odometerReading = new JFormattedTextField(numberFormatter);
        content.add(odometerReading);

        content.add(new JLabel("Inspector Signature [TODO: SIGNATURE CAPTURE]"));
        content.add(new JTextField(20)); //TODO: Could be a signature capture component

        content.add(new JLabel("Customer Name / Company name"));
        JTextField customerName = new JTextField();
        content.add(customerName);

        content.add(new JLabel("CAT Customer ID"));
        JTextField customerID = new JTextField();
        content.add(customerID);

        // TIRES
        content.add(new JLabel("<html><b>Tires</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Tire Pressure for Left Front"));
        JFormattedTextField tirePressureLF = new JFormattedTextField(numberFormatter);
        content.add(tirePressureLF);

        content.add(new JLabel("Tire Pressure for Right Front"));
        JFormattedTextField tirePressureRF = new JFormattedTextField(numberFormatter);
        content.add(tirePressureRF);

        content.add(new JLabel("Tire Condition for Left Front"));
        JComboBox<String> tireConditionLF = new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionLF);

        content.add(new JLabel("Tire Condition for Right Front"));
        JComboBox<String> tireConditionRF = new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionRF);

        content.add(new JLabel("Tire Pressure for Left Rear"));
        JFormattedTextField tirePressureLR = new JFormattedTextField(numberFormatter);
        content.add(tirePressureLR);

        content.add(new JLabel("Tire Pressure for Right Rear"));
        JFormattedTextField tirePressureRR = new JFormattedTextField(numberFormatter);
        content.add(tirePressureRR);

        content.add(new JLabel("Tire Condition for Left Rear"));
        JComboBox<String> tireConditionLR = new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionLR);

        content.add(new JLabel("Tire Condition for Right Rear"));
        JComboBox<String> tireConditionRR = new JComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionRR);

        content.add(new JLabel("Overall Tire Summary"));
        JTextArea tireSummary = new JTextArea(5,200);
        content.add(tireSummary);

        content.add(new JLabel("Attached images of each tire"));
        content.add(new JButton("Attach Images"));//TODO: Add Image Uploading

        // BATTERY
        content.add(new JLabel("<html><b>Battery</b></html>")); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Battery Make"));
        JTextField batteryMake = new JTextField();
        content.add(batteryMake);

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
