class moveZeroes{

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i : nums){
            if(i != 0){
                nums[pos] = i;
                pos++;
            }
        }
        while(pos < nums.length){
            nums[pos] = 0;
            pos++;
        }
    }
    
}
