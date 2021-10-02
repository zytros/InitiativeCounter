package GUI;

import charManagement.CharContainer;

import nodeQueue.*;
import character.Character;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Frame extends Thread {
    private JFrame frame;
    private JPanel panel;
    private Map<Integer, Character> map;    // contains all Characters with their IDs
    private ArrayList<Character> topX;
    private Container pane;
    public CharContainer charContainer;

    public Frame(Map<Integer, Character> map) {
        this.map = map;
        this.charContainer = new CharContainer();
        topX = new ArrayList<>();
        this.create();
    }

    private void create() {


    }

    @Override
    public void run() {
        int numb = 1;
        frame = new JFrame("DnD Campaign is bonkers");
        panel = new JPanel();
        pane = frame.getContentPane();
        pane.setBackground(Color.lightGray);

        GridBagConstraints c = new GridBagConstraints();
        pane.setLayout(new GridBagLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

        CharPanel char1 = new CharPanel("DummyOne", 0, 3);
        CharPanel char2 = new CharPanel("DummyTwo", 0, 2);
        CharPanel char3 = new CharPanel("DummyThree", 0, 1);

        c.gridx = 0;
        c.gridy = 1;
        pane.add(char1, c);
        c.insets = new Insets(40, 0,0, 0);
        frame.add(char1, c);

        c.gridx = 0;
        c.gridy = 2;
        pane.add(char2, c);
        c.insets = new Insets(40, 0,0, 0);
        frame.add(char2, c);

        c.gridx = 0;
        c.gridy = 3;
        pane.add(char3, c);
        c.insets = new Insets(40, 0,0, 0);
        frame.add(char3, c);

        //frame.add(panel);

        while (true) {


            for (Character d : map.values()) {
                if (!charContainer.contains(d) && d != null) charContainer.add(d); //if character is not in queue yet, add
            }

            charContainer.getTopX(topX);

            char1 = topX.get(0).getPanel();
            char2 = topX.get(2).getPanel();
            char3 = topX.get(1).getPanel();

            /*

            for (int i = 0; i < 3; i++) {
                CharPanel working = topX.remove(0).getPanel();
                c.gridx = 0;
                c.gridy = numb;
                pane.add(working, c);
                c.insets = new Insets(40,0,0,0);
                numb++;

                //frame.setLayout(null);
                frame.add(working, c);
                //panel.invalidate();
                //panel.validate();
                //panel.repaint();
            }
            frame.add(panel);
            */

            try {Thread.sleep(3000);} catch (InterruptedException e) {}

        }

    }

}
