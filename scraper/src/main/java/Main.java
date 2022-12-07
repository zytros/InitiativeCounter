import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File conf = new File("scraper/src/main/resources/config.txt");
        Json json = new Json();
        Scanner scanner = new Scanner(conf);
        String campaign = scanner.next();
        DataLoader loader = new DataLoader(campaign);
        ArrayList<String> urls = loader.getCharURLs();
        int[] maxHealth = loader.getMaxhealth();
        ArrayList<WebData> characters = new ArrayList<>();
        DnDBAPI dnDBAPI = new DnDBAPI();
        int n = 0;
        for(String url : urls){
            if(maxHealth[n] != 0){
                characters.add(new WebData(0,maxHealth[n], url, Integer.toString(n), true));
            }else{
                characters.add(new WebData(0,maxHealth[n], url, Integer.toString(n)));
            }

            n++;
        }

        while(true){
            dnDBAPI.getData(characters);

            Character[] charArray = new Character[4];
            for(int i = 0; i < 4; i++){
                charArray[i] = characters.get(i).character;
            }

            String jsonstr = json.toJson(charArray);
            String callstr = "POST%1pw%1" + jsonstr;
            String response = null;
            String host = "localhost";
            int port = 55239;
            Socket client = new Socket(host,port);
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(callstr);

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            response = inputStream.readUTF();
            client.close();



            System.out.println(response);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
