package enigma.enigmamachine;

import enigma.enigmainterface.EnigmaCreator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

/**
 * Класс, эмулирующий функционирование ротора.
 * Случайное число - случайное подключение входов ротора к его выходам.
 */
public class Rotor {
    //    Размер ротора = количество входов = количество выходов =
//      = количество букв в используемом алфавите
    private static final int ROTOR_SIZE = 26;
    //    Текущее положение ротора - по номеру
    private int currentState;
    //    Случайное число, отвечающее за случайное подключение
    private int wiringSeed;
    //    Массив подключения ротора - номер выхода для каждого из входов
//    Номера входа - номер выхода в массиве
    private int[] rotorWiring;
    //    Номера входов ротора - от 1 до ROTOR_SIZE
    private int[] input;

    private int initialState;

    private int rotationsDone;

    /**
     * Создание ротора - подключение проводов внутри ротора (входов к выходам)
     *
     * @param wiringSeed - случайное число, отвечающее за генерацию подключения
     */
    public Rotor(int wiringSeed) {
//        Инициализация массива входов номеров
        this.input = new int[ROTOR_SIZE];
        for (int i = 0; i < ROTOR_SIZE; i++) {
            input[i] = i;
        }
//        Инициализация случайного числа
        this.wiringSeed = wiringSeed;
//        Установка соединений в роторе
        setRotorWiring();

//        Установка начального состояния ротора
//        setInitialState(0);
    }

    public String getRotorWiring() {
        return printArray(rotorWiring);
    }

    public int getCurrentState() {
        return currentState;
    }

    /**
     * Получить номер выхода для заданного входа
     *
     * @param input - номер входа
     * @return выход, к которому подключён вход
     */
    public int getOutput(int input) {
        return rotorWiring[input];
    }

    /**
     * Рассчитать массив номеров входов ротора по его выходам
     *
     * @return массив номеров входов ротора
     */
    private int[] viceVersaWiring() {
        int[] viceVersa = new int[ROTOR_SIZE];
        for (int i = 0; i < ROTOR_SIZE; i++) {
            for (int j = 0; j < ROTOR_SIZE; j++) {
                if (rotorWiring[j] == i) {
                    viceVersa[i] = j;
                }
            }
        }
        return viceVersa;
    }

    public int getInput(int output) {
        int[] viceVersa = viceVersaWiring();
        return viceVersa[output];
    }

    /**
     * Задаёт начальное положение ротора по номеру
     *
     * @param initialState - номер начального положения. Значение от 0 до ROTOR_SIZE
     */
    public void setInitialState(int initialState) {
        if (initialState >= 0 && initialState < ROTOR_SIZE) {
            this.initialState = initialState;
//            Изначально ротор создаётся в положении 01.
//            initialState можно воспринимать как количество поворотов ротора
//            до требуемого положения.
            for (int i = 0; i < initialState-1; i++) {
                this.rotate();
            }
            rotationsDone = 0;
        } else {
            System.out.println("Rotor failed: Wrong initial value");
        }
    }

    /**
     * Вращает ротор
     */
    public void rotate() {
//        Вращение ротора:
//        Номер выхода последнего входа становится первым,
//        а остальные номера поочерёдно сдвигаются в массиве на одну позицию.
        int last = rotorWiring[ROTOR_SIZE - 1];
        for (int i = ROTOR_SIZE - 1; i > 0; i--) {
            rotorWiring[i] = rotorWiring[i - 1];
        }
        rotorWiring[0] = last;
        for (int i = 0; i < ROTOR_SIZE; i++) {
            rotorWiring[i]++;
            if (rotorWiring[i] >= ROTOR_SIZE) {
                rotorWiring[i] %= ROTOR_SIZE;
            }
        }
        rotationsDone++;
        if (currentState == ROTOR_SIZE - 1) {
            currentState = 0;
        } else {
            currentState++;
        }
    }

    public int getRotationsDone(){
        return rotationsDone;
    }

    /**
     * Установавливает соединения между входами и выходами ротора
     */
    private void setRotorWiring() {
//        Инициализация массива подключения
        rotorWiring = new int[ROTOR_SIZE];
//        Случайное наполнение массива подключения
        Random random = new Random(wiringSeed);
        for (int i = 0; i < ROTOR_SIZE; i++) {
            boolean unique;
            do {
                unique = true;
                rotorWiring[i] = random.nextInt(ROTOR_SIZE);
                for (int j = 0; j < i; j++) {
                    if (rotorWiring[i] == rotorWiring[j]) {
                        unique = false;
                        break;
                    }
                }
            } while (!unique);
        }
    }

    public void setWiringSeed(int wiringSeed){
        this.wiringSeed = wiringSeed;
    }
    @Override
    public String toString() {
        DecimalFormat twoDigits = new DecimalFormat("00");
        return twoDigits.format(currentState + 1);
    }

    //temp
    private String printArray(int[] viceVersaWiring) {
        String str = "";
        DecimalFormat twoDigits = new DecimalFormat("00");
        for (int i = 0; i < viceVersaWiring.length; i++) {
            str += (twoDigits.format(viceVersaWiring[i] + 1) + " ");
        }
        return str;
    }
}
