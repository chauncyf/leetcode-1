class maximumGap{
	public int maximumGap(int[] nums) {
        int max = 0;
        if (nums.length < 2 || nums == null) return max;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] - nums[i] > max) max = nums[i+1] - nums[i];
        }
        return max;
    }
}
