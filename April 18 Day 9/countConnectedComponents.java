public class countConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];
        
        // 初始化
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        // 遍历并union
        for (int[] edge : edges) {              
            int p = getParent(parent, edge[0]);
            int q = getParent(parent, edge[1]);
            union(p, q);
        }
        
        // 根据union的结果统计根节点个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
    
    // 找根节点
    public int getParent(int[] parent, int id) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    // union
    public void union(int p, int q){
        if(p!=q) parent[q] = p;
    }

}