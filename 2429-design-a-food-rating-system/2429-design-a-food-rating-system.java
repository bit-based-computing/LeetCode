class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToRatings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToRatings = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToRatings.putIfAbsent(cuisine, new TreeMap<>(Collections.reverseOrder()));
            cuisineToRatings.get(cuisine).putIfAbsent(rating, new TreeSet<>());
            cuisineToRatings.get(cuisine).get(rating).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeMap<Integer, TreeSet<String>> ratingsMap = cuisineToRatings.get(cuisine);
        TreeSet<String> oldSet = ratingsMap.get(oldRating);
        oldSet.remove(food);
        if (oldSet.isEmpty()) ratingsMap.remove(oldRating);

        foodToRating.put(food, newRating);
        ratingsMap.putIfAbsent(newRating, new TreeSet<>());
        ratingsMap.get(newRating).add(food);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> ratingsMap = cuisineToRatings.get(cuisine);
        int highestRating = ratingsMap.firstKey();
        return ratingsMap.get(highestRating).first(); // lexicographically smallest food
    }
}
