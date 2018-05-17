class permutations{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        List<Integer> sublist = new ArrayList<>();
        helper(nums, res, sublist);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sublist){
        if(sublist.size() == nums.length) {
            //这里一定要new一个list，因为sublist本身最后会变成null，
            //如果在这时不放入一个新的list，最后的结果会变成全空的！
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(sublist.contains(nums[i])) continue;
            sublist.add(nums[i]);
            helper(nums, res, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}