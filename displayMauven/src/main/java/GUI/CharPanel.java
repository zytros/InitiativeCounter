package GUI;

import character.Character;
import character.HealthValues;

import javax.swing.*;
import java.awt.*;

public class CharPanel extends JPanel {
    public JLabel Name;
    JLabel HP;                  // only displays "HP:", left side
    public JLabel HPValue;      // displays value, right side
    JLabel In;                  // only displays "Initiative: ", left side
    public JLabel InValue;      // displays value, right side
    GridLayout layout = new GridLayout(3,2,20,0);
    HealthValues healthValues;

    Image img = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");

    public CharPanel(String name, int Hp, double in){
        healthValues = new HealthValues();


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

        setPreferredSize(new Dimension(500, 281));

    }

    public void update(Character character){
        Name.setText(character.getPanel().Name.getText());
        HPValue.setText(healthValues.getStatus(character.getMaxHP(), character.getHp()));
        InValue.setText(character.getPanel().InValue.getText());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}
