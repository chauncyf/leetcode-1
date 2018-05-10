class friendCircles {
    
    private int[] rank;
    private int[] root;
    private int count;
    
    public int findCircleNum(int[][] M) {
        
//      初始化rank（depth）;root（根结点）和count（连通分量数）
        int m = M.length;
        count = m;
        rank = new int[m];
        root = new int[m];
        for(int i = 0; i < m; i++){
            root[i] = i;
        }
        
        for(int i = 0; i < m-1; i++){
            for(int j = i+1; j < m; j++){
                if(M[i][j] == 1){
                    System.out.println(i + "," + j);
                    int rooti = find(i);
                    int rootj = find(j);
                    if(rooti != rootj){ //只有当两个root不同时，才需要union
                        union(rooti, rootj);
                        System.out.println(rooti + "," + rootj);
                        count --;
                        System.out.println(count);
                        System.out.println("-----");
                    }
                }
            }
        }
        
        return count;
        
    }
        
    public int find(int i){
        while(i != root[i]){
            i = root[i];  //只有当root是自己时，该节点为根结点
        }
        return i;
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
//          这里有前提条件：两个root必不同
        if(rank[rootp] > rank[rootq]){
            root[rootq] = rootp;
        }else if (rank[rootp] == rank[rootq]){
            root[rootp] = rootq;
            rank[rootp] ++;
        }
    }
  
}