package GUI;

import communication.SharedQueue;

import nodeQueue.*;
import character.Character;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Frame extends Thread {
    private JFrame frame;
    private JPanel panel = new JPanel();
    private HashMap<Integer, Character> map;    // contains all Characters with their IDs
    private CircleQueue queue;                  // Circle-queue that is sorted initiative-wise
    private ArrayList<CharPanel> panelList;

    public Frame(HashMap<Integer, Character> map) {
        this.map = map;
        this.queue = new CircleQueue();
        this.create();
    }

    private void create() {


    }

    @Override
    public void run() {
        frame = new JFrame("DnD Campaign is bonkers");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,800));
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(new java.awt.BorderLayout());

        while (true) {
            panelList = new ArrayList<CharPanel>();
            for (Character d : map.values()) {
                if (!queue.contains(d) && d != null) queue.add(d, d.getInitiative()); //if character is not in queue yet, add
            }

            // this should be done only once though
            if (queue.size > 0)panelList.add(queue.getCurrentC().panel);
            if (queue.size > 1)panelList.add(queue.getCurrentN().getNext().getCharacter().panel);
            if (queue.size > 2)panelList.add(queue.getCurrentN().getNext().getNext().getCharacter().panel);

            for (int i = 0; i < 3; i++) {
                CharPanel working = panelList.remove(0);
                working.setBackground(Color.DARK_GRAY);
                working.setMaximumSize(new Dimension(600, 300));
                working.setBounds(40,80+(i*210),500,200);

                frame.setLayout(null);
                frame.add(working);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }

            try {Thread.sleep(300);} catch (InterruptedException e) {}

        }

    }

}
