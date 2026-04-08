class Solution {
    public int[] countBits(int n) {
       int[] res = new int[n+1];
       for(int i=0;i<=n;i++){
            int num = i;
            int ress = 0;
            while(num!=0){
                num = num &(num-1);
                ress++;
            }
            res[i] = ress;
       } 
    
        return res;
    }
}
