class Solution {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        return solve(s1, s2);
    }

    private boolean solve(String a, String b) {

        if (a.equals(b))
            return true;

        String key = a + "#" + b;

        if (memo.containsKey(key))
            return memo.get(key);

        if (!sameCharacters(a, b)) {
            memo.put(key, false);
            return false;
        }

        int n = a.length();

        for (int i = 1; i < n; i++) {

            // Without swap
            if (solve(a.substring(0, i), b.substring(0, i)) &&
                solve(a.substring(i), b.substring(i))) {

                memo.put(key, true);
                return true;
            }

            // With swap
            if (solve(a.substring(0, i), b.substring(n - i)) &&
                solve(a.substring(i), b.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean sameCharacters(String a, String b) {

        int[] freq = new int[26];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }

        for (int x : freq)
            if (x != 0)
                return false;

        return true;
    }
}