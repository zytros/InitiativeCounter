package nodeQueue;

import character.Character;

import java.util.ArrayList;

public class CircleQueue{
    private Node head, current;
    private ArrayList<Character> contains;
    private int size;

    public CircleQueue () {
        this.head = new Node(null, 100.0);
        head.setNext(head);
        this.current = head;
        this.contains = new ArrayList<Character>();
        size = 0;
    }


    public void next() {
        current = current.getNext();
        if (current.getCharacter() == null) {       //if Node is head, jump over it
            current = current.getNext();
        }
    }

    public void add(Character character, double initiative) {
        if(character == null){
            throw new NullPointerException();                   /* TODO: define behaviour */
        }
        Node helper = head;                                     // create helper Node that finds right place
        Node newNode = new Node(character, initiative);            // create Node that will be inserted

        // iterate over Nodes until right place is found
        while (initiative > helper.getInitiative() && helper.getNext() != helper) {
            helper = helper.getNext();
        }

            // set next/prev pointer to and from the Node
        if (helper.getNext() != head) {
            newNode.setNext(helper.getNext());
            helper.getNext().setPrev(newNode);

            helper.setNext(newNode);
            newNode.setPrev(helper);

        }
        else {
            newNode.setNext(helper.getNext().getNext());
            helper.getNext().setPrev(newNode);

            helper.setNext(newNode);
            newNode.setPrev(helper);
        }
        contains.add(character);
        size++;
    }


    public Character getCurrentC() {        // returns current character
        if(current.getCharacter() == null){
            current = current.getNext();
        }
        return current.getCharacter();
    }

    public Node getCurrentN() {             // returns current node
        if(current.getCharacter() == null){
            current = current.getNext();
        }
        return current;
    }

    public boolean contains(Character character) {      // returns true if character is in queue
        return contains.contains(character);
    }

    public int getSize(){
        return size;
    }
}
