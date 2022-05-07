package util;

public class Character {
    private int id;                               //min 100
    private String name;
    private double initiative;
    private int maxHP;
    private int hp;
    private boolean isDummy;

    public Character(int id, String name, double initiative){
        this.id = id;
        isDummy = false;
        this.name = name;
        this.initiative = initiative;
        maxHP = 100;
        hp = 100;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDummy(boolean dummy) {
        isDummy = dummy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getInitiative() {
        return initiative;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    public boolean isDummy() {
        return isDummy;
    }
}
