package enigma;

import enigma.enigmamachine.Reflector;
import enigma.enigmamachine.Rotor;

public class TestBench {
    public void start() {
        Rotor firstRotor = new Rotor(3);
        Rotor secondRotor = new Rotor(4);
        Rotor thirdRotor = new Rotor(5);
        firstRotor.setInitialState(0);
        secondRotor.setInitialState(0);
        thirdRotor.setInitialState(0);
        System.out.println("First rotor");
        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + " - " + (firstRotor.getOutput(i) + 1));
        }
        System.out.println("Second rotor");
        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + " - " + (secondRotor.getOutput(i) + 1));
        }
        System.out.println("Third rotor");
        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + " - " + (thirdRotor.getOutput(i) + 1));
        }
        Reflector enigmaReflector = new Reflector(7);
        System.out.println("Reflector:");
        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + " - " + (enigmaReflector.getOutput(i) + 1));
        }
        int a = 65;
        for (int i = 65; i < 65 + 6; i++) {
            System.out.println((char) i);
        }
        System.out.println();
        whatToTest(firstRotor, secondRotor, thirdRotor, enigmaReflector);
    }

    public void whatToTest(Rotor firstRotor, Rotor secondRotor, Rotor thirdRotor, Reflector enigmaReflector) {
        int a = 65;
        for (int i = 0; i < 6; i++) {
            char aChar = 'A';
            firstRotor.rotate();
            System.out.println("Rotation occurred");
            System.out.println("First rotor");
            for (int j = 0; j < 6; j++) {
                System.out.println((j + 1) + " - " + (firstRotor.getOutput(j) + 1));
            }
            if (firstRotor.getCurrentState() == 0) {
                secondRotor.rotate();
                System.out.println("sec rotated");
                System.out.println("Second rotor");
                for (int j = 0; j < 6; j++) {
                    System.out.println((j + 1) + " - " + (secondRotor.getOutput(j) + 1));
                }
                if (secondRotor.getCurrentState() == 0) {
                    thirdRotor.rotate();
                    System.out.println("trd rotated");
                    System.out.println("Third rotor");
                    for (int j = 0; j < 6; j++) {
                        System.out.println((j + 1) + " - " + (thirdRotor.getOutput(j) + 1));
                    }
                }
            }
            System.out.println((char) (aChar + i));
            int firRotOut = firstRotor.getOutput((aChar + i) - a);
            int secRotOut = secondRotor.getOutput(firRotOut);
            int trdRotOut = thirdRotor.getOutput(secRotOut);
            int refOut = enigmaReflector.getOutput(trdRotOut);
            int trdRotIn = thirdRotor.getInput(refOut);
            int secRotIn = secondRotor.getInput(trdRotIn);
            int firRotIn = firstRotor.getInput(secRotIn);

            System.out.println((char) (firRotIn + a));

        }
//        System.out.println();
//        for (int i = 0; i < 6; i++) {
//            System.out.println(i + " - " + firstRotor.getInput(i));
//        }
        firstRotor.rotate();
    }
}
