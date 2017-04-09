package enigma.enigmamachine;

public class Plug {
    private int head;
    private int tail;
    private final static int A_NUMBER_UP = 65;
    public Plug(Character first, Character second){
        head = (int)first - A_NUMBER_UP;
        tail = (int)second - A_NUMBER_UP;
        System.out.println(head);
        System.out.println(tail);

    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
