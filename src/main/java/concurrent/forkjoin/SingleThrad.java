package concurrent.forkjoin;

/**
 * @Author: lx
 * @Date: Created in 2018/3/20 0020
 */
public class SingleThrad {
    public static void main(String[] args) {
        final int SIZE = 100000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }

        int n = 0;
        for (int i = 0; i < SIZE; i++) {
            if (numbers[i] > 0.5) {
                n++;
            }
        }
        System.out.println(n);
    }
}