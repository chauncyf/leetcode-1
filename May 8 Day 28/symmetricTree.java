class symmetricTree{
	
	public boolean isSymmetricI(TreeNode root) {
        if(root == null) return true;
        return isLRtheSame(root.left, root.right);
    }
    public boolean isLRtheSame(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return left.val == right.val && isLRtheSame(left.left, right.right) && isLRtheSame(left.right, right.left);
    }

    public boolean isSymmetricII(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode leftnode = queue.poll();
            TreeNode rightnode = queue.poll();
//          注意：这里如果两个都是null，不能直接跳出循环，只是结束这一循环哦～（第一次打犯的错）
            if(leftnode==null && rightnode==null) continue;
            if(leftnode==null && rightnode!=null) return false;
            if(leftnode!=null && rightnode==null) return false;
            if(leftnode.val != rightnode.val) return false;
            queue.offer(leftnode.left);
            queue.offer(rightnode.right);
            queue.offer(leftnode.right);
            queue.offer(rightnode.left);
        }
        return true;
    }
}