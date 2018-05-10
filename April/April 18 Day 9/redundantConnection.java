class redundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        
//      初始化parent数组
        int[] parent = new int[2001];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        
        int[] result = new int[2];
        for(int[] edge: edges){
            int p = getParent(edge[0], parent);
            int q = getParent(edge[1], parent);
            if(p != q){
                parent[q] = p;
            }else{
//              两个点都是一个点的child，那么显然形成一个圈
                result = edge;
            }
        }
        
        return result;
        
    }
    
    int getParent(int a, int[] parent){

        while(a != parent[a])
            a = parent[a];
        return parent[a];

    }
    
}