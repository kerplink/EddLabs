class isThereApath {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        //Lista que marca los nodos conectados.
        boolean[] used = new boolean[n];
        //Se marca el inicio como conectado.
        used[start] = true;
        //Creación e inicialización de auxiliar
        boolean newUsedFound = true;
        while (!used[end] && newUsedFound) {
            //Si no se encuentra un nuevo nodo que se conecte se termina la operación.
            newUsedFound = false;
            for (int i = edges.length - 1; i >= 0; i--) {
                //Si el valor en [i,0] está conectado y si el valor en [i,1] no aparece como conectado se marca.
                if (used[edges[i][0]]) {
                    if (!used[edges[i][1]])  newUsedFound = used[edges[i][1]] = true;
                //Si el valor [i,1] está marcado como conectado se marca [0,i] como conecetado.   
                } else if (used[edges[i][1]]) {
                    newUsedFound = used[edges[i][0]] = true;
                }
            }
        }
        //Se retorna el valor booleano del nodo end, que retornará falso si no se encontró un camino.
        return used[end];
    }
}
