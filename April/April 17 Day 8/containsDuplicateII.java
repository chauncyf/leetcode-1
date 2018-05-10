class containsDuplicateII {

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
    
}