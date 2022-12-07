import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class APIThread extends Thread{
    WebData webData;
    public APIThread(WebData webData){
        this.webData = webData;
    }


    @Override
    public void run() {
        HttpURLConnection connection = null;
        String json = null;
        try{
            URL url = new URL(webData.url);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            json = response.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JSONCharacter jsonCharacter = null;
        try {
            jsonCharacter = objectMapper.readValue(json, JSONCharacter.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap data = (LinkedHashMap) jsonCharacter.details.get("data");
        int removedHP = (int) data.get("removedHitPoints");
        int baseHP = (int) data.get("baseHitPoints");
        ArrayList stats = (ArrayList) data.get("stats");
        LinkedHashMap consScore = (LinkedHashMap) stats.get(2);
        int constitution = (int) consScore.get("value");
        LinkedHashMap racemap = (LinkedHashMap) data.get("race");
        String race = (String) racemap.get("baseRaceName");
        int level = 0;
        ArrayList classes = (ArrayList) data.get("classes");
        for(Object a : classes){
            LinkedHashMap cast = (LinkedHashMap) a;
            int classlevel = (int) cast.get("level");
            level += classlevel;
        }
        boolean isTough = false;
        ArrayList feats = (ArrayList) data.get("feats");
        for(Object a : feats){
            LinkedHashMap cast = (LinkedHashMap) a;
            LinkedHashMap definition = (LinkedHashMap) cast.get("definition");
            int id = (int) definition.get("id");
            if(id == 49){
                isTough = true;
            }
        }
        int toughHP = 0, dwarfHP = 0;
        if(isTough){
            toughHP = level * 2;
        }if(race.equals("Dwarf")){
            dwarfHP = level;
        }
        int maxHP = baseHP + toughHP + dwarfHP + ((constitution - 10) / 2) * level;
        int currentHP = maxHP - removedHP;
        webData.setMaxHP(maxHP);
        webData.setCurrentHP(currentHP);
    }
}
