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
    private JPanel panel;
    private HashMap<Integer, Character> map;    // contains all Characters with their IDs
    private CircleQueue queue;                  // Circle-queue that is sorted initiative-wise
    private ArrayList<CharPanel> panelList;
    private Container pane;

    public Frame(HashMap<Integer, Character> map) {
        this.map = map;
        this.queue = new CircleQueue();
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
            panelList = new ArrayList<CharPanel>();
            for (Character d : map.values()) {
                if (!queue.contains(d) && d != null) queue.add(d, d.getInitiative()); //if character is not in queue yet, add
            }

            System.out.println(queue.size);

            // this should be done only once though
            if (queue.size > 0)panelList.add(queue.getCurrentC().panel);
            if (queue.size > 1)panelList.add(queue.getCurrentN().getNext().getCharacter().panel);
            if (queue.size > 2)panelList.add(queue.getCurrentN().getNext().getNext().getCharacter().panel);

            System.out.print("This is the amount of prepared characters:" + panelList.size());

            for (int i = 0; i < 3; i++) {
                CharPanel working = panelList.remove(0);
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
            try {Thread.sleep(300);} catch (InterruptedException e) {}

        }

    }

}
