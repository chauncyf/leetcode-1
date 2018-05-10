class complexNumberMultiply{

	public String complexNumberMultiply(String a, String b) {

        String[] cd = a.split("\\+|i");
        String[] ef = b.split("\\+|i");
        int c = Integer.parseInt(cd[0]);
        int d = Integer.parseInt(cd[1]);
        int e = Integer.parseInt(ef[0]);
        int f = Integer.parseInt(ef[1]);
        return (c*e-d*f) + (d*e+c*f) + "i";
        
    }

}
    