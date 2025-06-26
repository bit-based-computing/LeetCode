class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int maxLastDigit = max % 10;
        int minLastDigit = min & 10;
        int ans = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            if (ans > max / 10 || (ans == max / 10 && lastDigit > maxLastDigit))
                return 0;
            if (ans < min / 10 || (ans == min / 10 && lastDigit > minLastDigit))
                return 0;
            ans = ans * 10 + lastDigit;
        }

        return ans;
    }
}