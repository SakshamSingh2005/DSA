class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n + 1];
        len[0] = 0;

        // Calculate lengths after each operation
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                len[i + 1] = len[i] + 1;
            } else if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = len[i] * 2;
            } else { // '%'
                len[i + 1] = len[i];
            }

            len[i + 1] = Math.min(len[i + 1], (long) 1e18);
        }

        if (k >= len[n]) return '.';

        // Work backwards
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                if (k == len[i]) return c;
            }
            else if (c == '*') {
                // Before deletion, length was len[i]
                // After deletion, length became len[i+1]
                // k stays unchanged.
            }
            else if (c == '#') {
                long half = len[i];
                if (k >= half) {
                    k -= half;
                }
            }
            else { // '%'
                k = len[i] - 1 - k;
            }
        }

        return '.';
    }
}