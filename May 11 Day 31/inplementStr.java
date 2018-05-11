class inplementStr{

	public int strStrI(String haystack, String needle) {
        
        int n = needle.length();
        int h = haystack.length();
        if(n == 0) return 0;
        if(h == 0 || n > h) return -1;
        for(int i = 0; i <= h - n; i++){
            if(haystack.substring(i, i + n).equals(needle)) return i;
            else continue;
        }
        return -1;
        
    }

    public int strStrII(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          //情况一
            //如果haystack的子string和needle一致，haystack的第i位到第i+needle.length()都应该等于needle的对应位
            //j只有在这种情况下才可以一直自累加至needle的长度
            //那么，当j = needle.length()的时候，我们就可以输出此时的i
          //情况二
            //如果needle是""，则按照题意输出0
          if (j == needle.length()) return i;
          //情况一
            //当i = haystack.length且needle不比haystack长时，说明从0遍历到i-1，都没找到和needle一致的substring
          //情况二
            //如果 haystack是""，说明haystack中没有needle的substring，因为这种情况下，i+j一开始就=0，
          //情况三
            //如果needle比haystack长，j总有可能增长至i+j=haystack的长度，这种情况显然应该输出-1
          if (i + j == haystack.length()) return -1;
          //只要j位的needle和i+j位的haystack不相等，就回去对i+1
          //j和i+j的初始值都是0，haystack总是从第i位开始比对，而needle总是从第0位开始比对
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
    }
    
}