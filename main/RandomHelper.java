package main;

import java.util.Random;

public class RandomHelper {

    private static Random random = new Random();

    /**
     * Random num between 0-1 50% chance.
     */
    public int randomten() {
        int number;
        number = random.nextInt(10);
        //System.out.println(number);
        return number;
        //shortversion: return random.nextInt(10);

    }

    public int randomtwo() {
        int number;
        number = random.nextInt(2);
        //System.out.println(number);
        return number;
        //shortversion: return random.nextInt(10);

    }
    /**
     * Returns int between max and min
     */
    public static int attackStrength(int max, int min) {
        return random.nextInt(max-min+1)+min;
    }

}
