
/*
 * Given the root of a binary tree, count the number of nodes
 * whose value is equal to the floor of the average of all
 * values in its subtree.
 */

// 2265. Count Nodes Equal to Average of Subtree

public class Leetcode_2265_Count_Nodes_Equal_to_Average_of_Subtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return res;
    }

    //We need information from left and right to process so using postOrder
    //Using int[2]
    //int[0] = sum and int[1] = count
    static int res = 0;
    public static int[] postOrder(TreeNode node){
        if(node == null) return new int[]{0,0};
        int left[] = postOrder(node.left);
        int right[] = postOrder(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if(sum/count == node.val) res++;

        return new int[]{sum,count};
    }

    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(6);

        int result = averageOfSubtree(root);

        System.out.println(result);
    }
}
