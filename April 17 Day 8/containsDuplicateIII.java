class containsDuplicateIII{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (k <= 0 || t < 0) return false;
}
        
//      这里使用有序集:tree set
        TreeSet<Long> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){
            Long n = (long)nums[i];
            Long floor = set.floor(n);
            Long ceiling = set.ceiling(n);
            
            if((floor != null && floor + t >= n) || (ceiling != null && ceiling <= n + t)) 
                return true;
            
            set.add(n);
            if(i >= k) 
                set.remove((long)nums[i-k]);
        }
        return false;
        
    }
}