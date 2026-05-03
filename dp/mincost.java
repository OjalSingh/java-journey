package dp;

import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        for (int i = 0; i < m; i++) newCuts[i + 1] = cuts[i];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);

        
        int len = newCuts.length;
        int[][] dp = new int[len][len];

        for (int diff = 2; diff < len; diff++) { 
            for (int i = 0; i < len - diff; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (newCuts[j] - newCuts[i]));
                }
            }
        }

        return dp[0][len - 1];
    }

public static void main(String[] args) {
    Solution sol = new Solution();
    
    int n = 7;
    int[] cuts = {1, 3, 4, 5};
    
    int result = sol.minCost(n, cuts);
    
    System.out.println("Minimum cost to cut the stick: " + result);
}
}
//MCM