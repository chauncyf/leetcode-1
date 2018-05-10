class isPalindrome{

	public boolean isPalindrome(int x) {
        String p = Integer.toString(x);
        for(int i = 0; i < p.length()/2+1; i++){
            if(p.charAt(i) != p.charAt(p.length()-i-1)) return false;
        }
        return true;
    }

}

