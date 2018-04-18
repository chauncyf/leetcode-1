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
很典型的union find模型


### 128. Longest Consecutive Sequence
#### 题目描述
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

#### 思路
代码还有问题，时间有限，明天继续。
``` java

	public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i], i);
            if(map.containsKey(nums[i]-1)){
                union(i, map.get(nums[i]-1), parent);
            }
            if(map.containsKey(nums[i]+1)){
                union(i, map.get(nums[i]+1), parent);
            }
         
        }
        
        return getMax(parent);

    }
    
    int getParent(int a, int[] parent){
        while(a != parent[a]){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return parent[a];
    }
    
    void union(int p, int q, int[] parent){
        if (getParent(p, parent) != getParent(q, parent)){
            parent[q] = parent[p];
        }
    }
    
    int getMax(int[] parent){
        int m = parent.length;
        int[] count = new int[m];
        int max = 0;
        for(int i = 0; i < m; i++){
//          所有跟节点计数
            count[getParent(i, parent)]++;
            max = Math.max(max, count[getParent(i, parent)]);
        }
        return max;
    }
``` 
### 778. Swim in Rising Water
#### 题目描述

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., NN - 1].

#### 思路

``` java

```

