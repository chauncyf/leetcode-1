### 547. Friend Circles
#### 题目描述
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a NxN matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

```
Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.


Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
```
#### 思路
其实就是求这N个学生之间一共有几个connected components。一开始写的代码在测试阶段没问题，但是submit的时候fail了一部分测试：
``` java

public class Solution {
    
    private int[] rank;
    private int[] root;
    private int count;
    
    public int findCircleNum(int[][] M) {
        
//      初始化rank（depth）;root（根结点）和count（连通分量数）
        int m = M.length;
        count = m;
        rank = new int[m];
        root = new int[m];
        for(int i = 0; i < m; i++){
            root[i] = i;
        }
        
        for(int i = 0; i < m-1; i++){
            for(int j = i+1; j < m; j++){
                if(M[i][j] == 1){
                    int rooti = find(i);
                    int rootj = find(j);
                    if(rooti != rootj){ //只有当两个root不同时，才需要union
                        union(rooti, rootj);
                        count --;
                    }
                }
            }
        }
        
        return count;
        
    }
        
    public int find(int i){
        while(i != root[i])
            i = root[i];  //只有当root是自己时，该节点为根结点
        return i;
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
//          这里有前提条件：两个root必不同
        if(rank[rootp] > rank[rootq]){
            root[rootq] = rootp;
        }else if (rank[rootp] == rank[rootq]){
            root[rootq] = rootp;
            rank[rootp] ++;
        }
    }
  
}  
```
debug了很久才发现union写错了啊啊啊啊啊啊啊
``` java
        else if (rank[rootp] == rank[rootq]){
            root[rootq] = rootp;
            rank[rootp] ++;
        }
```
应该写成
``` java
        else if (rank[rootp] == rank[rootq]){
            root[rootp] = rootq;
            rank[rootp] ++;
        }
```
小细节弄错了就浪费了很多时间TAT。