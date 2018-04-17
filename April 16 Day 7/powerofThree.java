class powerofThree{

	public boolean isPowerOfThreeI(int n) {
        while(n%3==0 && n!=0){
            n = n/3;
        }
        if(n == 1) return true;
        return false;
    }

    public boolean isPowerOfThreeII(int n) {
        return n>0 &&  (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }

    public boolean isPowerOfThreeIII(int n) {
        return (Math.log10(n)/Math.log10(3))%1==0;
    }

    public boolean isPowerOfThree(int n) {
	//int最大为：2147483647；1162261467 是 3^19,  3^20 就比int大了。  
    return n > 0 && (1162261467 % n == 0);
}
}