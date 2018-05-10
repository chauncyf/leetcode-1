class arrayIntersection{

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] intersect = new int[result.size()];
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        return toArray(result);
    }
    public int[] toArray(HashSet<Integer> set){
        int i = 0;
        int[] result = new int[set.size()];
        for(int element:set){
            result[i++] = element;
        }
        return result;
    }
    
}
