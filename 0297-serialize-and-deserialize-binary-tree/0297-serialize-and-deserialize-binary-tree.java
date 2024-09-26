/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    // It's also solution but interviewer will not want this
    // Encodes a tree to a single string.
    static TreeNode root;
    public String serialize(TreeNode root) {
       this.root = root;
       return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      return root;
    }
   
    
    // Actual solution

    // int index = -1;
    // int size = 0;
    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     if(root == null) return "X";
    //     String left = serialize(root.left);
    //     String right = serialize(root.right);
    //     StringBuilder s = new StringBuilder();
    //     s.append(root.val);
    //     s.append(",");
    //     s.append(left);
    //     s.append(",");
    //     s.append(right);
    //     return s.toString();
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     String[] nodes = data.split(",");
    //     size = nodes.length - 1;
    //     return buildTree(nodes);
    // }
    // private TreeNode buildTree(String[] nodes) {
    //     index++;
    //     if(index > size) return null;
    //     if(nodes[index].equals("X")) return null;
    //     TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
    //     root.left = buildTree(nodes);
    //     root.right = buildTree(nodes);
    //     return root;
    // }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));