/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return root;
        queue.add(root);
        while(!queue.isEmpty()) {
            Node prev = queue.poll();
            int size = queue.size();
            if(prev.left != null) queue.add(prev.left);
            if(prev.right != null) queue.add(prev.right);
            for(int i = 0; i < size; i++) {
                Node next = queue.poll();
                prev.next = next;
                if(next.left != null) queue.add(next.left);
                if(next.right != null) queue.add(next.right);
                prev = next;
            }
        }
        return root;
    }
}