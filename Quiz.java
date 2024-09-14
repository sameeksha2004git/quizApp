import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[40][5];
    String answers[][] = new String[40][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    int[] questionIndices;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Add 40 questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "What is the purpose of the finally block in Java?";
        questions[2][1] = "To handle exceptions";
        questions[2][2] = "To declare variables";
        questions[2][3] = "To define a method";
        questions[2][4] = "To implement an interface";

        questions[3][0] = "What is the default value of a local variable in Java?";
        questions[3][1] = "0";
        questions[3][2] = "null";
        questions[3][3] = "Not initialized";
        questions[3][4] = "Depends on the data type";

        questions[4][0] = "What is the purpose of the break statement in Java?";
        questions[4][1] = "To exit a loop";
        questions[4][2] = "To skip a loop iteration";
        questions[4][3] = "To exit a switch statement";
        questions[4][4] = "To exit a method";

        questions[5][0] = "What is the purpose of the continue statement in Java?";
        questions[5][1] = "To exit a loop";
        questions[5][2] = "To skip a loop iteration";
        questions[5][3] = "To exit a switch statement";
        questions[5][4] = "To exit a method";

        questions[6][0] = "What is the purpose of the return statement in Java?";
        questions[6][1] = "To exit a method";
        questions[6][2] = "To exit a loop";
        questions[6][3] = "To skip a loop iteration";
        questions[6][4] = "To exit a switch statement";

        questions[7][0] = "What is the purpose of the throw statement in Java?";
        questions[7][1] = "To throw an exception";
        questions[7][2] = "To catch an exception";
        questions[7][3] = "To handle an exception";
        questions[7][4] = "To declare an exception";

        questions[8][0] = "What is the purpose of the throws statement in Java?";
        questions[8][1] = "To throw an exception";
        questions[8][2] = "To catch an exception";
        questions[8][3] = "To handle an exception";
        questions[8][4] = "To declare an exception";

        questions[9][0] = "What is the purpose of the try-catch block in Java?";
        questions[9][1] = "To handle exceptions";
        questions[9][2] = "To declare variables";
        questions[9][3] = "To define a method";
        questions[9][4] = "To implement an interface";

        questions[10][0] = "What is the purpose of the finally block in Java?";
        questions[10][1] = "To handle exceptions";
        questions[10][2] = "To declare variables";
        questions[10][3] = "To define a method";
        questions[10][4] = "To implement an interface";

        questions[11][0] = "What is the default value of a instance variable in Java?";
        questions[11][1] = "0";
        questions[11][2] = "null";
        questions[11][3] = "Not initialized";
        questions[11][4] = "Depends on the data type";

        questions[12][0] = "What is the purpose of the static keyword in Java?";
        questions[12][1] = "To declare a static variable";
        questions[12][2] = "To declare a static method";
        questions[12][3] = "To declare a static class";
        questions[12][4] = "To declare a static interface";

        questions[13][0] = "What is the purpose of the final keyword in Java?";
        questions[13][1] = "To declare a final variable";
        questions[13][2] = "To declare a final method";
        questions[13][3] = "To declare a final class";
        questions[13][4] = "To declare a final interface";

        questions[14][0] = "What is the purpose of the abstract keyword in Java?";
        questions[14][1] = "To declare an abstract class";
        questions[14][2] = "To declare an abstract method";
        questions[14][3] = "To declare an abstract interface";
        questions[14][4] = "To declare an abstract variable";

        questions[15][0] = "What is the purpose of the interface keyword in Java?";
        questions[15][1] = "To declare an interface";
        questions[15][2] = "To declare an abstract class";
        questions[15][3] = " To declare an abstract method";
        questions[15][4] = "To declare an abstract variable";

        questions[16][0] = "What is the purpose of the extends keyword in Java?";
        questions[16][1] = "To inherit a class";
        questions[16][2] = "To implement an interface";
        questions[16][3] = "To declare a variable";
        questions[16][4] = "To declare a method";

        questions[17][0] = "What is the purpose of the implements keyword in Java?";
        questions[17][1] = "To implement an interface";
        questions[17][2] = "To inherit a class";
        questions[17][3] = "To declare a variable";
        questions[17][4] = "To declare a method";

        questions[18][0] = "What is the purpose of the this keyword in Java?";
        questions[18][1] = "To refer to the current object";
        questions[18][2] = "To refer to the parent object";
        questions[18][3] = "To refer to the child object";
        questions[18][4] = "To refer to the sibling object";

        questions[19][0] = "What is the purpose of the super keyword in Java?";
        questions[19][1] = "To refer to the parent object";
        questions[19][2] = "To refer to the current object";
        questions[19][3] = "To refer to the child object";
        questions[19][4] = "To refer to the sibling object";

        questions[20][0] = "What is the purpose of the instanceof keyword in Java?";
        questions[20][1] = "To check if an object is an instance of a class";
        questions[20][2] = "To check if an object is an instance of an interface";
        questions[20][3] = "To check if an object is an instance of an array";
        questions[20][4] = "To check if an object is an instance of a primitive type";

        questions[21][0] = "What is the purpose of the new keyword in Java?";
        questions[21][1] = "To create a new object";
        questions[21][2] = "To create a new array";
        questions[21][3] = "To create a new class";
        questions[21][4] = "To create a new interface";

        questions[22][0] = "What is the purpose of the null keyword in Java?";
        questions[22][1] = "To represent a null value";
        questions[22][2] = "To represent a default value";
        questions[22][3] = "To represent a primitive value";
        questions[22][4] = "To represent a reference value";

        questions[23][0] = "What is the purpose of the true keyword in Java?";
        questions[23][1] = "To represent a true boolean value";
        questions[23][2] = "To represent a false boolean value";
        questions[23][3] = "To represent a null boolean value";
        questions[23][4] = "To represent a default boolean value";

        questions[24][0] = "What is the purpose of the false keyword in Java?";
        questions[24][1] = "To represent a false boolean value";
        questions[24][2] = "To represent a true boolean value";
        questions[24][3] = "To represent a null boolean value";
        questions[24][4] = "To represent a default boolean value";

        questions[25][0] = "What is the purpose of the boolean keyword in Java?";
        questions[25][1] = "To declare a boolean variable";
        questions[25][2] = "To declare a boolean method";
        questions[25][3] = "To declare a boolean class";
        questions[25][4] = "To declare a boolean interface";

        questions[26][0] = "What is the purpose of the byte keyword in Java?";
        questions[26][1] = "To declare a byte variable";
        questions[26][2] = "To declare a byte method";
        questions[26][3] = "To declare a byte class";
        questions[26][4] = "To declare a byte interface";

        questions[27][0] = "What is the purpose of the short keyword in Java?";
        questions[27][1] = "To declare a short variable";
        questions[27][2] = "To declare a short method";
        questions[27][3] = "To declare a short class";
        questions[27][4] = "To declare a short interface";

        questions[28][0] = "What is the purpose of the int keyword in Java?";
        questions[28][1] = "To declare an int variable";
        questions[28][2] = "To declare an int method";
        questions[28][3] = "To declare an int class";
        questions[28][4] = "To declare an int interface";

        questions[29][0] = "What is the purpose of the long keyword in Java?";
        questions[29][1] = "To declare a long variable";
        questions[29][2] = "To declare a long method";
        questions[29][3] = "To declare a long class";
        questions[29][4] = "To declare a long interface";

        questions[30][0] = "What is the purpose of the float keyword in Java?";
        questions[30][1] = "To declare a float variable";
        questions[30][2] = "To declare a float method";
        questions[30][3] = "To declare a float class";
        questions[30][4] = "To declare a float interface";

        questions[31][0] = "What is the purpose of the double keyword in Java?";
        questions[31][1] = "To declare a double variable";
        questions[31][2] = "To declare a double method";
        questions[31][3] = "To declare a double class";
        questions[31][4] = "To declare a double interface";

        questions[32][0] = "What is the purpose of the char keyword in Java?";
        questions[32][1] = "To declare a char variable";
        questions[32][2] = "To declare a char method";
        questions[32][3] = "To declare a char class";
        questions[32][4] = "To declare a char interface";

        questions[33][0] = "What is the purpose of the String keyword in Java?";
        questions[33][1] = "To declare a String variable";
        questions[33][2] = "To declare a String method";
        questions[33][3] = "To declare a String class";
        questions[33][4] = "To declare a String interface";

        questions[34][0] = "What is the purpose of the array keyword in Java?";
        questions[34][1] = "To declare an array variable";
        questions[34][2] = "To declare an array method";
        questions[34][3] = "To declare an array class";
        questions[34][4] = "To declare an array interface";

        questions[35][0] = "What is the purpose of the enum keyword in Java?";
        questions[35][1] = "To declare an enum variable";
        questions[35][2] = "To declare an enum method";
        questions[35][3] = "To declare an enum class";
        questions[35][4] = "To declare an enum interface";

        questions[36][0] = "What is the purpose of the abstract keyword in Java?";
        questions[36][1] = "To declare an abstract class";
        questions[36][2] = "To declare an abstract method";
        questions[36][3] = "To declare an abstract interface";
        questions[36][4] = "To declare an abstract variable";

        questions[37][0] = "What is the purpose of the synchronized keyword in Java?";
        questions[37][1] = "To synchronize a method";
        questions[37][2] = "To synchronize a block";
        questions[37][3] = "To synchronize a class";
        questions[37][4] = "To synchronize an interface";

        questions[38][0] = "What is the purpose of the volatile keyword in Java?";
        questions[38][1] = "To declare a volatile variable";
        questions[38][2] = "To declare a volatile method";
        questions[38][3] = "To declare a volatile class";
        questions[38][4] = "To declare a volatile interface";

        questions[39][0] = "What is the purpose of the transient keyword in Java?";
        questions[39][1] = "To declare a transient variable";
        questions[39][2] = "To declare a transient method";
        questions[39][3] = "To declare a transient class";
        questions[39][4] = "To declare a transient interface";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "To handle exceptions";
        answers[3][1] = "Not initialized";
        answers[4][1] = "To exit a loop";
        answers[5][1] = "To skip a loop iteration";
        answers[6][1] = "To exit a method";
        answers[7][1] = "To throw an exception";
        answers[8][1] = "To declare an exception";
        answers[9][1] = "To handle exceptions";
        answers[10][1] = "To handle exceptions";
        answers[11][1] = "Depends on the data type";
        answers[12][1] = "To declare a static variable";
        answers[13][1] = "To declare a final variable";
        answers[14][1] = "To declare an abstract class";
        answers[15][1] = "To declare an interface";
        answers[16][1] = "To inherit a class";
        answers[17][1] = "To implement an interface";
        answers[18][1] = "To refer to the current object";
        answers[19][1] = "To refer to the parent object";
        answers[20][1] = "To check if an object is an instance of a class";
        answers[21][1] = "To create a new object";
        answers[22][1] = "To represent a null value";
        answers[23][1] = "To represent a true boolean value";
        answers[24][1] = "To represent a false boolean value";
        answers[25][1] = "To declare a boolean variable";
        answers[26][1] = "To declare a byte variable";
        answers[27][1] = "To declare a short variable";
        answers[28][1] = "To declare an int variable";
        answers[29][1] = "To declare a long variable";
        answers[30][1] = "To declare a float variable";
        answers[31][1] = "To declare a double variable";
        answers[32][1] = "To declare a char variable";
        answers[33][1] = "To declare a String variable";
        answers[34][1] = "To declare an array variable";
        answers[35][1] = "To declare an enum variable";
        answers[36][1] = "To declare an abstract class";
        answers[37][1] = "To synchronize a method";
        answers[38][1] = "To declare a volatile variable";
        answers[39][1] = "To declare a transient variable";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        questionIndices = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index;
            do {
                index = random.nextInt(questions.length);
            } while (contains(questionIndices, index));
            questionIndices[i] = index;
        }

        start(0);

        setVisible(true);
    }

    private boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[questionIndices[i]][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[questionIndices[i]][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[questionIndices[count]][0]);
        opt1.setText(questions[questionIndices[count]][1]);
        opt1.setActionCommand(questions[questionIndices[count]][1]);

        opt2.setText(questions[questionIndices[count]][2]);
        opt2.setActionCommand(questions[questionIndices[count]][2]);

        opt3.setText(questions[questionIndices[count]][3]);
        opt3.setActionCommand(questions[questionIndices[count]][3]);

        opt4.setText(questions[questionIndices[count]][4]);
        opt4.setActionCommand(questions[questionIndices[count]][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}