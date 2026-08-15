class Solution {
    public int firstUniqueEven(int[] nums) {
        HashMap <Integer, Integer> freq=new HashMap<>();
        for(int n:nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        for(int n:nums){
            if(n%2==0 && freq.get(n)==1){
                return n;
            }
        }
        return -1;
    }
}