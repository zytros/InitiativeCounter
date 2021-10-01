package character;


import GUI.CharPanel;

public class Character implements Comparable{
    private final int id;
    private int hp;
    private double initiative;
    private String name;
    private CharPanel panel;
    boolean isNPC;
    String charClass;



    public Character(int id) {              // Character Constructor
        this.id = id;
        this.hp = 0;
        this.initiative = 0.0;
        this.name = "New Character";        // sets character name
        this.panel = new CharPanel(name, hp, initiative);       // creates Character Panel
        isNPC = false;
        charClass = "";

    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
        panel.Name.setText(name);
    }

    public CharPanel getPanel(){
        return panel;
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

    public void setInitiative(String value){
        this.initiative = Double.parseDouble(value);
        panel.InValue.setText(value);
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    private void changeClass(String value){
        charClass = value;
    }

    public void callmethod (String method, String value){
        switch (method){
            case "setName":
                setName(value);
                break;
            case "setInitiative":
                setInitiative(value);
                break;
            case "changeHP":
                this.hp += Integer.parseInt(value);
                panel.HPValue.setText(String.valueOf(this.hp));
                break;
            case "setClass":
                changeClass(value);
                break;
            default:


        }
    }

    public boolean isNPC() {
        return isNPC;
    }
    public boolean isNPC(boolean a) {
        isNPC = a;
        return isNPC;
    }

    @Override
    public String toString() {
        return "Name: " + name + "| HP: " + hp + ", Initiative: " + initiative + "| ID: " + id;
    }

    @Override
    public int compareTo(Object o) {
        Character c = (Character) o;
        if(this.initiative < c.initiative){
            return 1;
        }else if(this.initiative > c.initiative){
            return -1;
        }else{
            return 0;
        }
    }
}
