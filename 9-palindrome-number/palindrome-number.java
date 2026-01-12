class Solution {
    public boolean isPalindrome(int x) {
        int a =x;
        int rev=0;
        while(a>0){
            int lastdigit= a%10;
            rev=(rev*10)+lastdigit;
            a =a/10;

        }
        if(rev==x)
        return true;
        else
        return false;

        
    }
}