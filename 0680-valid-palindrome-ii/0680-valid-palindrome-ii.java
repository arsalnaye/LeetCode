class Solution {
    public boolean PalHelp(int i,int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }i=i+1;
            j=j-1;
        }return true;
    }
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char left=s.charAt(i);
            char right=s.charAt(j);
            if(left!=right){
                //delete 
                return PalHelp(i+1,j,s)||PalHelp(i,j-1,s);
            }else{
                i=i+1;
                j=j-1;
            }
        }return true;
    }
}