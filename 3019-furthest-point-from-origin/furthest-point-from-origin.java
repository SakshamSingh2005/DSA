class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int r=0, l=0 , u=0;
        for(char i :moves.toCharArray()){
            if(i=='L') l++;
            else if(i=='R') r++;
            else u++;
        }
        return Math.abs(l-r)+u;
        
    }
}