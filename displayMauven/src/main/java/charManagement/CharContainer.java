package charManagement;

import character.Character;

import java.util.ArrayList;
import java.util.Collections;

public class CharContainer {
    ArrayList<Character> entities = new ArrayList<>();
    ArrayList<Character> npc = new ArrayList<>();
    int top = 0;
    private final int showTop = 3; // show top x characters on display
    private Character dummy = new Character(Integer.MAX_VALUE);
    private boolean isFighting = false;

    public CharContainer(){
        dummy.setName("Dummy");
        dummy.setInitiative(-10);
    }

    public synchronized void add(Character character){
        if(character.isNPC()){
            npc.add(character);
        }else {
            entities.add(character);
        }
    }

    public synchronized void removeNPC(){
        entities.removeAll(npc);
    }

    public synchronized void startFight(){       //TODO: check for existance of top x

        if(entities.size() + npc.size() < showTop){
            for(int i = 0; i < (showTop - (entities.size() + npc.size())); i++){
                npc.add(dummy);
            }
        }
        top = 0;
        isFighting = true;
        entities.addAll(npc);
        Collections.sort(entities);
    }

    public void endFight(){
        removeNPC();
        isFighting = false;
    }

    public synchronized void getTopX(ArrayList<Character> target){
        target.clear();
        int size = entities.size();
        for(int i = 0; i < showTop; i++){
            target.add(entities.get((top + i)%size));
        }
    }

    public synchronized void next(){
        if(!isFighting){
            return;
        }
        top = ++top % entities.size();
    }

    public synchronized boolean contains(Character character){
        return entities.contains(character) || npc.contains(character);
    }
}
