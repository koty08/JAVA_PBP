import javax.swing.*;
import java.awt.*;

public class ProgressBarTest {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ProgressBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        add(panel, BorderLayout.PAGE_START);
        JComponent newContentPane = new ProgressBarView();
//        add(new JScrollPane(taskOutput),BorderLayout.CENTER);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
//        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.pack();
        frame.setVisible(true);
    }
}