class intToRoman{
    public String intToRomanI(int num) {
        String n = String.valueOf(num);
        int cd = n.length() - 1;
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < n.length(); j++){
            int number = n.charAt(j) - '0';
            if(cd == 3){
                for(int i = 0; i < number; i++){
                    result.append("M");
                }
            }
            if(cd == 2){
                if(number == 9) result.append("CM");
                if(number >= 5 && number < 9) {
                    result.append("D");
                    for(int i = 0; i < number - 5; i++){
                        result.append("C");
                    }
                }
                if(number == 4) result.append("CD");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("C");
                    }
                }
            }
            if(cd == 1){
                if(number == 9) result.append("XC");
                if(number >= 5 && number < 9) {
                    result.append("L");
                    for(int i = 0; i < number - 5; i++){
                        result.append("X");
                    }
                }
                if(number == 4) result.append("XL");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("X");
                    }
                }
            }
            if(cd == 0){
                if(number == 9) result.append("IX");
                if(number >= 5 && number < 9) {
                    result.append("V");
                    for(int i = 0; i < number - 5; i++){
                        result.append("I");
                    }
                }
                if(number == 4) result.append("IV");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("I");
                    }
                }
            }
            cd--;
        }
        return result.toString();
    }

    public String intToRomanII(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[num%1000/100] + X[num%100/10] + I[num%10];
    }

}