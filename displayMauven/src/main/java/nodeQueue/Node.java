package nodeQueue;

import character.Character;

public class Node {
    private Character character;
    private double initiative;
    private Node next, prev;      // next node pointer

    public Node(Character character, double init) {
        this.character = character;
        this.initiative = init;
    }

    public Node getNext() {
      return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public Character getCharacter() {
        return this.character;
    }

    public double getInitiative() {
        return this.initiative;
    }

    public void setNext(Node pointer) {
        this.next = pointer;
    }

    public void setPrev(Node pointer) {
        this.prev = pointer;
    }
}
