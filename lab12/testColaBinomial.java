//============================
//Alumno: Fernando Chandia Molina
//============================
class testColaBinomial{
	public static void main(String[] args)
	{
		int a[] = {12, 17,2,4,5,6,22,21,29,32, 40, 45,3, 54, 65};
		ColaBinomial b = new ColaBinomial();
		for (int i=0; i < a.length;  i++) b.Insert(a[i]);
		b.Print();
		System.out.println(b.max());
	} 
}
