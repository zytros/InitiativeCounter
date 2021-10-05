package GUI;

import charManagement.CharContainer;

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

    CharPanel char1;
    CharPanel char2;
    CharPanel char3;

    public Frame(Map<Integer, Character> map) {
        this.map = map;
        this.charContainer = new CharContainer();
        topX = new ArrayList<>();
        this.create();
        /**
         * Dummy objects
         */
        char1 = new CharPanel("Dummy1", 0, 3.0);
        char2 = new CharPanel("Dummy2", 0, 2.0);
        char3 = new CharPanel("Dummy3", 0, 1.0);
    }

    private void create() {


    }

    @Override
    public void run() {
        frame = new JFrame("DnD Campaign is bonkers");
        pane = frame.getContentPane();

        /**
         * Set background image
         */
        Image img = Toolkit.getDefaultToolkit().getImage("resources\\bgimg.jpg");
        frame.setContentPane(new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });


        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        pane.setLayout(new GridBagLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);

        /**
         * Add Characters
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pane.add(char1, gridBagConstraints);
        gridBagConstraints.insets = new Insets(40, 0,0, 0);
        frame.add(char1, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pane.add(char2, gridBagConstraints);
        gridBagConstraints.insets = new Insets(40, 0,0, 0);
        frame.add(char2, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        pane.add(char3, gridBagConstraints);
        gridBagConstraints.insets = new Insets(40, 0,0, 0);
        frame.add(char3, gridBagConstraints);



        while (true) {


            for (Character d : map.values()) {
                if (!charContainer.contains(d) && d != null) charContainer.add(d); //if character is not in queue yet, add
            }

            charContainer.getTopX(topX);

            // updatePos();
            updatePoss();
/*

            for (int i = 0; i < 3; i++) {
                CharPanel working = topX.remove(0).getPanel();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = numb;
                pane.add(working, gridBagConstraints);
                gridBagConstraints.insets = new Insets(40,0,0,0);
                numb++;

                //frame.setLayout(null);
                frame.add(working, gridBagConstraints);
                //panel.invalidate();
                //panel.validate();
                //panel.repaint();
            }
            frame.add(panel);*/
            try {Thread.sleep(3000);} catch (InterruptedException e) {}

        }

    }


    //TODO: make work, does not remove old objects
    void updatePos(){
        panel.remove(char1);
        panel.remove(char2);
        panel.remove(char3);
        panel.add(topX.get(0).getPanel());
        panel.add(topX.get(1).getPanel());
        panel.add(topX.get(2).getPanel());
        panel.revalidate();
        panel.repaint();
    }

    /**
     *
     * this updates the content of the dummy characters
     *
     */

    void updatePoss(){
        char1.update(topX.get(0));
        char2.update(topX.get(1));
        char3.update(topX.get(2));
    }

}
