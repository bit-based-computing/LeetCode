class Food
{
    int rating;
    String name;
    String cuisine;

    Food(String name, int rating, String cuisine)
    {
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
    }
}

class FoodComaparator implements Comparator<Food>
{
    @Override
    public int compare(Food a, Food b)
    {
        if(a.rating==b.rating)
        return a.name.compareTo(b.name);
        else
        return b.rating-a.rating;
    }
}
class FoodRatings {

    HashMap<String,Food> map;
    HashMap<String,PriorityQueue<Food>> map2;
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        map = new HashMap<String,Food>();
        map2 = new HashMap<String,PriorityQueue<Food>>();

        for(int i=0;i<foods.length;i++)
        {
            Food newNode = new Food(foods[i],ratings[i],cuisines[i]);
            map.put(foods[i],newNode);
            if(!map2.containsKey(cuisines[i]))
            {
                PriorityQueue<Food> q = new PriorityQueue<Food>(new FoodComaparator());
                q.add(newNode);
                map2.put(cuisines[i],q);
            }
            else
            {
                map2.get(cuisines[i]).add(newNode); 
            }
            
            
        }

        
    }
    
    public void changeRating(String food, int newRating) {
        
        Food temp = map.get(food);

        Food newFood = new Food(food, newRating, temp.cuisine);
        PriorityQueue<Food> q = map2.get(temp.cuisine);

        //q.remove(temp);
        //temp.rating =newRating;
        temp.name ="";
        q.add(newFood);
        map.put(food,newFood);
        
            
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> q = map2.get(cuisine);
        while(q.peek().name=="")
        q.poll();

        return q.peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */