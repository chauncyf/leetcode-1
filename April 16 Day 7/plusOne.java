class plusOne{

	public int[] plusOne(int[] digits) {

        int[] result;
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        result = new int[n+1];
        result[0] = 1
        return result;
        
    }
    
}