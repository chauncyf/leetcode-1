class triangle{
// 从后往前
	public List<List<Integer>> generateI(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = newline.size()-1; j >= 1; j--){
                newline.set(j, newline.get(j) + newline.get(j-1));
            }
            newline.add(1);
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }
// 从前往后1
    public List<List<Integer>> generateII(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(1);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(newline);
            for(int j = 1; j < newline.size() - 1; j++){
                newline.set(j, temp.get(j-1) + temp.get(j));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }
// 从前往后2
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(0, 1);
            for(int j = 1; j < newline.size()-1; j++){
                newline.set(j, newline.get(j) + newline.get(j+1));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

}