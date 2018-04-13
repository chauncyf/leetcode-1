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

``` java

```

### 765. Couples Holding Hands
#### 题目描述
Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

#### 我的思路


``` java

``` 
#### 讨论区
因为没有付费所以看不到啦～等付费了再回去看看补充。


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

``` java

```

### 765. Couples Holding Hands
#### 题目描述
Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

#### 我的思路


``` java

``` 
#### 讨论区
因为没有付费所以看不到啦～等付费了再回去看看补充。


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

### 128. Longest Consecutive Sequence
#### 题目描述
Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

#### 思路


``` java

``` 

