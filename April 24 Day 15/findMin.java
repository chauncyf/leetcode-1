class findMin{

	public int findMinI(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMinII(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(min > nums[i]) min = nums[i];
        }
        return min;
    }

    public int findMinIII(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        if(nums.length == 1) return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start+end)/2;
            if(mid >= 1 && nums[mid] < nums[mid - 1]) return nums[mid];
            if(nums[start] <= nums[mid] && nums[mid]  >= nums[end])
                start = mid + 1;
            else
                end = mid -1;
                
        }
        return nums[start];
    }

}