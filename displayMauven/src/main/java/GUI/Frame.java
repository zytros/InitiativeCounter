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



        while (true) {


            for (Character d : map.values()) {
                if (!charContainer.contains(d) && d != null) charContainer.add(d); //if character is not in queue yet, add
            }

            charContainer.getTopX(topX);

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
            //try {Thread.sleep(3000);} catch (InterruptedException e) {}

        }

    }

}
