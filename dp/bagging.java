package dp;

import java.lang.Math;

public class bagging {
    static class Solution_dp {
        public void dp(int[] weights, int[] values, int bagCapacity) {
            int[][] dp = new int[weights.length][bagCapacity + 1]; // means max value can be stored in bagCapacity
            for (int i = 0; i < weights.length; i++) {
                dp[i][0] = 0;
            }

            for (int j = 1; j <= bagCapacity; j++) {
                dp[0][j] = (j >= weights[0]) ? values[0] : 0;
            }

            for (int i = 1; i < weights.length; i++) {
                for (int j = 1; j <= bagCapacity; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            (j >= weights[i]) ? dp[i - 1][j - weights[i]] + values[i] : dp[i - 1][j]);
                }
            }

            // print the dp array
            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j <= bagCapacity; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static class Solution_dp_compress {
        public void dp_compress(int[] weights, int[] values, int bagCapacity){
            int[] dp = new int[bagCapacity + 1];
            int n = weights.length;
            // init dp
            for(int i = 0; i < n; i++) {
                dp[i] = 0;
            }

            for(int i = 0; i < n; i++) {
                for(int j = bagCapacity; j >=0; j--) {
                    dp[j] = Math.max(dp[j], (j - weights[i] >=0)? dp[j - weights[i]] + values[i]:0);
                }
            }
            System.out.println(dp[dp.length - 1]);
        }
    }

    static class Solution_bruteforce {
        int maxValue = 0;
        int[] weights;
        int[] values;
        int bagCapacity;
        public void bruteforce(int[] weights, int[] values, int bagCapacity) {
            this.weights = weights;
            this.values = values;
            this.bagCapacity = bagCapacity;
            dfs(0, 0, 0);
            System.out.println(maxValue);
        }

        private void dfs(int n, int curValue, int curWeight) {
            //base case
            if(curWeight > bagCapacity) return;

            if(n == weights.length) {
                maxValue = Math.max(maxValue, curValue);
                return;
            }

            maxValue = Math.max(maxValue, curValue);

            // choose the Nth item
            dfs(n + 1,  curValue + values[n], curWeight + weights[n]);
            // not choose the nth item
            dfs(n + 1, curValue , curWeight);
        }
    }

    public static void main(String[] args) {
        // three objects: 0, 1, 2
        int[] weights = { 1, 3, 4 };
        int[] values = { 15, 20, 30 };
        int bagCapacity = 4;

       Solution_dp s = new Solution_dp();
       s.dp(weights, values, bagCapacity);

       Solution_bruteforce s2 = new Solution_bruteforce();
       s2.bruteforce(weights, values, bagCapacity);

       Solution_dp_compress s3 = new Solution_dp_compress();
       s3.dp_compress(weights, values, bagCapacity);
    }
}

