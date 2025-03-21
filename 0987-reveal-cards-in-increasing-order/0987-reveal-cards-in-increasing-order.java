class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        for(int card: deck) {
            result[queue.poll()] = card;
            if(!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return result;
    }
}