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

    // Encodes a tree to a single string.
    int index = 0;
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        String serialized = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         String nodes[] = data.split(",");
         index = -1;
         return buildTree(nodes);
    }

    public TreeNode buildTree(String[] nodes) {
        index++;
        if(nodes[index].equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));