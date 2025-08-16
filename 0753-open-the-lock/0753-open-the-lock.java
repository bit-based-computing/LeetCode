class Solution {
    public int openLock(String[] deadends, String target) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < deadends.length; i++) {
            map.put(deadends[i], 1);
        }
        Queue<String> queue = new LinkedList<>();
        if(map.get("0000") != null) return -1;

        queue.add("0000");
        map.put("0000", 1);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // System.out.println(size);
            for(int i = 0; i < size; i++) {
                String curr = queue.poll();
                if(curr.equals(target)) return count;
                for(int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);
                    int num = Character.getNumericValue(c);
                    String s1 = "";
                    String s2 = "";
                    if(num == 0) {
                        s1 = curr.substring(0,j);
                        s1 = s1 + "1" + curr.substring(j+1);
                        if(map.get(s1) == null) {
                            map.put(s1, 1);
                            queue.add(s1);
                        }

                        s2 = curr.substring(0,j);
                        s2 = s2 + "9" + curr.substring(j+1);
                        if(map.get(s2) == null) {
                            map.put(s2, 1);
                            queue.add(s2);
                        }

                    } else if(num == 9) {
                        s1 = curr.substring(0,j);
                        s1 = s1 + "0" + curr.substring(j+1);
                        if(map.get(s1) == null) {
                            map.put(s1, 1);
                            queue.add(s1);
                        }

                        s2 = curr.substring(0,j);
                        s2 = s2 + "8" + curr.substring(j+1);
                        if(map.get(s2) == null) {
                            map.put(s2, 1);
                            queue.add(s2);
                        }
                    } else {
                        int num1 = num - 1;
                        int num2 = num + 1;

                        s1 = curr.substring(0,j);
                        s1 = s1 + num1 + curr.substring(j+1);
                        if(map.get(s1) == null) {
                            map.put(s1, 1);
                            queue.add(s1);
                        }

                        s2 = curr.substring(0,j);
                        s2 = s2 + num2 + curr.substring(j+1);
                        if(map.get(s2) == null) {
                            map.put(s2, 1);
                            queue.add(s2);
                        }

                    }
                    // System.out.println(s1 + " " + s2);

                }
            }
            count++;
        }

        return -1;
    }
}