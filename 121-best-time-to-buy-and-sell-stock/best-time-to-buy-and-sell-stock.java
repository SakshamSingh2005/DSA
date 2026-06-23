class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max_price=0;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            max_price=Math.max(max_price,prices[i]);
            int curr_profit=max_price -prices[i];
            ans=Math.max(ans,curr_profit);
        }
        return ans;
    }
}