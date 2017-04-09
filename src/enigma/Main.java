package enigma;

import enigma.enigmainterface.Interface;
import enigma.enigmamachine.EnigmaMachine;
import enigma.enigmamachine.Reflector;
import enigma.enigmamachine.Rotor;

import java.util.ArrayList;

/**
 * Начало программы
 */
public class Main {
//    Константы для неслучайной генерации "проводных" соединений роторов
    final static private int SEED_1 = 3;
    final static private int SEED_2 = 4;
    final static private int SEED_3 = 5;
    public static void main(String[] args){
//        TestBench tB = new TestBench();
//        tB.start();
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
//        Создание машины "Энигма" с созданными роторами и рефлектором
        EnigmaMachine enigma = new EnigmaMachine(rotors, reflector);
//        Запуск "Энигмы"
//        enigma.start();
        Interface myInterface = new Interface();

        myInterface.launch(Interface.class, args);
/*Настроить правильное переключение роторов - один за другим. Ротор необязательно переключает соседний
* в следующее положение в состоянии 0 - состояние переключение может быть задано (случайно?), но переключение
* происходит каждые ALPHABET_SIZE*/
        /*Добавить коммутационную панель*/
        /*Разработать интерфейс*/
    }
}
