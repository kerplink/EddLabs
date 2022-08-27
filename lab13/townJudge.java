public class townJudge{
    public int findJudge(int n, int[][] trust) {
        int[] candidate = new int[n + 1];
        for (int[] a : trust) {
            //Si confía en alguien no es el juez.
            candidate[a[0]]=-1;
            //Si no confía en nadie, incrementar sus votos.
            if(candidate[a[1]]!=-1)
                candidate[a[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            //Como todos deben confiar en el juez menos el mismo, entonces para que sea juez debe tener n-1 votos.
            if (candidate[i] == n - 1) return i; 
        }
        return -1;
    }
}
