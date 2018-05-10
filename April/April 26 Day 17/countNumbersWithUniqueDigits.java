class countNumbersWithUniqueDigits{

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int base = 9;
        int result = 10;
        for(int i = 1; i < n & i <= 10; i++){
            base = base*(9-i+1);
            result = result + base;
        } 
        return result;
    }
    
}