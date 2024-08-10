import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    //are variables as instance variables

        myTextField truckSerialNumber;
        myTextField truckModel;
        myTextField inspectorName;
        myFormattedTextField empID;
        Date date;
        myTextField location;
        myTextField coordinates;
        myFormattedTextField odometerReading;
        myTextField customerName;
        myTextField customerID;
        myFormattedTextField tirePressureLF;
        myFormattedTextField tirePressureRF;
        myComboBox<String> tireConditionLF;
        myComboBox<String> tireConditionRF;
        myFormattedTextField tirePressureLR;
        myFormattedTextField tirePressureRR;
        myComboBox<String> tireConditionLR;
        myComboBox<String> tireConditionRR;
        myTextArea tireSummary;
        myTextField batteryMake;
        myTextField batteryReplacementDate;
        myFormattedTextField batteryVoltage;
        myComboBox<String> batteryWater;
        myComboBox<String> batteryCondition;
        myComboBox<String> batteryLeakRust;
        myTextArea batterySummary;
        myComboBox<String> exteriorDamage;
        myComboBox<String> oilLeak;
        myTextArea exteriorSummary;
        myComboBox<String> brakeFluidLevel;
        myComboBox<String> brakeFront;
        myComboBox<String> brakeRear;
        myComboBox<String> emergencyBrake;
        myTextArea brakeSummary;
        myComboBox<String> engineDamage;
        myComboBox<String> engineOil;
        myComboBox<String> engineOilColor;
        myComboBox<String> brakeFluidCondition;
        myComboBox<String> brakeFluidColor;
        myComboBox<String> engineOilLeak;
        myTextArea engineSummary;
        myTextArea customerFeedback;


    myFrame() {
        this.setTitle("CAT Inspection Tool");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1100, 650);

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
        header.setPreferredSize(new Dimension(950, 150));
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
        numberFormatter.setAllowsInvalid(true);
        numberFormatter.setCommitsOnValidEdit(true);// Prevents invalid input

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.setPreferredSize(new Dimension(1100,5000));
        content.setBorder(new EmptyBorder(0, 10, 0, 10));
        content.setLayout(new GridLayout(0, 2, -10, 10));// 0 rows for dynamic adding

        //Form Elements

        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 20));

        // HEADER
        content.add(new JLabel("Header", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }}); // Header label
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Truck Serial Number"));
        truckSerialNumber = new myTextField();
        content.add(truckSerialNumber);

        content.add(new JLabel("Truck Model"));
        truckModel = new myTextField();
        content.add(truckModel);

        content.add(new JLabel("Inspection ID"));
        content.add(new JLabel("Auto-generated after upload")); // Display-only

        content.add(new JLabel("Inspector Name"));
        inspectorName = new myTextField();
        content.add(inspectorName);

        content.add(new JLabel("Inspection Employee ID"));
        empID = new myFormattedTextField(numberFormatter);
        content.add(empID);

        content.add(new JLabel("Date & Time of Inspection"));
        date = new Date();
        content.add(new JLabel(date.toString())); // Consider using a date/time picker

        content.add(new JLabel("Location of Inspection"));
        location = new myTextField();
        content.add(location);

        content.add(new JLabel("Geo Coordinates of Inspection (optional)"));
        coordinates = new myTextField();
        content.add(coordinates);

        content.add(new JLabel("Service Meter Hours (Odometer reading)"));
        odometerReading = new myFormattedTextField(numberFormatter);
        content.add(odometerReading);

        content.add(new JLabel("Inspector Signature [TODO: SIGNATURE CAPTURE]"));
        content.add(new myTextField(20)); //TODO: Could be a signature capture component

        content.add(new JLabel("Customer Name / Company name"));
        customerName = new myTextField();
        content.add(customerName);

        content.add(new JLabel("CAT Customer ID"));
        customerID = new myTextField();
        content.add(customerID);

        // TIRES
        content.add(new JLabel("1.Tires", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }}); // Sub-header
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Tire Pressure for Left Front"));
        tirePressureLF = new myFormattedTextField(numberFormatter);
        content.add(tirePressureLF);

        content.add(new JLabel("Tire Pressure for Right Front"));
        tirePressureRF = new myFormattedTextField(numberFormatter);
        content.add(tirePressureRF);

        content.add(new JLabel("Tire Condition for Left Front"));
        tireConditionLF = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionLF);

        content.add(new JLabel("Tire Condition for Right Front"));
        tireConditionRF = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionRF);

        content.add(new JLabel("Tire Pressure for Left Rear"));
        tirePressureLR = new myFormattedTextField(numberFormatter);
        content.add(tirePressureLR);

        content.add(new JLabel("Tire Pressure for Right Rear"));
        tirePressureRR = new myFormattedTextField(numberFormatter);
        content.add(tirePressureRR);

        content.add(new JLabel("Tire Condition for Left Rear"));
        tireConditionLR = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionLR);

        content.add(new JLabel("Tire Condition for Right Rear"));
        tireConditionRR = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(tireConditionRR);

        content.add(new JLabel("Overall Tire Summary"));
        tireSummary = new myTextArea(3, 20);
        content.add(tireSummary);

        content.add(new JLabel("Attached images of each tire"));
        content.add(new JButton("Attach Images"));//TODO: Add Image Uploading

        // BATTERY
        content.add(new JLabel("2.Battery", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }});
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Battery Make"));
        batteryMake = new myTextField();
        content.add(batteryMake);

        content.add(new JLabel("Battery Replacement Date (DD/MM/YYYY)"));
        batteryReplacementDate = new myTextField(10);
        content.add(batteryReplacementDate);

        content.add(new JLabel("Battery Voltage"));
        batteryVoltage = new myFormattedTextField(numberFormatter);
        content.add(batteryVoltage);

        content.add(new JLabel("Battery Water Level"));
        batteryWater = new myComboBox<>(new String[]{"Good", "Ok", "Low"});
        content.add(batteryWater);

        content.add(new JLabel("Condition of Battery (Any damage)"));
        batteryCondition = new myComboBox<>(new String[]{"Yes", "No"});
        content.add(batteryCondition);

        content.add(new JLabel("Any Leak / Rust in Battery"));
        batteryLeakRust = new myComboBox<>(new String[]{"Yes", "No"});
        content.add(batteryLeakRust);

        content.add(new JLabel("Battery Overall Summary"));
        batterySummary = new myTextArea(3, 20);
        content.add(batterySummary);

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));//TODO: attaching images

        // EXTERIOR
        content.add(new JLabel("3.Exterior", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }});
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Exterior Damage"));
        exteriorDamage = new myComboBox<>(new String[]{"Good", "Ok", "Needs Repair"});
        content.add(exteriorDamage);

        content.add(new JLabel("Any Oil Leaks (if any)"));
        oilLeak = new myComboBox<>(new String[]{"Yes", "No"});
        content.add(oilLeak);

        content.add(new JLabel("Exterior Overall Summary"));
        exteriorSummary = new myTextArea(3, 20);
        content.add(exteriorSummary);

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));//TODO: Image attachment

        // BRAKES
        content.add(new JLabel("4.Brakes", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }});
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Brake Fluid Level"));
        brakeFluidLevel = new myComboBox<>(new String[]{"Good", "Ok", "Low"});
        content.add(brakeFluidLevel);

        content.add(new JLabel("Brake Front Condition"));
        brakeFront = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(brakeFront);

        content.add(new JLabel("Brake Rear Condition"));
        brakeRear = new myComboBox<>(new String[]{"Good", "Ok", "Needs Replacement"});
        content.add(brakeRear);

        content.add(new JLabel("Emergency Brake "));
        emergencyBrake = new myComboBox<>(new String[]{"Good", "Ok", "Low"});
        content.add(emergencyBrake);

        content.add(new JLabel("Overall Brake Summary"));
        brakeSummary = new myTextArea(3, 20);
        content.add(brakeSummary);

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));//TODO: Image attachment

        // ENGINE
        content.add(new JLabel("5.Engine", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }});
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Rust, Dents or Engine Damage"));
        engineDamage = new myComboBox<>(new String[]{"Yes, Explain in notes","No"});
        content.add(engineDamage);

        content.add(new JLabel("Engine Oil Condition"));
        engineOil = new myComboBox<>(new String[]{"Good", "Bad"});
        content.add(engineOil);

        content.add(new JLabel("Engine Oil Color"));
        engineOilColor = new myComboBox<>(new String[]{"Clean","Brown", "Black"});
        content.add(engineOilColor);

        content.add(new JLabel("Brake Fluid Condition"));
        brakeFluidCondition = new myComboBox<>(new String[]{"Good", "Bad"});
        content.add(brakeFluidCondition);

        content.add(new JLabel("Brake Fluid Color"));
        brakeFluidColor = new myComboBox<>(new String[]{"Clear", "Brown", "Black"});
        content.add(brakeFluidColor);

        content.add(new JLabel("ANy Oil Leak in Engine"));
        engineOilLeak = new myComboBox<>(new String[]{"Yes", "No"});
        content.add(engineOilLeak);

        content.add(new JLabel("Overall Engine Summary"));
        engineSummary = new myTextArea(3, 20);
        content.add(engineSummary);

        content.add(new JLabel("Attached images"));
        content.add(new JButton("Attach Images"));//TODO: attach images

        // CUSTOMER FEEDBACK
        content.add(new JLabel("Customer Feedback", SwingConstants.CENTER) {{
            setFont(getFont().deriveFont(Font.BOLD, 24f));
        }});
        content.add(new JLabel("")); // Empty cell to fill space

        content.add(new JLabel("Customer Feedback"));
        customerFeedback = new myTextArea(5, 20);
        content.add(customerFeedback);

        content.add(new JLabel("Images related to issues discussed with customer"));
        content.add(new JButton("Attach Images"));//TODO: attach images

        //Scroll Pane
        JScrollPane formscrl = new JScrollPane(content);

        JScrollBar verticalScrollBar = formscrl.getVerticalScrollBar();
        verticalScrollBar.setUI(new customScroll.CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(15);

        formscrl.createVerticalScrollBar();
        formscrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        formscrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);




        // Footer Panel
        JPanel footer = new JPanel();
        footer.setBackground(Color.lightGray);
        footer.setPreferredSize(new Dimension(950, 50));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        footer.add(submitButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        footer.add(resetButton);


        // Combine the panels
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(formscrl, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Submit":
                // TODO:Implement submit logic here
                break;
            case "Reset":
                // TODO:Implement reset logic here
                break;
            default:
        }
    }
}
