class jewelsandStones {
    
    public int numJewelsInStones(String J, String S) {
        
        int result = 0;
        Set Jset = new HashSet();
		char[] jlist = J.toCharArray();
        
        for(int i = 0; i < jlist.length; i ++){
            Jset.add(jlist[i]);
        }
        
		char[] slist = S.toCharArray();
         for(int j = 0; j < slist.length; j ++){
            if(Jset.contains(slist[j])) result++;
        }
        return result;
		
    }
}