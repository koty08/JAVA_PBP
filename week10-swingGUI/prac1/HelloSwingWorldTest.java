import javax.swing.*;

public class HelloSwingWorldTest {
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        System.out.println(Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println(Thread.currentThread().getName());
        //Create and set up the window.
        JFrame frame = new HelloSwingWorldView();
        frame.setTitle("HelloSwingWorldView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }
}
