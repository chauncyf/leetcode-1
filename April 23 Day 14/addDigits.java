class addDigits{

	public int addDigitsI(int num) {
        while(num/10 != 0){
            int tempnum = num;
            num = 0;
            while(tempnum/10 != 0){
                num += tempnum%10;
                tempnum = tempnum/10;
            }
            num += tempnum;
        }
        return num;
    }

    public int addDigitsII(int num) {
        if(num == 0) return num;
        else{
            if(num%9 == 0) return 9;
                else return num%9;
        }
    }
    
}