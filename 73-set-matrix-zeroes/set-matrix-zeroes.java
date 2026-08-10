class Solution {
    public void setZeroes(int[][] ma) {
        int m=ma.length;
        int n =ma[0].length;
        boolean row= false;
        boolean col=false;
        for(int i=0 ;i<n ;i++ ){
            if(ma[0][i]==0){
                row=true;
            }
        }
        for(int i=0 ;i<m ;i++ ){
            if(ma[i][0]==0){
                col=true;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(ma[i][j]==0){
                    ma[i][0]=0;
                    ma[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            if(ma[i][0]==0){
                for(int j=1;j<n;j++){
                    ma[i][j]=0;
                }

            }
        }

        for(int i=1;i<n;i++){
            if(ma[0][i]==0){
                for(int j=1;j<m;j++){
                    ma[j][i]=0;
                }

            }
        }
        

        if(row){
            for(int i=0;i<n;i++){
                ma[0][i]=0;
            }
        }
        if(col){
            for(int j=0;j<m;j++){
                ma[j][0]=0;
            }
        }






    }
}