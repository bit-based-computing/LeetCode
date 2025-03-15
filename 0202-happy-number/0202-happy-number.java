class Solution {

    long square(long number) {
        long sum = 0;
        long rem = 0;
        while(number > 0) {
            rem = number % 10;
            number = number / 10;
            sum += (rem * rem);            
        }
        return sum;
    }
    public boolean isHappy(int n) {
        long number = n;
        long slow = n;
        long fast = square(square(n));
        while(slow != fast) {
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow == 1;
    }
}