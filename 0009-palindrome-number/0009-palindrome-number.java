class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int input = x;
        int curr = 0;
        while(x != 0) {
            curr = curr * 10;
            curr += (x % 10);
            x = x / 10;
        }
        return curr == input; 
    }
}