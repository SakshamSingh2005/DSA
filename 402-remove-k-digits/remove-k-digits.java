class Solution {
    public String removeKdigits(String num, int k) {
        int n =num.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& num.charAt(i)<st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        StringBuilder sb= new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        int sz=sb.length();
        int l=0 , r=sz-1;
        while(l<sz && sb.charAt(l)=='0') l++;
        while(r>=0 && k>0){
            r--;
            k--;
        }
        if(l>r) return "0";
        else {
            return sb.substring(l,r+1);
        }
        
    }
}