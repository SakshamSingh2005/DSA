class Solution {
    public List<Integer> row(int n ){
        int ans=1;
         ArrayList<Integer> list=new ArrayList<>();
        list.add(ans);
        for(int i=1 ; i<n; i++){
            ans=ans*(n-i);
            ans=ans/i;
            list.add(ans);
        }
        return list;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1 ;i<=numRows;i++){
            list.add(row(i));

        } 
        return list;
    }
}