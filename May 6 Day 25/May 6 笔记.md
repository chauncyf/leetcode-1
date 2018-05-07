### 118. Pascal's Triangle
#### 题目
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 
#### 思路

一行行计算即可

一：从后往前算
``` java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = newline.size()-1; j >= 1; j--){
                newline.set(j, newline.get(j) + newline.get(j-1));
            }
            newline.add(1);
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

```

二：从前往后算：
```java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(1);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(newline);
            for(int j = 1; j < newline.size() - 1; j++){
                newline.set(j, temp.get(j-1) + temp.get(j));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

```

显然第一种方法更快啦！不过评论区大佬有个从前往后还很快的法子：
```java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(0, 1);
            for(int j = 1; j < newline.size()-1; j++){
                newline.set(j, newline.get(j) + newline.get(j+1));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

```
