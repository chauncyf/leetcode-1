class romanToInteger{

    public int romanToIntI(String s) {
        char schar[] = s.toCharArray();
        int sum = 0;

//      先全部加起来
        for(int i = 0; i < s.length(); i++){
            if(schar[i] == 'I') sum += 1;
            if(schar[i] == 'V') sum += 5;
            if(schar[i] == 'X') sum += 10;
            if(schar[i] == 'L') sum += 50;
            if(schar[i] == 'C') sum += 100;
            if(schar[i] == 'D') sum += 500;
            if(schar[i] == 'M') sum += 1000;
        }
        
//      如果出现减法情况，减去双倍
        if(s.contains("IV")) sum -= 2;
        if(s.contains("IX")) sum -= 2;
        if(s.contains("XL")) sum -= 20;
        if(s.contains("XC")) sum -= 20;
        if(s.contains("CD")) sum -= 200;
        if(s.contains("CM")) sum -= 200;
        
        return sum;
    }

    public int romanToIntII(String s) {
        int nums[]=new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }

        return (sum+nums[nums.length-1]);
        
    }



}

