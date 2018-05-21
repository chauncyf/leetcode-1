class combinationSumII{
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            //去重
            if(i != start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            target -= candidates[i];
            //同一位置的数字不可重复使用
            helper(res, list, candidates, target, i + 1);
            target += list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}