package gui;

import util.CharUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dmScreen {
    public JPanel dude;
    private JButton cmd_stopF;
    private JButton cmd_removeNPC;
    private JTextField txt_init;
    private JTextField txt_name;
    private JTextField txt_hp;
    private JTextField txt_maxHP;
    private JLabel lbl_maxHP;
    private JLabel lbl_hp;
    private JLabel lbl_init;
    private JLabel lbl_name;
    private JButton cmd_next;
    private JButton cmd_startF;
    private JComboBox comboBox;
    private JButton cmd_addNPC;
    CharUtil charUtil;

    public dmScreen(CharUtil charUtil) {
        this.charUtil = charUtil;


        cmd_addNPC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cmd_removeNPC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cmd_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cmd_startF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        cmd_stopF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        comboBox.setEditable(true);
    }
}
