class Solution {

    List<List<String>> ans;
    Map<String,Integer> map;

    public List<List<String>> partition(String s) {

        ans = new ArrayList<>();
        map = new HashMap<String, Integer>();

        makePartition(String.valueOf(s.charAt(0)), s, 1, new ArrayList<String>());

        return ans;
    }

    public void makePartition(String prev, String s, int currentIndex, List<String> list) {

        if (currentIndex >= s.length()) {
            if (prev.length() >= 1) {
                if (!isPelindrom(prev))
                    return;
                list.add(prev);
            }
            String result = "";
            for(String l: list) {
                result = result + l + "->";
            }
            if(map.getOrDefault(result, -1) != -1) return;
            ans.add(list);
            map.put(result, 1);
            return;
        }

        char c = s.charAt(currentIndex);

        String ns = prev + String.valueOf(c);
        if (isPelindrom(ns)) {
            List<String> newList = new ArrayList<>();
            newList.addAll(list);
            makePartition(ns, s, currentIndex + 1, newList);

            if (currentIndex < s.length() - 1) {
                List<String> newList2 = new ArrayList<>();
                newList2.addAll(list);
                newList2.add(ns);
                makePartition("", s, currentIndex + 1, newList2);
            }

        } else {
            List<String> newList = new ArrayList<>();
            newList.addAll(list);
            makePartition(ns, s, currentIndex + 1, newList);
        }

        if (prev.length() >= 1 && isPelindrom(prev)) {
            List<String> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(prev);
            prev = String.valueOf(c);
            makePartition(prev, s, currentIndex + 1, newList);
        }

    }

    boolean isPelindrom(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }
        return true;
    }

}