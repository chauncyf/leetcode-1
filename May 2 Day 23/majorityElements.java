class majorityElement(){
    
// sorting
        public int majorityElementI(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[i+nums.length/2]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

// 改进
    public int majorityElementII(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

//  hashmap
    public int majorityElementIII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > nums.length/2){
                result = nums[i];
                break;
            }
        }
        return result;
    }

}
