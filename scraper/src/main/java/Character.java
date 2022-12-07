public class Character {
    private int id;
    private String name;
    private int currentHP;
    private int maxHP;

    public Character(String name, int currentHP, int maxHP) {
        this.name = name;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        id = Integer.parseInt(name);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }


    @Override
    public String toString() {
        String s = "{\n";
        s += "\"name\": \"" + name + "\",\n";
        s += "\"currentHP\": \"" + currentHP + "\",\n";
        s += "\"maxHP\": \"" + maxHP + "\"\n";
        s +="}";
        return s;
    }
}
