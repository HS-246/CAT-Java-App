import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class myFormattedTextField extends JFormattedTextField {

    // Constructor to set the font size, border, line wrap, and rounded corners
    public myFormattedTextField(NumberFormatter formatter) {
        super(formatter);
        // Set the font size to 20
        setFont(getFont().deriveFont(20f)); // Font size 20

        // Apply a rounded border
        setBorder(new RoundedBorder(20, Color.GRAY)); // 15px radius, gray border
    }

    // Additional customization or methods can be added here
}
