class permutationSequence{
	public String getPermutation(int n, int k) {
		//生成顺序正整数数列
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        int[] f = new int[n+1];
        //生成每一步需要的factorial
        f[0] = 1;
        int sum = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            f[i] = sum;
        }
        //开始计算
        k = k - 1;
        StringBuilder res = new StringBuilder();
        //要注意！错误点：i=0；
        //第一个被除以的阶乘应该是(n-1)!，而不是n!
        //res的长度应为n，所以共循环n次
        for(int i = 1; i < n + 1; i++){
            int pos = k/f[n-i];
            res.append(nums.get(pos));
            nums.remove(pos);
            k = k%f[n-i];
        }
        return res.toString();
    }
}