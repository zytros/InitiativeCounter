import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    private ArrayList<String> charURLs = new ArrayList<>();

    public DataLoader(String campaign){
        File file = new File("scraper/src/main/resources/" + campaign + "/characters.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String next = sc.next();
                if(next.charAt(0) == '#'){
                    continue;
                }
                charURLs.add(next);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCharURLs(){
        return charURLs;
    }
}
