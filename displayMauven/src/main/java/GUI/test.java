package GUI;

import character.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class test extends Thread {
    public HashMap<Integer, Character> C;
    private JButton button1;
    private JPanel panel;
    private JButton button2;
    private JFrame frame;
    private int x=0;
    private int Cnext= 1;
    private int iter = 0;
    private ArrayList<CharPanel> panels = new ArrayList<>(0);


    public test(HashMap<Integer, Character> C) {
        this.C = C;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CharPanel char1 = C.get(Cnext).getPanel();
                panels.add(char1);
                char1.setBackground(Color.DARK_GRAY);
                char1.setMaximumSize(new Dimension(600, 300));
                char1.setBounds(40,80+x,500,200);
                frame.setLayout(null);
                x += 210;
                frame.add(char1);
                frame.invalidate();
                frame.validate();
                frame.repaint();
                Cnext++;

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panels.get(iter).HPValue.setText("changed");
                iter++;

            }
        });
    }

    @Override
    public void run() {
        frame = new JFrame("test");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(new java.awt.BorderLayout());

    }

    /*public static void main(String[] args) throws InterruptedException {

        frame = new JFrame("test");
        frame.setContentPane(new test().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(new java.awt.BorderLayout());
        TimeUnit.SECONDS.sleep(5);




    }*/
}
