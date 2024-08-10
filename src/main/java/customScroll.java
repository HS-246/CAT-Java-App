import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class customScroll {
//    public static void main(String[] args) {
//        // Create a JFrame
//        JFrame frame = new JFrame("Custom ScrollBar Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//
//        // Create a JTextArea (or any component)
//        JTextArea textArea = new JTextArea(20, 30);
//        for (int i = 1; i <= 50; i++) {
//            textArea.append("Line " + i + "\n");
//        }
//
//        // Wrap the JTextArea in a JScrollPane
//        JScrollPane scrollPane = new JScrollPane(textArea);
//
//        // Create a custom scroll bar
//        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
//        verticalScrollBar.setUI(new CustomScrollBarUI());
//
//        // Add the JScrollPane to the JFrame
//        frame.add(scrollPane, BorderLayout.CENTER);
//
//        // Set the frame to be visible
//        frame.setVisible(true);
//    }

    // Custom ScrollBarUI class
    static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(255, 196, 0); // Color of the scroll thumb
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(new Color(0,0,0,(float)0.6)); // Color of the track
            g.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height,10,10);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            g.setColor(thumbColor);
            g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
        }
    }
}
