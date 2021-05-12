package character;


import GUI.CharPanel;

public class Character {
    private final int id;
    private int hp;
    private int initiative;
    private String name;
    public CharPanel panel;



    public Character(int id) {
        this.id = id;
        this.name = "New Character";
        this.panel = new CharPanel(name,0,0);

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

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void callmethod (String method, String value){
        switch (method){
            case "setName":
                this.name = value;
                panel.Name.setText(value);
                break;
            case "setInitiative":
                this.initiative = Integer.parseInt(value);
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
