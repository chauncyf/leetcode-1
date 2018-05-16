class subset{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if(nums == null || nums.length == 0) return res;
        List<Integer> sub = new ArrayList<>();
        helper(nums, res, sub , 0);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sub, int index){
        res.add(new ArrayList<>(sub));
        for(int i = index; i < nums.length; i++){
            sub.add(nums[i]);
            helper(nums, res, sub , i+1);
            //backtracking
            sub.remove(sub.size() - 1);
        }
    }    
}
