class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int lfsum[]=new int[n];
        int rtsum[]=new int[n];
        lfsum[0]=nums[0];
        for(int i=1;i<n;i++){
            lfsum[i]=lfsum[i-1]+nums[i];
        }
        rtsum[n-1]=nums[n-1];
        for( int i=n-2;i>=0;i--){
            rtsum[i]=rtsum[i+1]+nums[i];
        }
        for(int i=0;i<n;i++){
            if(lfsum[i]==rtsum[i]){
                return i;
            }
        }return -1;
    }
}