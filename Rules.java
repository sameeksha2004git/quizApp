import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;
    JCheckBox acceptRules;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>" +
                        "1. Each question has a time limit of 15 seconds."
                        + "<br><br>" +
                        "2. 10 questions will be randomly selected from a pool of 40 questions related to Java programming."
                        + "<br><br>" +
                        "3. You can select only one answer for each question."
                        + "<br><br>" +
                        "4. You have a 50-50 lifeline that can be used once during the quiz." + "<br><br>" +
                        "5. You can submit your answers at any time during the quiz. Once you submit, you cannot go back and change your answers."
                        + "<br><br>" +
                        "6. Each correct answer is worth 10 points. If you answer a question incorrectly, you will not lose any points."
                        + "<br><br>" +
                        "7. The quiz will end after you have answered all 10 questions or when you submit your answers."
                        + "<br><br>" +
                        "8. Your final score will be displayed at the end of the quiz." + "<br><br>" +
                        "9. Please ensure that you have a stable internet connection before starting the quiz."
                        + "<br><br>" +
                        "10. Do not close the quiz window or refresh the page during the quiz."
                        + "<br><br>" +
                        "11. Do not use any external resources or references during the quiz."
                        + "<br><br>" +
                        "12. The quiz is designed to test your knowledge of Java programming concepts. Please answer the questions to the best of your ability."
                        + "<br><br>" +
                        "By starting the quiz, you acknowledge that you have read and understood these rules. Good luck!"
                        + "</html>");

        JScrollPane scrollPane = new JScrollPane(rules);
        scrollPane.setBounds(20, 90, 700, 350);
        add(scrollPane);

        acceptRules = new JCheckBox("I accept the rules");
        acceptRules.setBounds(250, 450, 200, 30);
        add(acceptRules);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        start.setEnabled(false); // disable start button initially
        add(start);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        acceptRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (acceptRules.isSelected()) {
                    start.setEnabled(true); // enable start button when checkbox is checked
                } else {
                    start.setEnabled(false); // disable start button when checkbox is unchecked
                }
            }
        });

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}