class testArbolB{
  public static void main(String[] args)
 {
   int []c= {10,20,5,4,3,1,18,30,29,17,12, 11,40, 60, 85, 7, 21, 22};
   int t=3;
   ArbolB T = new ArbolB(t); 
  for (int i =0; i < c.length; i++) T.Insert(c[i]); 
   T.Imprimir();
     System.out.println(T.size());
   System.out.println("La clave con valor mínimo es: " +  T.Minimo());
  }
 }
