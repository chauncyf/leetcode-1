### 101. Symmetric Tree
#### Problem
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

#### Solution
Recursive:
```java

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isLRtheSame(root.left, root.right);
    }
    public boolean isLRtheSame(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return left.val == right.val && isLRtheSame(left.left, right.right) && isLRtheSame(left.right, right.left);
    }

```

Iterative:
``` java

    public boolean isSymmetric(TreeNode root) {
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

```
但是看了评论区，有人说queue内最好不要插入null，所以要将!queue.isEmpty()改成queue.size>1;或者写成如下的样子：

``` java
//Discuss@Scarlett_comeup

public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null){
            return true;
        }
        if (root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left.val != right.val){
                return false;
            }
            
            if (left.left != null && right.right != null){
                queue.offer(left.left);
                queue.offer(right.right);
            }
            else if (left.left == null && right.right != null || right.right == null && left.left != null){
                return false;
            }
            if (left.right != null && right.left != null){
                queue.offer(left.right);
                queue.offer(right.left);
            }
            else if (left.right == null && right.left != null || right.left == null && left.right != null){
                return false;
            }
        }
        return true;
    }

```


### 102. Binary Tree Level Order Traversal
#### Problem
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
#### Solution
显然可以用BFS来做
```java

    public List<List<Integer>> levelOrder(TreeNode root) {
        
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

```
不过评论区又个大佬坚持用不一样的方法做（DFS），也是很棒的。不过我还是觉得用BFS解题更直观一点...？

### 11. Container With Most Water
#### Problem
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

#### Solution
一开始用了brute-force，但是效率太低啦，我们需要一个更聪明的办法：
先从x最小和最大的两条线段开始，此时的宽度是最大的，如果有容量更大的container，那么它的高度一定高于两者中的最低值：
``` java

    public int maxArea(int[] height) {
        int result = 0;
        int leftpointer = 0;
        int rightpointer = height.length - 1;
        while(leftpointer < rightpointer){
            int h = Math.min(height[leftpointer], height[rightpointer]);
            result = Math.max(result, h*(rightpointer-leftpointer));
            while((height[leftpointer] <= h) && (leftpointer < rightpointer)) leftpointer ++;
            while((height[rightpointer] <= h) && (leftpointer < rightpointer)) rightpointer --;           
        }
        return result;
    }

```

### 42. Trapping Rain Water
#### Problem
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
#### Solution
因为是上一题的关联题，我猜可以用相似的思路？



