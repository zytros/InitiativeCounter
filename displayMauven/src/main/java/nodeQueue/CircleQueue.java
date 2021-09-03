package nodeQueue;

import character.Character;

import java.util.ArrayList;

public class CircleQueue{private Node head, current;
    public ArrayList<Character> contains;
    public int size;

    public CircleQueue () {
        this.head = new Node(null, 100.0);
        head.setNext(head);
        this.current = head;
        this.contains = new ArrayList<Character>();
        size = contains.size();
    }


    public void next() {
        current = current.getNext();
        if (current.getCharacter() == null) {       //if Node is head, jump over it
            current = current.getNext();
        }
    }

    public void add(Character character, double initiative) {
        if (character != null) {
            Node helper = head;                                     // create helper Node that finds right place
            Node welp = new Node(character, initiative);            // create Node that will be inserted

            // iterate over Nodes until right place is found
            while (initiative < helper.getNext().getInitiative() && helper.getNext() != helper) {
                helper = helper.getNext();
            }

            // set next/prev pointer to and from the Node
            if (helper.getNext() != head) {
                welp.setNext(helper.getNext());
                helper.getNext().setPrev(welp);

                helper.setNext(welp);
                welp.setPrev(helper);

            }
            else {
                welp.setNext(helper.getNext().getNext());
                helper.getNext().setPrev(welp);

                helper.setNext(welp);
                welp.setPrev(helper);
            }
            contains.add(character);
        }
    }

    public Character getCurrentC() {        // returns current character
        return current.getCharacter();
    }

    public Node getCurrentN() {             // returns current node
        return current;
    }

    public boolean contains(Character character) {      // returns true if character is in queue
        try {for (Character d : contains) {
            if (d == character) return true;
        }} catch (NullPointerException e) {}
        return false;
    }
}
