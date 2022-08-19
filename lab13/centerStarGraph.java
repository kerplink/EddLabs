class centerStarGraph {
    /*Teniendo en cuenta las restricciones puestas en leetcode:
        -3 <= n <= 105
        -edges.length == n - 1
        -edges[i].length == 2
        -1 <= ui, vi <= n
        -ui != vi
        -The given edges represent a valid star graph.
    Creé dos arreglos distintos, y luego comparé sus valores para ver que número persistía.
     */
    public int findCenter(int[][] edges) {
        int [] a1 = edges[0];
        int [] a2 = edges[1];
        if (a1[1]==a2[0] ||  a1[1]==a2[1]){
            return a1[1];
        }
        if (a1[0]==a2[0] ||  a1[0]==a2[1]){
            return a1[0];
        }
        return 0;
    }
}
