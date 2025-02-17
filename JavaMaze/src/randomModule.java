public class randomModule {

    public static int nextInt(int minRange, int maxRange) {
        long time = System.nanoTime();
        return ((int) ((time ^ (time >>> 16)) & Integer.MAX_VALUE) + minRange) % maxRange; // формула псевдогенерации чисел...
    }
}