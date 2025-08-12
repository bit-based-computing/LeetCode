class Twitter {

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private List<int[]> tweetList;
    private int timeStamp;
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        tweetList = new ArrayList<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, timeStamp++});
        tweetList.add(new int[]{tweetId, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> results = new ArrayList();
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>()); 
        int count = 0;
        for(int i = tweetList.size() - 1; i >= 0; i--) {
            int[] tweet = tweetList.get(i);
            int tweetId = tweet[0];
            int user = tweet[1];
            if(user == userId || followees.contains(user)) {
                results.add(tweetId);
                count++;
            }
            if(count == 10) break;
        }
        return results;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.get(followerId);
        if(followees != null) {
            followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */