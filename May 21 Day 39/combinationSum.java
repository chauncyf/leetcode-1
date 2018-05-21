class combinationSum{
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            sum += candidates[i];
            helper(res, list, candidates, target, sum, i);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        
    }
}