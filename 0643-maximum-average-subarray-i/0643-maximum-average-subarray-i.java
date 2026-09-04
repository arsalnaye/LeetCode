class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double max=0, avg=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
            }
            avg=sum/k;
        max=avg;// isliye kyuki numbers agar negative hue and avg becomes -ve---> we did Math.max then max will be 0 instead of -ve average
        for(int i=k;i<nums.length;i++){
            //sum=sum+nums[i];
            sum=sum+nums[i]-nums[i-k];// aage wala num window ke andar(add) aur peeche wala bahar(remove)==> windown slide
            avg=(sum/k);
            max=Math.max(max,avg);
        }return max;
    }
}



