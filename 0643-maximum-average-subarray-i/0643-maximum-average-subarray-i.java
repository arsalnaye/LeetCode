class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double max=0, avg=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
            }
            avg=sum/k;
        max=avg;
        for(int i=k;i<nums.length;i++){
            //sum=sum+nums[i];
            sum=sum+nums[i]-nums[i-k];
            avg=(sum/k);
            max=Math.max(max,avg);
        }return max;
    }
}



