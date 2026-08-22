import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int len = 0;

            while (j < words.length && len + words[j].length() + (j - i) <= maxWidth) {
                len += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(" ");
                    sb.append(words[k]);
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaces = maxWidth - len;
                int each = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        int count = each;

                        if (k - i < extra) {
                            count++;
                        }

                        sb.append(" ".repeat(count));
                    }
                }
            }

            ans.add(sb.toString());
            i = j;
        }

        return ans;
    }
}