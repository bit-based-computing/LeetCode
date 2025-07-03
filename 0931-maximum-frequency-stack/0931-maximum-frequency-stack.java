class FreqStack {
    private Map<Integer, Integer> valToFreq;
    private Map<Integer, Stack<Integer>> freqToVals;
    private int maxFreq;

    public FreqStack() {
        valToFreq = new HashMap<>();
        freqToVals = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);

        freqToVals.computeIfAbsent(freq, z -> new Stack<>()).push(val);

        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> stack = freqToVals.get(maxFreq);
        int val = stack.pop();

        valToFreq.put(val, valToFreq.get(val) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}
