### 242. Valid Anagram
#### 题目
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

#### 思路
排序之后比较：
```java

    public boolean isAnagram(String s, String t) {
        
        s.toLowerCase();
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        t.toLowerCase();
        char[] tchar = t.toCharArray();
        Arrays.sort(tchar);
        if(Arrays.equals(schar, tchar)) return true;
        return false;
        
    }

```

### 56. Merge Intervals
#### 题目
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

#### 思路
先对start排序，排序完毕后依次进行比较。如果下一个的start小于等于当前的end，则两者overlap，现有的start不变，end = 比较大的那个end；否则将本start+end放入resultlist中，且让start = 新的start，end = 新的end。
```java

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                int i1 = o1.start;
                int i2 = o2.start;
                if(i1 > i2)  return 1;
                if(i1 < i2)  return -1;
                return 0;
            }
        });
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= end)
            //这里一定要取最大值，因为后一个的end未必比前一个的大
                end = Math.max(intervals.get(i).end, end);
            else{
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        //这里一定要注意加上最后一个！
        result.add(new Interval(start, end));
        return result;
    }

```
我看到速度更快的是用数组做的！思路是一样的～为什么呢～看以后复习的时候能不能自己知道原因～