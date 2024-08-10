import javax.swing.*;
import java.awt.*;

public class myTextField extends JTextField {

    // Constructor to set the font size, border, line wrap, and rounded corners
    public myTextField(int rows) {
        //super(rows);
        // Set the font size to 20
        setFont(getFont().deriveFont(20f)); // Font size 20

        // Apply a rounded border
        setBorder(new RoundedBorder(20, Color.GRAY)); // 15px radius, gray border
    }

    public myTextField() {

        // Set the font size to 20
        setFont(getFont().deriveFont(20f)); // Font size 20

        // Apply a rounded border
        setBorder(new RoundedBorder(20, Color.GRAY)); // 15px radius, gray border
    }

    // Additional customization or methods can be added here
}