class subsetII{
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums); //为了去重先排序
        helper(nums, res, sub, 0);
        return res;
        
    }
    
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sub, int index){
        
        res.add(new ArrayList<>(sub));
        for(int i = index; i < nums.length; i++){
            //如果nums[i]曾经出现过，则越过本次循环
            if(i != index && nums[i - 1]==nums[i]) continue;
            sub.add(nums[i]);
            helper(nums, res, sub, i+1);
            sub.remove(sub.size() - 1);
        }
    }
}