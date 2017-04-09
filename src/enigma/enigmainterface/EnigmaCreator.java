package enigma.enigmainterface;

import enigma.enigmamachine.EnigmaMachine;
import enigma.enigmamachine.Plugboard;
import enigma.enigmamachine.Reflector;
import enigma.enigmamachine.Rotor;

import java.util.ArrayList;

public class EnigmaCreator {
    final static private int SEED_1 = 3;
    final static private int SEED_2 = 4;
    final static private int SEED_3 = 5;
    private EnigmaMachine enigma;
    public EnigmaCreator (){
//        Список роторов
        ArrayList<Rotor> rotors = new ArrayList<>();
//        Создание и добавление в список роторов трёх роторов
        Rotor firstRotor = new Rotor(SEED_1);
        rotors.add(firstRotor);
        Rotor secondRotor = new Rotor(SEED_2);
        rotors.add(secondRotor);
        Rotor thirdRotor = new Rotor(SEED_3);
        rotors.add(thirdRotor);
//        Создание рефлектора
        Reflector reflector = new Reflector(6);

        Plugboard plugboard = new Plugboard();
//        Создание машины "Энигма" с созданными роторами и рефлектором
        enigma = new EnigmaMachine(rotors, reflector);
    }

    public EnigmaMachine getEnigma() {
        return enigma;
    }
}
