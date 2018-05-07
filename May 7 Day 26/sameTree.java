class sameTree{
	
	//recursive
    public boolean isSameTreeI(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //iterative:bfs
    public boolean isSameTreeII(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode pnode = queue.poll();
            TreeNode qnode = queue.poll();
            if(pnode == null && qnode == null) continue;
            if(pnode != null && qnode == null) return false;
            if(pnode == null && qnode != null) return false;
            if(pnode.val != qnode.val) return false;
            queue.offer(pnode.left);
            queue.offer(qnode.left);
            queue.offer(pnode.right);
            queue.offer(qnode.right);
        }
        return true;    
    }

}