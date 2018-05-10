class largestTriangleArea{

	public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i; j < n-1; j++){
                for(int k = j; k < n; k++){
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }
    public double area(int[] a, int[] b, int[] c){
        return Math.abs(a[0]*(b[1] - c[1]) + b[0]*(c[1] - a[1]) + c[0]*(a[1] - b[1]))/2.0;
    }

}