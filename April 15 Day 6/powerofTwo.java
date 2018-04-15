class powerofTwo {

	// 1
    public boolean isPowerOfTwoI(int n) {
        if(n == 0) return false;
        while(n%2==0){
            n = n/2;
        }
        return (n == 1);
    }

    // 2
    public boolean isPowerOfTwoII(int n) {
        if(n>0 && (n & (n-1))==0) return true;//注意这里n一定要大于零，0和负整数都不可以算进去！（第一次打的时候犯的错）
        return false;
    }
    
    // 3
    public boolean isPowerOfTwoIII(int n) {
        return n>0 && (n == 1 || ((n%2) == 0 && isPowerOfTwo(n/2)));
    }

}