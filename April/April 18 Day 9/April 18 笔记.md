### 684. Redundant Connection
#### 题目描述

In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: `[[1,2], [1,3], [2,3]]`
Output: `[2,3]`
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: `[[1,2], [2,3], [3,4], [1,4], [1,5]]`
Output: `[1,4]`
Explanation: The given undirected graph will be like this:
`5 - 1 - 2
     |   |
     4 - 3
`
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.


#### 思路
一个边上的两个点，如果有同一个根节点，那么这个边一定是环里的一个边，也就是我们希望得到的值
``` java

public int[] findRedundantConnection(int[][] edges) {
//      初始化parent数组
        int[] parent = new int[2001];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        
        int[] result = new int[2];
        for(int[] edge: edges){
            int p = getParent(edge[0], parent);
            int q = getParent(edge[1], parent);
            if(p != q){
                parent[q] = p;
            }else{
//              两个点都是一个点的child，那么显然形成一个环
                result = edge;
            }
        }
        
        return result;
        
    }
    
    int getParent(int a, int[] parent){

        while(a != parent[a])
            a = parent[a];
        return parent[a];

    }

```
### 7. Reverse Integer
#### 题目描述
Given a 32-bit signed integer, reverse digits of an integer.
#### 思路
先将result设定为long,如果超出则返回0，否则返回(int)result
```java
    public int reverse(int x) {
        
        long result = 0;
        
        while(x!= 0){
            int remainder = x % 10;
            result = result*10 + remainder;
            if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) {
                return 0;
            }
            x = x/10;
        }
        
        return (int)result;
    }
```

### 323. Number of Connected Components in an Undirected Graph
#### 题目描述
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3

     |          |

     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4

     |           |

     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 
#### 思路
很典型的union find模型，和第一题差不多，而且比第一题简单

```java

    public int countComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];
        
        // 初始化
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        // 遍历并union
        for (int[] edge : edges) {              
            int p = getParent(parent, edge[0]);
            int q = getParent(parent, edge[1]);
            union(p, q);
        }
        
        // 根据union的结果统计根节点个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
    
    // 找根节点
    public int getParent(int[] parent, int id) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    // union
    public void union(int p, int q){
        if(p!=q) parent[q] = p;
    }

```


