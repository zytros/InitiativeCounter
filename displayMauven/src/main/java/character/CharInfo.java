package character;

import java.awt.*;

public class CharInfo {
    Image barbarian;
    Image bard;
    Image cleric;
    Image druid;
    Image fighter;
    Image monk;
    Image paladin;
    Image ranger;
    Image rogue;
    Image sorcerer;
    Image warlock;
    Image wizard;

    public CharInfo(){
        barbarian = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        bard = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        cleric = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        druid = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        fighter = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        monk = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        paladin = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        ranger = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        rogue = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        sorcerer = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        warlock = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
        wizard = Toolkit.getDefaultToolkit().getImage("resources\\barbarian_resized.jpg");
    }

    public Image getBarbarian() {
        return barbarian;
    }

    public Image getBard() {
        return bard;
    }

    public Image getCleric() {
        return cleric;
    }

    public Image getDruid() {
        return druid;
    }

    public Image getFighter() {
        return fighter;
    }

    public Image getMonk() {
        return monk;
    }

    public Image getPaladin() {
        return paladin;
    }

    public Image getRanger() {
        return ranger;
    }

    public Image getRogue() {
        return rogue;
    }

    public Image getSorcerer() {
        return sorcerer;
    }

    public Image getWarlock() {
        return warlock;
    }

    public Image getWizard() {
        return wizard;
    }
}
