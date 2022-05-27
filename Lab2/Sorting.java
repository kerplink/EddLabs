import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sorting {

    public static int[] fillArray(int n) {
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n * 10);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void merge(int[] array, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int[] array, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(array, l, m);
            sort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    public static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    /*Para evitar escribir lo mismo varias veces implementé esta funcion donde data es la matriz donde se guardan
    los datos, datos son la cantidad a evaluar y c es la fila donde iran los datos en la matriz.
     */
    public static void calcularT(long[][] data, int datos, int c) {
        int[] arr1 = fillArray(datos);
        int[] arr2 = fillArray(datos);

        int[] arr1_1 = arr1.clone();
        int[] arr2_1 = arr2.clone();
        int[] arr1_2 = arr1.clone();
        int[] arr2_2 = arr2.clone();
        long startTime, finishTime;
        if (datos <= 100000) {
            startTime = System.nanoTime();
            bubbleSort(arr1);
            finishTime = System.nanoTime() - startTime;
            data[c][0] = finishTime;
            startTime = System.nanoTime();
            bubbleSort(arr2);
            finishTime = System.nanoTime() - startTime;
            data[c][0] = (data[c][0] + finishTime) / 2;
        } else {
            data[c][0] = 1;
        }
        startTime = System.nanoTime();
        mergeSort(arr1_1);
        finishTime = System.nanoTime() - startTime;
        data[c][1] = finishTime;
        startTime = System.nanoTime();
        mergeSort(arr2_1);
        finishTime = System.nanoTime() - startTime;
        data[c][1] = (data[c][1] + finishTime) / 2;

        startTime = System.nanoTime();
        Arrays.sort(arr1_2);
        finishTime = System.nanoTime() - startTime;
        data[c][2] = finishTime;

        startTime = System.nanoTime();
        Arrays.sort(arr2_2);
        finishTime = System.nanoTime() - startTime;
        data[c][2] = (data[c][2] + finishTime) / 2;
    }

    public static void main(String[] args) {

        //Inicializando la matriz
        long[][] p = new long[9][3];

        //Evaluando
        calcularT(p, 1000, 0);
        calcularT(p, 5000, 1);
        calcularT(p, 10000, 2);
        calcularT(p, 50000, 3);
        calcularT(p, 100000, 4);
        calcularT(p, 1000000, 5);
        calcularT(p, 5000000, 6);
        calcularT(p, 10000000, 7);
        calcularT(p, 50000000, 8);

        /*Imprimir la tabla. En la hoja aparece que para conseguir el tiempo en ms se debe dividir por 1000 pero al
        googlear aparece que es en realidad 10^6, asi que use una funcion de java para calcular los ms.
         */
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %30s %30s %30s", "Tamanio", "BubbleSort", "MergeSort", "JavaSort");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    System.out.printf("%10s", 1000);
                    break;
                case 1:
                    System.out.printf("%10s", 5000);
                    break;
                case 2:
                    System.out.printf("%10s", 10000);
                    break;
                case 3:
                    System.out.printf("%10s", 50000);
                    break;
                case 4:
                    System.out.printf("%10s", 100000);
                    break;
                case 5:
                    System.out.printf("%10s", 1000000);
                    break;
                case 6:
                    System.out.printf("%10s", 5000000);
                    break;
                case 7:
                    System.out.printf("%10s", 10000000);
                    break;
                case 8:
                    System.out.printf("%10s", 50000000);
                    break;
            }
            for (int j = 0; j < 3; j++) {
                if(j==0 && i>=4){
                    System.out.printf("%31s", "N/A");
                }else{
                    System.out.printf("%31s",p[i][j]+" ns/"+TimeUnit.NANOSECONDS.toMillis(p[i][j])+" ms");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}
