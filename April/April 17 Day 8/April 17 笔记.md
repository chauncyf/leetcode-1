
### 217. Contains Duplicate
#### 题目描述
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
#### 思路
可以用hashset哇
```java
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) 
                  return true;
        }
        return false;
    }
```
看评论区还有全部加入hashset后比较长度的，也行的。

### 219. Contains Duplicate II
#### 题目描述
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
#### 思路
和上题思路类似，但是我们需要在检验nums[i]是否可以加入hashset前，先从hashset中删去nums[i-k-1]。
```java

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
//          若无法增加，则证明存在
            if(!set.add(nums[i])) return true;
        }
//      反之，则不存在
        return false;
    }
```

### 220. Contains Duplicate III
#### 题目描述
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
#### 思路
根据提示，使用binary search tree
```java

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (nums.length < 2 || k == 0) return false;
        
//      这里使用有序集:tree set
        TreeSet<Long> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long)(nums[i] + t));
            Long ceiling = set.ceiling((long)(nums[i] - t));
            if((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) return true;
            set.add((long)nums[i]);
            if(i > k) set.remove((long)nums[i-k-1]);
        }
        return false;
        
    }

```
报错了，经过调试发现是倒数第二行出了错：

```java
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (k <= 0 || t < 0) return false;
        
//      这里使用有序集:tree set
        TreeSet<Long> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){
            Long n = (long)nums[i];
            Long floor = set.floor(n);
            Long ceiling = set.ceiling(n);
            
            if((floor != null && floor + t >= n) || (ceiling != null && ceiling <= n + t)) 
                return true;
            
            set.add(n);
            if(i >= k) 
                set.remove((long)nums[i-k]);
        }
        return false;
        
    }
```
这样就对了。

还有一个方法，下次再说吧。