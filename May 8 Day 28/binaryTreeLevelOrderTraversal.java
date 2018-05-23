class binaryTreeLevelOrderTraversal{
	public List<List<Integer>> levelOrderI(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> newlist = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                newlist.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(newlist);     
        }
        return result;
        
    }
}