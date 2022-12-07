import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    private ArrayList<String> charURLs = new ArrayList<>();
    private int[] maxhealth = new int[4];
    public DataLoader(String campaign){
        File file = new File("scraper/src/main/resources/" + campaign + "/characters.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String next = sc.next();
                if(next.charAt(0) == '#'){
                    continue;
                }
                /**
                 * if number add to max health, if url add to url
                 */
                int num = 0;
                boolean isNum = true;
                try {
                    num = Integer.parseInt(next);
                } catch (Exception e) {
                    isNum = false;
                    //System.out.println("failed to parse url");
                }
                if(isNum){
                    maxhealth[charURLs.size()-1] = num;
                }else{
                    charURLs.add(next);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCharURLs(){
        return charURLs;
    }

    public int[] getMaxhealth() {
        return maxhealth;
    }
}
