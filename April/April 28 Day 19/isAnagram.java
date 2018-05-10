class isAnagram{

	public boolean isAnagram(String s, String t) {
        
        s.toLowerCase();
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        t.toLowerCase();
        char[] tchar = t.toCharArray();
        Arrays.sort(tchar);
        if(Arrays.equals(schar, tchar)) return true;
        return false;
        
    }

}
