class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n=rowIndex;
        long ans=1;
        List<Integer> list=new ArrayList<>();

        list.add(1);

        for(int i=0;i<n;i++){
            ans=ans*(n-i)/(i+1);
            list.add((int)ans);
        }

        return list;
    }
}