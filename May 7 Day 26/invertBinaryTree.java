class invertBinaryTree{

//recursive
	public TreeNode invertTreeI(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = new TreeNode(0);
        temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

//iterative:bfs
    public TreeNode invertTreeII(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                TreeNode temp = new TreeNode(0);
                temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return root;
    }

}
    