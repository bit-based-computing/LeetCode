class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else if(ratings[i] < ratings[i-1]) {
                if(candies[i-1] == 1) {
                    candies[i-1] = 2;
                    candies[i] = 1;
                } else {
                    candies[i] = 1;
                }
            } else {
                candies[i] = 1;
            }
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }

        int sum = 0;
        for(int candy: candies) sum += candy;

        return sum;

    }
}