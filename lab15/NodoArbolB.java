class NodoArbolB{
 int n ; // nro de claves almacenadas en el nodo
 boolean leaf;// Si el nodo es hoja (nodo hoja =true; nodo interno =false)
 int []key; // almacena las claves en el nodo
 NodoArbolB []c;// arreglo con las referencias a los hijos
 NodoArbolB(int t) //constructor <--> ALLOCATE-NODE()
 {
  n =0;
  leaf=true;
  key = new int[2*t-1]; 
  c = new NodoArbolB[2*t];
 } 
 // se imprimen las claves del nodo.
 void Imprimir(String d){ 
  System.out.print(d);
  for(int i=0; i < n; i++) System.out.print(key[i] + ",");
 }
}//end clase NodoArbolB


