import java.util.HashMap;
import java.util.Map;
public class DoomedDiceChallenge {
    // Function to calculate total combinations
    public static int totalCombinations() {
        return 6 * 6;
    }
    // Function to calculate distribution of combinations
    public static int[][] combinationDistribution() {
        int[][] distribution = new int[6][6];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                distribution[i - 1][j - 1] = i + j;
            }
        }
        return distribution;
    }
    // Function to calculate probability of sums
    public static Map<Integer, Double> probabilityOfSums(int[][] distribution) {
        int totalComb = totalCombinations();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] row : distribution) {
            for (int comb : row) {
                counts.put(comb, counts.getOrDefault(comb, 0) + 1);
            }
        }
        Map<Integer, Double> probabilities = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            probabilities.put(entry.getKey(), (double) entry.getValue() / totalComb);
        }
        return probabilities;
    }

    public static void main(String[] args) {
        // Total combinations
        int total = totalCombinations();
        System.out.println("Total Combinations: " + total);

        // Combination Distribution
        int[][] distribution = combinationDistribution();
        System.out.println("\nCombination Distribution:");
        for (int[] row : distribution) {
            for (int comb : row) {
                System.out.print(comb + " ");
            }
            System.out.println();
        }

        // Probability of Sums
        Map<Integer, Double> probabilities = probabilityOfSums(distribution);
        System.out.println("\nProbability of Sums:");
        for (Map.Entry<Integer, Double> entry : probabilities.entrySet()) {
            System.out.println("Sum = " + entry.getKey() + ": Probability = " + entry.getValue());
        }
    }
}
