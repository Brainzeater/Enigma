package enigma.enigmamachine;

import java.text.DecimalFormat;

/**
 * Класс, эмулирующий коммутационную панель
 */
public class Plugboard {
    private final static int ALPHABET_SIZE = 26;
    private int[] connections;

    public Plugboard() {
        this.connections = new int[ALPHABET_SIZE];
        for (int i = 0; i < connections.length; i++) {
            connections[i] = i;
        }
    }

    public void setPlug(Plug plug) {
        connections[plug.getHead()] = plug.getTail();
        connections[plug.getTail()] = plug.getHead();
    }

    @Override
    public String toString() {
        String toPrint = new String();

        for(int i = 0; i < connections.length; i++){
            toPrint+=(i + " - " + connections[i]);
        }
        return toPrint;
    }

}
