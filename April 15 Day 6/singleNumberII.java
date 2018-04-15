class singleNumberII {
    
    public int singleNumberI(int[] nums) {
        
        Arrays.sort(nums);
        
        if(nums.length == 1) return nums[0];
        
        if(nums[0]!=nums[1]) return nums[0];
      
        for(int i = 1; i < nums.length - 1; i = i+3){

            if(nums[i]!=nums[i-1]) return nums[i-1];

        }
        return nums[nums.length - 1];
        
    }

    public int singleNumberII(int[] nums) {
        
        int result = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j]>>i)&1) == 1){
                    sum++;
                    sum = sum%3;
                }
            }
            if(sum != 0){
                result = result | sum<<i;
            }
            
        }
        return result;
        
    }
    
}