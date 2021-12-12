import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseTest {
    public static void main(String [] args){
        createAndShowGUI();
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("HW13");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new SwingView();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}

class SwingView extends JPanel{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextArea textArea;
    private PlayerRepository repository = new PlayerRepository();

    public SwingView(){
        super(new BorderLayout());
        button1 = new JButton("검색");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(repository.findAll().toString());
            }
        });
        button2 = new JButton("생성");
        JTextField textField1 = new JTextField(30);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player();
                Club club = new Club();
                Country country = new Country();
                club.setName("PNU");
                country.setName("BUSAN");
                player.setClub(club);
                player.setNationality(country);
                club.getPlayers().add(player);
                country.getPlayers().add(player);

                String[] parse_str = textField1.getText().split(" ");
                player.setName(parse_str[0]);
                player.setHeight(Integer.parseInt(parse_str[1]));
                player.setOverall(Integer.parseInt(parse_str[2]));
                player.setPositions(parse_str[3]);
                repository.save(player);
            }
        });
        button3 = new JButton("삭제");
        JTextField textField2 = new JTextField(5);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField2.getText());
                repository.deleteById(id);
            }
        });
        textArea = new JTextArea(5, 30);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel label = new JLabel("생성시 이름/키/overall/포지션 순으로 띄어쓰기 하여 입력.");
        panel1.add(label); panel1.add(button1);
        panel2.add(textField1); panel2.add(button2);
        panel3.add(textField2); panel3.add(button3);
        panel.add(panel1); panel.add(panel2); panel.add(panel3);
        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
    }
}
