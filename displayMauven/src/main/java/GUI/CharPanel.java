package GUI;

import javax.swing.*;
import java.awt.*;

public class CharPanel extends JPanel {
    public JLabel Name;
    JLabel HP;
    public JLabel HPValue;
    JLabel In;
    public JLabel InValue;
    GridLayout layout = new GridLayout(3,2,20,0);


    public CharPanel(String name, int Hp, double in){
        Font kek = new Font("lel",Font.BOLD,30);
        this.setLayout(layout);
        Name = new JLabel(name);
        Name.setFont(kek);
        Name.setForeground(Color.BLACK);
        this.add(Name);
        this.add(new JLabel(""));
        HP = new JLabel("HP:");


        HP.setFont(kek);
        HP.setForeground(Color.BLACK);
        this.add(HP);
        HPValue = new JLabel(String.valueOf(Hp));
        HPValue.setFont(kek);
        HPValue.setForeground(Color.BLACK);
        this.add(HPValue);

        In = new JLabel("Initiative:");
        In.setForeground(Color.BLACK);
        In.setFont(kek);
        this.add(In);

        InValue = new JLabel(String.valueOf(in));
        InValue.setFont(kek);
        InValue.setForeground(Color.BLACK);
        this.add(InValue);
    }

}
