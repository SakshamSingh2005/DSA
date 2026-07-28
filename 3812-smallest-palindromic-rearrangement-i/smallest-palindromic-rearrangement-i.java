class Solution {
   public String smallestPalindrome(String s) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder first = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                first.append((char) ('a' + i));
            }
            if (cnt[i] % 2 == 1) {
                mid.append((char) ('a' + i));
            }
        }

        StringBuilder second = new StringBuilder(first).reverse();

        return first.toString() + mid.toString() + second.toString();
    }
}