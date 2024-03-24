
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

    public static double[] calculateProbabilityDistribution() {
        double[] distribution = new double[13];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                distribution[i + j] += 1.0 / 36.0;
            }
        }
        return distribution;
    }

    // Function to print the probability distribution
    public static void printProbabilityDistribution(double[] distribution) {
        System.out.println("Probability Distribution Before Spot Removal:");
        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum = " + i + ": Probability = " + distribution[i]);
        }
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

        // Step 1: Calculate probability distribution before spot removal
        double[] originalDistribution = calculateProbabilityDistribution();

        // Step 2: Print the probability distribution
        printProbabilityDistribution(originalDistribution);

    }
}