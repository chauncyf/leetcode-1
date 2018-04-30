class largestNumber{

	public String largestNumber(int[] nums) {
        
        if(nums == null || nums.length == 0) return "";
        
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = nums[i]+"";
        } 
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a);
            }
        });
        //特殊情况：所有数字都为0
        if(strs[0].charAt(0) == '0') return "0";
        
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < strs.length; i++){
            result.append(strs[i]);
        } 
        return result.toString();
    }
    
}