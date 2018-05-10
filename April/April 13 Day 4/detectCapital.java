class detectCapital {
// 1st attempt
    public boolean detectCapitalUse(String word) {
        char[] wordchar = word.toCharArray();
        HashSet wordset = new HashSet();
        if(Character.isLowerCase(wordchar[0])){
            for(int i = 0; i < wordchar.length; i++){
                if(Character.isLowerCase(wordchar[i])){
                    wordset.add(0);
                }else{
                    wordset.add(1);
                }
            }
        }else{
            for(int i = 1; i < wordchar.length; i++){
                if(Character.isLowerCase(wordchar[i])){
                    wordset.add(0);
                }else{
                    wordset.add(1);
                }
            }
        }
        if (wordset.size()==1 ||wordset.size()==0)
            return true;
        return false;
    }
// 2nd attempt
    public boolean detectCapitalUse1(String word) {
        char[] wordchar = word.toCharArray();
        int count = 0;
        for(char c: wordchar) if(c <='Z') count++;
        return(count==0 || count == wordchar.length || count==1&&wordchar[0] < 'Z');
    }
// 3rd attempt
    public boolean detectCapitalUse2(String word) {
        if(word.length() == 1) return true;
        return Character.isUpperCase(word.charAt(0)) ? word.substring(1).equals(word.substring(1).toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase()) : word.substring(1).equals(word.substring(1).toLowerCase
        ());
    }

}