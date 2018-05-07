class maxDepth{
	
	//iterative
	public int maxDepthI(TreeNode root) {

        if(root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if(ldepth > rdepth) return ldepth + 1;
        else return rdepth + 1;

    }

    //recursive:bfs
    public int maxDepthII(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>(); //INITIATE
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //breadth-first
            while (size > 0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
            count++;
        }
        return count;
    }

    //recursive:dfs
    public int maxDepthIII(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();  //initiate
        stack.push(root);
        //同步记录每个节点的深度
        Stack<Integer> rank = new Stack<>(); //initiate
        rank.push(1);
        int depth = 0;
        while(!stack.isEmpty()){

            //depth-first
            TreeNode node = stack.pop();
            int temprank = rank.pop();
            depth = Math.max(depth, temprank);
            
            if(node.left != null) {
                stack.push(node.left);
                rank.push(temprank + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                rank.push(temprank + 1);
            }
        }
        return depth;
    }

}