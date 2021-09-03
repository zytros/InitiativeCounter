package character;


import GUI.CharPanel;

public class Character {
    private final int id;
    private int hp;
    private double initiative;
    private String name;
    public CharPanel panel;



    public Character(int id) {              // Character Constructor
        this.id = id;
        this.hp = 0;
        this.initiative = 0.0;
        this.name = "New Character";        // sets character name
        this.panel = new CharPanel(name, hp, initiative);       // creates Character Panel

    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addHp(int value){
        this.hp += value;
    }

    public void subHp(int value){
        this.hp -=value;
    }

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public void callmethod (String method, String value){
        switch (method){
            case "setName":
                this.name = value;
                panel.Name.setText(value);
                break;
            case "setInitiative":
                this.initiative = Double.parseDouble(value);
                panel.InValue.setText(value);
                break;
            case "changeHP":
                this.hp += Integer.parseInt(value);
                panel.HPValue.setText(String.valueOf(this.hp));
                break;
            default:


        }
    }


}
