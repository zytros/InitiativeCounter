package character;

public class Character {
    private final int id;
    private int hp;
    private int initiative;
    private String name;

    public Character(int id) {
        this.id = id;
        this.name = "New Character";
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


}