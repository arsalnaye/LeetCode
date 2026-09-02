/*class Solution {
    public int largestInteger(int num) {
        char[]arr=Integer.toString(num).toCharArray();
        //outer loop from i=0 and arr.len-1
        //inner loop  from j=i+1 to arr.len-1
        //find max digit on right for i with same parity
        //swap i and max digit
        for(int i=0;i<arr.length;i=i++){
            int maxpos=i;
            for(int j=i+1;j<arr.length;j++){
                //odd%2==1
                //even%2==1
                //(a-b)%2==0
                if(arr[j]>arr[maxpos]&&(arr[i]-arr[j])%2==0){
                    maxpos=j;
                }
            }char temp=arr[i];
            arr[i]=arr[maxpos];
            arr[maxpos]=temp;
        }//convert char arr to integer
        return Integer.parseInt(new String(arr));
    }
}
TLE SOLUTION */
class Solution{
    public int largestInteger(int num){
        //even digits and odd digits
        PriorityQueue<Integer> even=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd=new PriorityQueue<>(Collections.reverseOrder());
        String s=Integer.toString(num);
        for(char c:s.toCharArray()){
            //c='1'
            //val='1'-'0'=1
            int val=c-'0';
            if(val%2==0){
                even.add(val);
            }else{
                odd.add(val);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            int val=c-'0';
            if(val%2==0){
                sb.append(even.poll());
            }else{
                sb.append(odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
