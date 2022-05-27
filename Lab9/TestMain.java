import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestMain {
    /*Método ligeramante modificado del que se nos entrego en lab2 para llenar un ArrayList donde x es el valor minimo y
    n es el valor máximo*/
    public static ArrayList<Integer> fillArray(int x,int n) {
        ArrayList<Integer> array = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            array.add(rnd.nextInt( n-x)+x);
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
        arr1 = fillArray(1,100000);
        arr2 = fillArray(100001,200001);
        System.out.println("Inserción aleatoria de "+arr1.size()+" elementos a BSTree:");
        s = System.nanoTime();
        for (Integer integer : arr1) {
            p.insert(integer);
        }
        f=System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
        System.out.println("---------------------------------------------------");
        System.out.println("Inserción aleatoria de " +arr1.size()+ " elementos a AVLTree:");
        s = System.nanoTime();
        for (Integer integer : arr1) {
            q.insert(integer);
        }
        f = System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
        Collections.shuffle(arr1);
        System.out.println("---------------------------------------------------");
        System.out.println("Búsqueda de " +arr1.size()+ " elementos que si están insertados en BSTree:");
        s = System.nanoTime();
        for (int j : arr1) {
            p.search(j);
        }
        f = System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
        System.out.println("---------------------------------------------------");
        System.out.println("Búsqueda de "+arr1.size()+" elementos que si están insertados en AVLTree:");
        s = System.nanoTime();
        for (int j : arr1) {
            q.search(j);
        }
        f = System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
        System.out.println("---------------------------------------------------");
        System.out.println("Búsqueda de "+arr1.size()+" elementos que no están insertados en BSTree:");
        s = System.nanoTime();
        for (int j : arr2) {
            p.search(j);
        }
        f = System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
        System.out.println("---------------------------------------------------");
        System.out.println("Búsqueda de "+arr1.size()+" elementos que no están insertados en AVLTree:");
        s = System.nanoTime();
        for (int j : arr2) {
            p.search(j);
        }
        f = System.nanoTime()-s;
        System.out.println("Tarda: "+f+" ns o "+ TimeUnit.NANOSECONDS.toMillis(f)+" ms" );
    }
}
