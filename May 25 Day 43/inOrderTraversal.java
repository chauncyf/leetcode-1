class inOrderTraversal{
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;
        while(curr!=null || !s.isEmpty()){
            //先追踪到最左侧的一个leaf
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
            
        }
        return res;
    }
}