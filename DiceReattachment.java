
import java.util.Arrays;

public class DiceReattachment {

    public static void main(String[] args) {
        double[] originalDistribution = calculateOriginalDistribution();
        int[] dieA = new int[6];
        int[] dieB = new int[6];
        boolean foundValidArrangement = generateArrangements(0, 0, originalDistribution, dieA, dieB);
        if (!foundValidArrangement) {
            System.out.println("No valid arrangement found.");
        }
    }

    public static double[] calculateOriginalDistribution() {
        double[] distribution = new double[13];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                distribution[i + j] += 1.0 / 36.0;
            }
        }
        return distribution;
    }

    public static boolean generateArrangements(int index, int sum, double[] originalDistribution, int[] dieA,
            int[] dieB) {
        if (index == 6) {
            if (Arrays.equals(calculateDistribution(dieA, dieB), originalDistribution)) {
                printResult(dieA, dieB, originalDistribution);
                return true; // Valid arrangement found
            }
            return false; // Not a valid arrangement
        }

        boolean foundValidArrangement = false;
        for (int i = 1; i <= 4; i++) {
            dieA[index] = i;
            for (int j = 1; j <= 8; j++) {
                dieB[index] = j;
                // Increment index and sum for the next recursion
                foundValidArrangement = generateArrangements(index + 1, sum, originalDistribution, dieA, dieB);
                if (foundValidArrangement) {
                    return true; // Terminate search if a valid arrangement is found
                }
            }
        }
        return foundValidArrangement;
    }

    public static double[] calculateDistribution(int[] dieA, int[] dieB) {
        double[] distribution = new double[13];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                distribution[dieA[i] + dieB[j]] += 1.0 / 36.0;
            }
        }
        return distribution;
    }

    public static void printResult(int[] dieA, int[] dieB, double[] distribution) {
        System.out.println("Valid Arrangement for Die A:");
        System.out.println(Arrays.toString(dieA));
        System.out.println("Valid Arrangement for Die B:");
        System.out.println(Arrays.toString(dieB));
        System.out.println("Probability Distribution:");
        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum = " + i + ": Probability = " + distribution[i]);
        }
        System.out.println();
    }
}
