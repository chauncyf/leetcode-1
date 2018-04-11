public class twoSumIII{

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int num){

		if(map.containsKey(num)){
			map.put(num, map.get(num)+1);
		}else{
			map.put(num, 1);
		}
		
	}

	public boolean find(int target){

		for (Integer i : map.keySet()) {
        	if (map.containsKey(target - i)) return true;
	    }
	    return false;

	}

}