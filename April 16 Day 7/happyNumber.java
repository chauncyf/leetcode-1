class happyNumber{
	
	public boolean isHappy(int n) {
        Set<Integer> loop = new HashSet<>();
        int squareSum;
        int remain;
        while(loop.add(n)){
            squareSum = 0;
            while(n>0){
//              计算所有digits的总和
                remain = n%10;
                squareSum = squareSum + remain*remain;
                n = n/10;
            }
//             如果总和为1，return true
            if(squareSum == 1) 
                return true;
//             否则另n=总和
            else 
                n = squareSum;
        }
        return false;
    }
    
}