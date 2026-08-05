class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Stack<Integer> neg= new Stack<>();
        Stack<Integer> pos= new Stack<>();
        for(int i=0 ;i<n ;i++){
            if( nums[i] >0) pos.push(nums[i]);
            else neg.push(nums[i]);
        }
        int arr[] =new int[n];
        for(int i=n-1 ;i>=0 ;i--){
            if(i%2!=0) arr[i]=neg.pop();
            else arr[i]=pos.pop();
        }
        return arr;
    }
}