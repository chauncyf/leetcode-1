class addBinary{
    public String addBinary(String a, String b) {
        int A = a.length() - 1,
        B = b.length() - 1,
        carry = 0;
        StringBuilder res = new StringBuilder();
        while(A >= 0 || B >= 0){
            int sum = carry;
            if(A >= 0) sum += a.charAt(A--) - '0';  
            if(B >= 0) sum += b.charAt(B--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
    