import java.util.Arrays;

class singleNumber {
    
    public int singleNumber(int[] nums) {
                
        int size = nums.length;
        Integer[] array = new Integer[size];
        for (int i = 0; i < nums.length; i++) {
            Integer integer = numbers[i];
            array[i] = integer;
        }
        List list = Arrays.asList(array);
        Set set = new HashSet(Arrays.asList(a));

        for(int i = 1; i < nums.length; i = i + 1){
            
            result = result^nums[i];
            
        }
        
        return result;
            
    }
    
}