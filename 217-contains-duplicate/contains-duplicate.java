class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dup = new HashSet<>();
        for(int x : nums){
            if(dup.contains(x)){
                return true;
            }
            else{
                dup.add(x);
            }
        }
        return false;
    }
}