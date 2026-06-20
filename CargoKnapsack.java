public class CargoKnapsack {

    public static void main(String[] args) {

        String[] items = {"A","B","C","D","E","F","G","H"};

        int[] weights = {4, 5, 3, 6, 2, 8, 7, 9};
        int[] values  = {30, 35, 20, 40, 15, 50, 45, 70};

        int capacity = 24;
        int n = items.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Value = ₹" + dp[n][capacity] + " Thousand");

        int w = capacity;
        System.out.print("Selected Items: [");

        boolean first = true;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {

                if (!first)
                    System.out.print(", ");

                System.out.print(items[i - 1]);
                first = false;

                w -= weights[i - 1];
            }
        }

        System.out.println("]");
    }
}