public class twoSumII{
	
	public int[] twoSum(int[] numbers, int target) {
        
        int a = 0;
        int b = numbers.length-1;
        int[] result= new int[2];
        
        for(int i = 0; i < numbers.length-1; i++){
            
            if(numbers[a] + numbers[b] == target){
                result[0] = a+1;
                result[1] = b+1;
                break;
            }else if(numbers[a] + numbers[b] > target){     
                b = b-1;   
            }else if(numbers[a] + numbers[b] < target){        
                a = a+1;      
            }
        } 
    return result;
        
    }
}