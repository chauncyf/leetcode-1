class permutationsII{
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> sublist = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, sublist, used);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sublist, boolean[] used){
        if(sublist.size() == nums.length) {
            //这里一定要new一个list，因为sublist本身最后会变成null，
            //如果在这时不放入一个新的list，最后的结果会变成全空的！
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //用过的不要
            if(used[i]) continue;
            //和subsetII类似
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == true) continue;
            sublist.add(nums[i]);
            used[i] = true;
            helper(nums, res, sublist, used);
            used[i] = false;
            sublist.remove(sublist.size() - 1);
            
        }
    }
}