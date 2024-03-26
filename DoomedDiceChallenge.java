
import java.util.HashMap;
import java.util.Map;

public class DoomedDiceChallenge {
    public static void main(String[] args) {
        // Die A and Die B
        int[] dieA = { 1, 2, 3, 4, 5, 6 };
        int[] dieB = { 1, 2, 3, 4, 5, 6 };

        // Total combinations possible
        int totalCombinations = dieA.length * dieB.length;
        System.out.println("Total combinations possible: " + totalCombinations);

        // Distribution of all possible combinations
        System.out.println("Distribution of combinations:");
        for (int a : dieA) {
            for (int b : dieB) {
                System.out.print("(" + a + "," + b + ") "); // Add space after each combination
            }
            System.out.println(); // Move to the next line after printing all combinations for a particular value
                                  // of Die A
        }

        // Probability of all possible sums occurring among the combinations
        Map<Integer, Double> sumProbability = new HashMap<>();
        for (int a : dieA) {
            for (int b : dieB) {
                int sum = a + b;
                sumProbability.put(sum, sumProbability.getOrDefault(sum, 0.0) + 1.0);
            }
        }

        System.out.println("Probability of sums:");
        for (Map.Entry<Integer, Double> entry : sumProbability.entrySet()) {
            int sum = entry.getKey();
            double probability = entry.getValue() / totalCombinations;
            System.out.printf("P(Sum = %d) = %f\n", sum, probability);
        }
    }
}