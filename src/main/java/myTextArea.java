import javax.swing.*;
import java.awt.*;

public class myTextArea extends JTextArea {

    // Constructor to set the font size, border, line wrap, and rounded corners
    public myTextArea(int rows, int columns) {
        super(rows, columns);
        // Set the font size to 20
        setFont(getFont().deriveFont(20f)); // Font size 20

        // Apply a rounded border
        setBorder(new RoundedBorder(20, Color.GRAY)); // 15px radius, gray border

        // Enable line wrapping
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    // Additional customization or methods can be added here
}
