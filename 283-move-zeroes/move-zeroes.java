class Solution {
    public void moveZeroes(int[] nums) {
        int f=0;
        int l=nums.length-1;
        while(f<l){
            while(nums[f]!=0 && f<l) f++;
            while(nums[l]==0 && f< l) l--;
            for(int i=f ;i<l;i++){
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
            
            l--;
        }
    }
}