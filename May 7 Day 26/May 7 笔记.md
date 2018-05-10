### 104. Maximum Depth of Binary Tree
#### Problem
```text
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.
```
#### Solution
Recursive:
```java

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if(ldepth > rdepth) return ldepth + 1;
        else return rdepth + 1;

    }

```
However, an iterative method is always better than a recursive one in java, according to some comments in the discuss session. Therefore, I am going to use BFS and DFS respectively to solve this problem.

BFS:
BFS(Breadth-first search) can be used to traverse or search a tree or a graph. It starts at the tree root and explores the neighbor nodes first, before moving to the next level of neighbors. BFS usually uses a queue(FIFO).(+:offer and -:poll in java)
```java

    public int maxDepth(TreeNode root) {
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

```

DFS: DFS can be used to traverse or search a tree or a graph. It starts at the root and explores as far as possible along each branch before backtracking. DFS often uses two stacks(LIFO).(+:push and -:pop in java)
```java
    public int maxDepth(TreeNode root) {
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

```

### 226. Invert Binary Tree
#### Problem
```text
Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```
#### Solution
recursive:
``` java

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = new TreeNode(0);
        temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

```

iterative(bfs):
```java

    public TreeNode invertTree(TreeNode root) {
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

```

### 100. Same Tree
#### Problem
```text
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true


Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false


Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```
#### Solution
Recursive:
```java 

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

```

Iterative:
```java

    public boolean isSameTree(TreeNode p, TreeNode q) {
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
```

### 182. Duplicate Emails
#### Problem
```text
Write a SQL query to find all duplicate emails in a table named Person.
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+

For example, your query should return the following for the above table:
+---------+
| Email   |
+---------+
| a@b.com |
+---------+

Note: All emails are in lowercase.
```
#### Solution
```mysql
# Write your MySQL query statement below
select Email 
from Person 
group by Email
having count(Email) > 1;

``` 
其实这里COUNT(\*)就好。

### 144. Binary Tree Preorder Traversal
#### Problem
```text
Given a binary tree, return the preorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?
```
#### Solution
DFS:
```java

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
```