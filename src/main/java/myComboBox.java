import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class myComboBox<E> extends JComboBox<E> {

    // Constructor to set the font size, border, and rounded corners
    public myComboBox(E[] items) {
        super(items);
        // Set the font size to 20
        setFont(getFont().deriveFont(20f)); // Font size 20

        // Apply a rounded border
        //setBorder(new RoundedBorder(15, Color.GRAY)); // 15px radius, gray border

        // Set the renderer to apply font size to the dropdown items
        setRenderer(new CustomComboBoxRenderer<>());
    }

    // Inner class for custom renderer to apply font size to dropdown items
    private static class CustomComboBoxRenderer<E> extends JLabel implements ListCellRenderer<E> {

        public CustomComboBoxRenderer() {
            setOpaque(true);
            setFont(getFont().deriveFont(20f)); // Font size 20 for items
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value != null ? value.toString() : "");
            setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
            setForeground(isSelected ? Color.BLACK : Color.GRAY);
            return this;
        }
    }

//    // Custom border class to create a rounded border
//    static class RoundedBorder extends AbstractBorder {
//        private final int radius;
//        private final Color color;
//
//        public RoundedBorder(int radius, Color color) {
//            this.radius = radius;
//            this.color = color;
//        }
//
//        @Override
//        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//            Graphics2D g2d = (Graphics2D) g.create();
//            g2d.setColor(color);
//            g2d.setStroke(new BasicStroke(1)); // Border thickness
//            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
//            g2d.dispose();
//        }
//
//        @Override
//        public Insets getBorderInsets(Component c) {
//            return new Insets(5, 5, 5, 5); // Border insets
//        }
//    }

}
