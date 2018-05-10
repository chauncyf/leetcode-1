class optimalDivision{

    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return Integer.toString(nums[0]);
        if(nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuffer numMax = new StringBuffer();
        numMax.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++){
            numMax.append("/" + nums[i]);
        }
        numMax.append(")");
        return numMax.toString();
    }

}

