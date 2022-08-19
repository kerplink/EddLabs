//Alumno: Fernando Chandia Molina
/*Links:
    Ejercicio resuelto: https://leetcode.com/problems/number-of-provinces/discuss/2345612/JAVA-SOLUTIONoror-BEATS-99
    https://www.youtube.com/watch?v=7fujbpJ0LB4
    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Se guarda la cantidad de nodos en una variable.
        int n=isConnected.length;
        //Se crea un arregglo de tipo boolean (de tamaño n)  que marca los nodos visitados.
        boolean visited[]=new boolean[n];
        //Variable auxiliar que representa las provincias conectadas.
        int count=0;
        //Se itera n veces.
        for(int i=0;i<n;i++){
            //Si la posición i no fue visitada se llama la función dfs y aumenta el contador.
            if(!visited[i]){
                //Se entrega por parametro los arreglos visisted e isConnected, además del valor de i actual.
                dfs(visited,isConnected,i);
                //Aumenta el contador.
                count++;
            }
        }
        //Se retorna la variable auxiliar.
        return count;
    }
    //Algoritmo DFS (Deep first search).
    void dfs(boolean[] visited,int[][] graph,int i){
        //Se marca el iesimo lugar como visitado.
        visited[i]=true;
        //Recorre el arreglo graph.
        for(int j=0;j<graph.length;j++){
            //Si i y j están conectados y si j no ha sido visitada, se llama a la función dfs para ver los lugares conectados a j.
            // Ya que si i y j están conectados, los lugares conectados a j también estarán conectados a i..
            if(graph[i][j]!=0 && !visited[j]){
                dfs(visited,graph,j);
            }
        }
    }
}
