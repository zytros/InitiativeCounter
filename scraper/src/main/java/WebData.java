public class WebData {
    int currentHP;
    int maxHP;
    String url;

    public WebData(int currentHP, int maxHP, String url) {
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.url = url;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }
}
