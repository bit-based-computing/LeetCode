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

    int index = -1;
    int size = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] nodes = data.split(",");
        size = nodes.length - 1;
        return buildTree(nodes);
    }
    private TreeNode buildTree(String[] nodes) {
        index++;
        if(index > size) return null;
        if(nodes[index].equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));