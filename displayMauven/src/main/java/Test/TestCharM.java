package Test;

import charManagement.CharContainer;
import character.Character;

import java.util.ArrayList;

public class TestCharM {
    public static void main(String[] args){
        ArrayList<Character> target = new ArrayList<>();
        Character c1 = new Character(1);
        c1.setInitiative(25);
        c1.setName("c1");
        Character c2 = new Character(2);
        c2.setInitiative(15);
        c2.setName("c2");
        Character c3 = new Character(3);
        c3.setInitiative(20);
        c3.setName("c3");
        c3.isNPC(true);
        CharContainer charContainer = new CharContainer();
        System.out.println(c1);
        charContainer.add(c1);
        charContainer.add(c2);
        charContainer.add(c3);
        // charContainer.startFight();
        charContainer.getTopX(target);
        System.out.println(target);
        charContainer.next();
        charContainer.getTopX(target);
        System.out.println(target);
        charContainer.next();
        charContainer.getTopX(target);
        System.out.println(target);
    }
}
