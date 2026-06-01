class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    class Tweet{
        int id;
        int time;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followee : followMap.get(userId)){
            List<Tweet> tweets = tweetMap.getOrDefault(followee, new ArrayList<>());

            for(Tweet t : tweets){
                pq.offer(t);
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;

        while(!pq.isEmpty() && count < 10){
            result.add(pq.poll().id);
            count++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followeeId != followerId){
            followMap.get(followerId).remove(followeeId);
        }
    }
}