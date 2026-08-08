class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];

        int j = m - 1;

        // dp[i] = how many characters of word2 can be
        // matched exactly using word1[i...n-1]
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Find the lexicographically smallest prefix
        // and use the one allowed mismatch if necessary.
        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            else {
                // Use this position as the one mismatch
                // only if the remaining characters can
                // still be matched exactly.
                if (dp[i + 1] >= m - 1 - j) {
                    ans[j] = i;
                    j++;
                    i++;
                    break;
                }
            }

            i++;
        }

        if (j < m && i == n) {
            return new int[0];
        }

        // Match the remaining characters exactly
        while (j < m && i < n) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }
            i++;
        }

        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}