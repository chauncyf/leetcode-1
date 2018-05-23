class containerWithMostWater{

    public int maxArea(int[] height) {
        int result = 0;
        int leftpointer = 0;
        int rightpointer = height.length - 1;
        while(leftpointer < rightpointer){
            int h = Math.min(height[leftpointer], height[rightpointer]);
            result = Math.max(result, h*(rightpointer-leftpointer));
            while((height[leftpointer] <= h) && (leftpointer < rightpointer)) leftpointer ++;
            while((height[rightpointer] <= h) && (leftpointer < rightpointer)) rightpointer --;           
        }
        return result;
    }
    
}