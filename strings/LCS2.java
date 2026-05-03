package strings;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Always make 'n' the shorter string to save more space
        if (m < n) return longestCommonSubsequence(text2, text1);

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Move current row to previous row for next iteration
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
        return prev[n];
    }
}
