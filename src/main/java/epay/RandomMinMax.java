package epay;

import java.util.Random;

public class RandomMinMax {
    public static int Go (int min, int max){
        Random random = new Random();
        return random.nextInt((max - min + 1) + min);
    }
}
