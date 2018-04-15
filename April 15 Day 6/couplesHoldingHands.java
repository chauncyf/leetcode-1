class couplesHoldingHands {
    
//  初始化
    int[] root;
    int count;
    
    public int minSwapsCouples(int[] row) {
//      赋值
        int n = row.length/2;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        count = n;
//      计算

        for(int i = 0; i < n; i++){
            int p = row[2*i];
            int q = row[2*i + 1];
            union(p/2, q/2);
        }
        return n-count;
    }
    
    public int find(int i){
        while (i != root[i]){
            i = root[i];
        }
        return i;
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
//          这里有前提条件：两个root必不同
        if(rootp != rootq){
            root[rootp] = rootq;
            count --;
        }
    }
  
}