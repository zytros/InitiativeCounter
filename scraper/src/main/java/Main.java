import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataLoader loader = new DataLoader("campaign");
        WebSim webSim = new WebSim();
        ArrayList<String> urls = loader.getCharURLs();
        ArrayList<WebData> characters = new ArrayList<>();
        for(String url : urls){
            characters.add(new WebData(0,0,url));
        }

        while(true){
            webSim.getData(characters);
            for(WebData d : characters){
                System.out.println("current HP: " + d.currentHP);
                System.out.println("maximum HP: " + d.maxHP);
                System.out.println("--------------");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void testWebSim(){
        WebSim webSim = new WebSim();
        System.out.println("hehe");
    }

    public static void testDataLoader(){
        DataLoader loader = new DataLoader("campaign");
        ArrayList list = loader.getCharURLs();
    }
}
