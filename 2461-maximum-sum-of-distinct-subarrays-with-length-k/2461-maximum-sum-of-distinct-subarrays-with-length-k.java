class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0,max=0;
        Map<Integer,Integer> map=new HashMap<>();
        int dups=0;
        for(int i=0;i<k;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }map.put(nums[i],map.get(nums[i])+1);
            sum=sum+nums[i];
            if(map.get(nums[i])>1){
                dups=dups+1;
            }
        }if(dups==0){
            max=Math.max(max,sum);
        } for(int i=k;i<nums.length;i++){
            int numToAdd=nums[i],numToRemove=nums[i-k];
            if(!map.containsKey(numToAdd)){
                map.put(numToAdd, 0);
            }map.put(numToAdd,map.get(numToAdd)+1);
            if(map.get(numToAdd)>1){
                dups++;
            }sum=sum+numToAdd;
            if(map.get(numToRemove)>1){
                dups--;
            }map.put(numToRemove,map.get(numToRemove)-1);
            sum=sum-numToRemove;
            if(dups==0){
                max=Math.max(sum,max);
            }
        }return max;
    }
}