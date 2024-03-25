public class DoomedDiceChallenge {
    public static void main(String[] args) {
        int[] dieA = { 1, 2, 3, 4, 5, 6 };
        int[] dieB = { 1, 2, 3, 4, 5, 6 };

        // Part 1: Calculate total combinations
        int totalCombinations = dieA.length * dieB.length;
        System.out.println("Total combinations: " + totalCombinations);

        // Part 2: Calculate distribution of combinations
        int[][] combinationDistribution = new int[6][6];
        for (int i = 0; i < dieA.length; i++) {
            for (int j = 0; j < dieB.length; j++) {
                int sum = dieA[i] + dieB[j];
                combinationDistribution[dieA[i] - 1][dieB[j] - 1]++;
            }
        }

        // Print distribution
        System.out.println("Distribution of combinations:");
        for (int i = 0; i < combinationDistribution.length; i++) {
            for (int j = 0; j < combinationDistribution[i].length; j++) {
                System.out.print(combinationDistribution[i][j] + " ");
            }
            System.out.println();
        }

        // Part 3: Calculate probability of each sum
        System.out.println("Probability of each sum:");
        for (int i = 2; i <= 12; i++) {
            int count = 0;
            for (int j = 0; j < combinationDistribution.length; j++) {
                for (int k = 0; k < combinationDistribution[j].length; k++) {
                    if (j + k + 2 == i) {
                        count += combinationDistribution[j][k];
                    }
                }
            }
            double probability = (double) count / totalCombinations;
            System.out.println("P(Sum = " + i + ") = " + count + "/" + totalCombinations + " = " + probability);
        }
    }
}
