import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame extends JFrame implements ActionListener {
    JFrame frame;
    myFrame() {
        frame = new JFrame();
        frame.setTitle("CAT Inspection Tool");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);

        ImageIcon titleLogo = new ImageIcon("src/main/resources/titleLogo.png");
        frame.setIconImage(titleLogo.getImage());

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
