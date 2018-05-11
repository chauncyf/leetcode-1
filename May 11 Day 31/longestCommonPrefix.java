class longestCommonPrefix{
	
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        String res = new String();
        res = strs[0];
        for(int i = 1; i < strs.length; i++){
            //注意这里strs[i].indexOf(res) != 0 而不是 != -1就好
            //因为我们不仅需要它存在，而且需要它在最前面
            while(strs[i].indexOf(res) != 0) res = res.substring(0, res.length() - 1);
        }
        return res.toString();
    }
    
}