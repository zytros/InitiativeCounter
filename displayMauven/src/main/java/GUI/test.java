package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class test {
    private JButton button1;
    private JPanel panel;
    private static JFrame frame;
    private int x=0;


    public test() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CharPanel char1 = new CharPanel("Musterman",20,12);
                char1.setBackground(Color.DARK_GRAY);
                char1.setMaximumSize(new Dimension(600, 300));
                char1.setBounds(40,80+x,500,200);
                frame.setLayout(null);
                x += 210;
                frame.add(char1);
                frame.invalidate();
                frame.validate();
                frame.repaint();

            }
        });
    }

    public  void addpanel(){



    }




    public static void main(String[] args) throws InterruptedException {
        frame = new JFrame("test");
        frame.setContentPane(new test().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(new java.awt.BorderLayout());
        TimeUnit.SECONDS.sleep(5);




    }
}
