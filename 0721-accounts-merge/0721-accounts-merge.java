import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        
        // Initialize Union-Find structures
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name); 
                parent.put(account.get(i), account.get(i));
            }
        }
        
        // Union accounts
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), p);
            }
        }
        
        // Group accounts by root email
        Map<String, List<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(email, parent);
            unions.putIfAbsent(root, new ArrayList<>());
            unions.get(root).add(email);
        }
        
        // Collect result
        List<List<String>> res = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> emails = unions.get(root);
            Collections.sort(emails); // Sort emails
            emails.add(0, emailToName.get(root)); // Add the owner
            res.add(emails);
        }
        
        return res;
    }
    
    private String find(String email, Map<String, String> parent) {
        if (!email.equals(parent.get(email))) {
            parent.put(email, find(parent.get(email), parent));
        }
        return parent.get(email);
    }
}