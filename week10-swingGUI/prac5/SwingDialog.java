import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SwingDialog extends JDialog implements ActionListener, PropertyChangeListener {
    private String magicWord;
    private JTextField textField;
    private JOptionPane optionPane;
    private String typedText;

    public SwingDialog(String word){
        this.magicWord = word.toUpperCase();
        setTitle("Quiz");
        textField = new JTextField(10);
        Font font = new Font("Serif", Font.PLAIN, 24);
        textField.setFont(font);
        String msgString1 = "What was Dr.SEUSS's real last name?";
        String msgString2 = "(The answer is \"" + word + "\".)";
        Object[] array = {msgString1, msgString2, textField};
        Object[] options = {"Enter", "Cancel"};
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);
        optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, options, options[0]);
        setContentPane(optionPane);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                optionPane.setValue(new IntTypeData(JOptionPane.CLOSED_OPTION));
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });

        textField.addActionListener(this);
        optionPane.addPropertyChangeListener(this);
        pack();
    }
    public void clearAndHide(){
        textField.setText(null);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        optionPane.setValue("Enter");
    }

    public void propertyChange(PropertyChangeEvent e){
        String prop = e.getPropertyName();
        if(isVisible() && (e.getSource() == optionPane) && (JOptionPane.VALUE_PROPERTY.equals(prop) || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();
            if(value == JOptionPane.UNINITIALIZED_VALUE)
                return;
            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
            if("Enter".equals(value)){
                typedText = textField.getText();
                String ucText = typedText.toUpperCase();
                if(magicWord.equals(ucText)){
                    clearAndHide();
                }
                else{
                    textField.selectAll();
                    JOptionPane.showMessageDialog(SwingDialog.this, "Sorry, \""+ typedText + "\" " + "isn't a valid response.\n" + "Please enter " + magicWord + ".", "Try again", JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else{
                typedText=null;
                clearAndHide();
            }
        }
    }
}
