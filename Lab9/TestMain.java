import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestMain {
	//Metodo ligeramante modificado del que se nos entrego en lab2 para llenar un ArrayList
	public static ArrayList<Integer> fillArray(int n) {
		ArrayList<Integer> array = new ArrayList<>();
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			array.add(rnd.nextInt( n-1)+1);
		}
		return array;
	}
	/*Metodo modificado del metodo ligeramante modificado del que se nos entrego en lab2 para llenar un array,
	ahora llenando un ArrayList con numeros que no estan en el ArrayList entregado por parámetro*/
	public static ArrayList<Integer> fillArrayC(int n, ArrayList<Integer> arr) {
		ArrayList<Integer> array = new ArrayList<>();
		Random rnd = new Random();
		int x;
		for (int i = 0; i < n; i++) {
			x=rnd.nextInt( n-1)+1;
			while(arr.contains(x)){
				x=rnd.nextInt( n-1)+1;
			}
			array.add(rnd.nextInt( n-1)+1);
		}
		return array;
	}
	public static void main(String[] args) {
		//Inicializando variables
		long s,f;
		BSTree p = new BSTree();
		AvlTree q = new AvlTree();
		//arr1 es un ArrayList con enteros que servirá para llenar los árboles
		//arr2 es un ArrayList con enteros que no están en el primer ArrayList
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr1 = fillArray(100000);
		arr2 = fillArrayC(100000,arr1);
		System.out.println("Inserción aleatoria de 100.000 elementos a BSTree:");
		s = System.nanoTime();
		for(int i=0;i<100000;i++){
			p.insert(arr1.get(i));
		}
		f=System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
		System.out.println("---------------------------------------------------");
		System.out.println("Inserción aleatoria de 100.000 elementos a AVLTree:");
		s = System.nanoTime();
		for(int i=0;i<100000;i++){
			q.insert(arr1.get(i));
		}
		f = System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
		Collections.shuffle(arr1);
		System.out.println("---------------------------------------------------");
		System.out.println("Búsqueda de 100.000 elementos que si están insertados en BSTree:");
		s = System.nanoTime();
		for (int j : arr1) {
			p.search(j);
		}
		f = System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
		System.out.println("---------------------------------------------------");
		System.out.println("Búsqueda de 100.000 elementos que si están insertados en AVLTree:");
		s = System.nanoTime();
		for (int j : arr1) {
			q.search(j);
		}
		f = System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
		System.out.println("---------------------------------------------------");
		System.out.println("Búsqueda de 100.000 elementos que no están insertados en BSTree:");
		s = System.nanoTime();
		for (int j : arr2) {
			p.search(j);
		}
		f = System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
		System.out.println("---------------------------------------------------");
		System.out.println("Búsqueda de 100.000 elementos que no están insertados en AVLTree:");
		s = System.nanoTime();
		for (int j : arr2) {
			p.search(j);
		}
		f = System.nanoTime()-s;
		System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
	}
}
