package enigma.enigmamachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс, эмулирующий сборку и функционирование "Энигмы".
 * Для сборки необходимы: роторы (3), рефлектор, коммутационная панель.
 */
public class EnigmaMachine {
    private final static String FILENAME = "enigma_code.txt";
    private FileWriter myFileWriter;
    private BufferedWriter myBufferedWriter;
    private final static int A_NUMBER = 97;
    private final static int A_NUMBER_UP = 65;
    private int lettersCounter;
    private int newLineCounter;
    //    private final static int ALPHABET_SIZE = 6;
    //    Список роторов
    private ArrayList<Rotor> rotors;
    //    Рефлектор
    private Reflector reflector;

    private final static int ALPHABET_SIZE = 26;

    private ArrayList<Plug> plugs = new ArrayList<>();

    /**
     * Сборка "Энигмы" из заданных роторов и рефлектора
     *
     * @param rotors    - Список роторов
     * @param reflector - Рефлектор
     */
    public EnigmaMachine(ArrayList<Rotor> rotors, Reflector reflector) {
//        Инициализация полей
        this.rotors = rotors;
        this.reflector = reflector;
        this.lettersCounter = 0;
        this.newLineCounter = 0;
        this.plugs = new ArrayList<>();
//        int i = 0;
//        for(Rotor rot : rotors){
//            System.out.println(i);
//            System.out.println(rot.getCurrentState());
//            System.out.println(rot.getRotorWiring());
//            i++;
//        }
    }

    public String getLetter(String inputLetter) {
        Rotor firstRotor = rotors.get(0);
        Rotor secondRotor = rotors.get(1);
        Rotor thirdRotor = rotors.get(2);

        firstRotor.rotate();
        if (firstRotor.getRotationsDone() % ALPHABET_SIZE == 0) {
            secondRotor.rotate();
            if (secondRotor.getRotationsDone() % ALPHABET_SIZE == 0) {
                thirdRotor.rotate();
            }
        }
        int firRotOut = firstRotor.getOutput((inputLetter).charAt(0) - A_NUMBER_UP);
        int secRotOut = secondRotor.getOutput(firRotOut);
        int trdRotOut = thirdRotor.getOutput(secRotOut);
        int refOut = reflector.getOutput(trdRotOut);
        int trdRotIn = thirdRotor.getInput(refOut);
        int secRotIn = secondRotor.getInput(trdRotIn);
        int firRotIn = firstRotor.getInput(secRotIn);
        System.out.println("   rot1         rot2        rot3        ref");
        for (int i = 0; i < ALPHABET_SIZE; i++) {

            System.out.print(((char) (A_NUMBER_UP + i)) + " " + (i + 1) + " - " + (firstRotor.getOutput(i) + 1));
            System.out.print("      " + (i + 1) + " - " + (secondRotor.getOutput(i) + 1));
            System.out.print("      " + (i + 1) + " - " + (thirdRotor.getOutput(i) + 1));
            System.out.print("      " + (i + 1) + " - " + (reflector.getOutput(i) + 1));
            System.out.println();
        }
        System.out.println((int) ((inputLetter).charAt(0) - A_NUMBER_UP) + 1);
        System.out.println((firRotIn) + 1);
        System.out.println((char) (firRotIn + A_NUMBER_UP));
        writeFile((char) (firRotIn + A_NUMBER_UP));
        return Character.toString((char) (firRotIn + A_NUMBER));
    }

    public void writeFile(char charToWrite) {
        try {
            myFileWriter = new FileWriter(FILENAME, true);
            myBufferedWriter = new BufferedWriter(myFileWriter);
            if(newLineCounter == 5){
                newLineCounter = 0;
                myBufferedWriter.write("\n");
            }
            if(lettersCounter == 4){
                lettersCounter = 0;
                newLineCounter++;
                myBufferedWriter.write(" ");
            }
            myBufferedWriter.write(charToWrite);
            lettersCounter++;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                myBufferedWriter.flush();
                myBufferedWriter.close();
                myFileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static int getAlphabetSize() {
        return ALPHABET_SIZE;
    }

    public void setPlugs(ArrayList<Plug> plugs){
        this.plugs = plugs;
    }
    public void addPlug(Plug plug){
        this.plugs.add(plug);
    }

    public ArrayList<Rotor> getRotors() {
        return rotors;
    }
}
