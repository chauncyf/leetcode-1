class mergeSortedArray{

	public void mergeI(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m + n; i ++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    public void mergeII(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for(int i = 0; i < n; i++) nums1[i] = nums2[i];
        }
        //mergesort
        int left = m - 1;
        int right = n - 1;
        int total = m + n - 1;
        while(left > -1 && right > -1){
            if(nums2[right] > nums1[left]){
                nums1[total--] = nums2[right--];
            }else{
                nums1[total--] = nums1[left--];
            }
        }
        while(right > -1) nums1[total--] = nums2[right--];
        while(left > -1) nums1[total--] = nums1[left--];
    }
    
}