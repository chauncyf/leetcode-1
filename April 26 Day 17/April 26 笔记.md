### 553. Optimal Division
#### 题目描述

Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

#### 思路
nums[0]/nums[1]/nums[2]/.../nums[n-1] 
=  nums[0]/nums[1] * Y
<= (nums[0]/nums[1]) * (nums[2] * nums[3] * nums[4]... * nums[n-1])
=  nums[0]/(nums[1]/nums[2]/.../nums[n-1])
```java

    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return Integer.toString(nums[0]);
        if(nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuffer numMax = new StringBuffer();
        numMax.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++){
            numMax.append("/" + nums[i]);
        }
        numMax.append(")");
        return numMax.toString();
    }

```

### d
#### 题目描述

#### 思路



