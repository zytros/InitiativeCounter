public class WebData {
    Character character;
    String id;
    String url;
    boolean presetMaxHP;

    public WebData(int currentHP, int maxHP, String url, String id) {
        this.id = id;
        character = new Character(id, currentHP, maxHP);
        this.url = url;
        presetMaxHP = false;
    }

    public WebData(int currentHP, int maxHP, String url, String id, boolean presetMaxHP) {
        this.id = id;
        character = new Character(id, currentHP, maxHP);
        this.url = url;
        this.presetMaxHP = presetMaxHP;
    }



    public int getCurrentHP() {
        return character.getCurrentHP();
    }

    public int getMaxHP() {
        return character.getMaxHP();
    }

    public void setCurrentHP(int hp){
        if(hp<0)hp=0;
        character.setCurrentHP(hp);
    }

    public void setMaxHP(int hp){
        if (presetMaxHP){
            return;
        }
        character.setMaxHP(hp);
    }
}
