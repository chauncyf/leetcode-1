### 94. Binary Tree Inorder Traversal
### Problem
```text
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
```
### Solution
用stack做
```java
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
```

### 145. Binary Tree Postorder Traversal
#### Problem
```text
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
```
#### Solution
基本上和preorder是一样的，不过在部分步骤reverse了一下：
```java
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //reverse the order
            res.addFirst(node.val);
            //reverse the order
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
```