class plusOne{

    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int[] result;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
//      当所有i都等于9，循环无法通过return digits结束时，运行以下代码：
        result = new int[n+1];
        result[0] = 1;
        return result;
        
    }    

}

