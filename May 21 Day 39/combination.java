class combination{
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, n, k, 1);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        if(k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(res, list, n, k - 1, i+1);
            list.remove(list.size() - 1);
        }
    }
}