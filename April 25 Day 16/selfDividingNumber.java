class selfDividingNumber{

// 我冗长的...代码
    public List<Integer> selfDividingNumbersI(int left, int right) {
        
        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right; i++){

        //默认这个数字是一个self-dividing number
            boolean result = true;
            int temp = i;

        //遍历个位以前的每一位，一旦出现违反规则的情况，则让result = false，并且跳出遍历；
            while(temp/10 != 0){
                if(temp%10 == 0){
                    result = false;
                    break;
                }
                int divider = temp%10;
                if(i%divider != 0){
                    result = false;
                    break;
                }
                temp = temp / 10;
            }

        //判断个位（数）是否符合要求
            int divider = temp%10;
            if(divider == 0) 
                result = false;
            else{
                if(i%divider != 0) 
                    result = false;
            }

        //只有当result此时还是true时，在list中增加该数字。
            if(result == true){
                list.add(i);
            }
            
        }

        return list;

    }

// 评论区小伙伴的简洁代码
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            //这里把j是个位数的情况包含进去了
            //而我是分开写的，使得代码很冗余
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            //这里没有另外存储一个变量进行判断，而是看j能不能走到这一步，减少了空间的使用，也让代码更精简
            if (j == 0) list.add(i); 
        }
        return list;
    }
    
}
    
