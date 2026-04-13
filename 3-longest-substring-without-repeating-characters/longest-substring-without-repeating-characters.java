

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> set = new HashMap<>();
        int l= 0, maxLen= 0;

        for (int r=0; r<s.length();r++) {
            char c=s.charAt(r);
            if(set.containsKey(c) && set.get(c)>=l){
                l=set.get(c)+1;

            }
             set.put(c,r);
             maxLen=Math.max(maxLen,r-l+1);
           
        }

        return maxLen;
    }
}
