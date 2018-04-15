class Solution {

    public int[] singleNumber(int[] nums) {
        
        int diff = 0;
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            diff ^= nums[i];
        }
        // 
        diff = diff & (-diff);
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & diff) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        
        return result;
        
    }
    
}