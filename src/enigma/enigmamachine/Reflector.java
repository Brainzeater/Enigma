package enigma.enigmamachine;

import enigma.enigmainterface.EnigmaCreator;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Класс, эмулирующий отражатель.
 * Случайное число - случайное подсоединение входов отражателя между собой.
 */
public class Reflector {
    private static final int ROTOR_SIZE = 26;
    private int[] reflectorWiring;
    private int seed;
    public Reflector(int seed){
        reflectorWiring = new int[ROTOR_SIZE];
        this.seed = seed;
        setReflectorWiring();
    }
    public int getOutput(int input){
        return reflectorWiring[input];
    }
    private void setReflectorWiring(){
        Random random = new Random(seed);
        int[] half = new int[ROTOR_SIZE / 2];
        int[] secondHalf = new int[ROTOR_SIZE / 2];
        boolean unique;
        for(int i = 0; i < half.length; i++){
            do{
                unique = true;
                half[i] = random.nextInt(ROTOR_SIZE);
                for(int j = 0; j < i; j++){
                    if(half[i] == half[j]){
                        unique = false;
                        break;
                    }
                }
            }while(!unique);
        }
        int k = 0;
        for(int i = 0; i < ROTOR_SIZE; i++){
            boolean left = true;
            for(int j = 0; j < half.length; j++){
                if(half[j] == i){
                    left = false;
                    break;
                }
            }
            if(left){
                secondHalf[k] = i;
                k++;
            }
        }
//        System.out.println(printArray(half));
//        System.out.println(printArray(secondHalf));
//        boolean unique;
        for (int i = 0; i < ROTOR_SIZE; i++) {
            reflectorWiring[i] = i;
            for(int j = 0; j < half.length; j++){
                if(reflectorWiring[i] == half[j]){
                    reflectorWiring[i] = secondHalf[j];
                }else if(reflectorWiring[i] == secondHalf[j]){
                    reflectorWiring[i] = half[j];
                }
            }
        }
//        System.out.println(printArray(reflectorWiring));
    }
    //temp
    private String printArray(int[] viceVersaWiringay) {
        String str = "";
        DecimalFormat twoDigits = new DecimalFormat("00");
        for (int i = 0; i < viceVersaWiringay.length; i++) {
            str += (twoDigits.format(viceVersaWiringay[i]) + " ");
        }
        return str;
    }
}
