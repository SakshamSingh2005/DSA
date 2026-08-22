import java.util.*;

class Solution {
    Set<String> set;
    Map<String,List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s,List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return dfs(s);
    }

    private List<String> dfs(String s) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> ans = new ArrayList<>();

        if(set.contains(s)) {
            ans.add(s);
        }

        for(int i=1;i<s.length();i++) {
            String left = s.substring(0,i);

            if(set.contains(left)) {
                String right = s.substring(i);

                for(String str:dfs(right)) {
                    ans.add(left+" "+str);
                }
            }
        }

        memo.put(s,ans);
        return ans;
    }
}