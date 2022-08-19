import java.util.Arrays;

public class MaxHeap {

    private int length = 10;
    private int size = 0;
    private int [] items = new int[length];

    public MaxHeap() {

    }

    public MaxHeap(int [] A) {
        // Build heap
        items = A;
        size = A.length;
        length = A.length;
        buildHeap();

        duplicateCapacity();
    }

    public void printHeap() {
        for(int i = 0; i< size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void insert(int item) {
        // insert a new element
        duplicateCapacity();
        items[size] = item;
        size++;
        heapifyUp(size-1);
    }

    public int top() {
        // get items[0]
        if(size > 0)	return items[0];
        else return -1;
    }

    public int delete() {
        // get items[0] and delete it
        if(size > 0) {
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapify(0);
            return item;
        }
        return -1;
    }

    private void duplicateCapacity(){
        // duplicate the capacity of the array
        if(size == length) {
            items = Arrays.copyOf(items, length*2);
            length *= 2;
        }
    }

    private void heapifyUp(int i) {
        //Cambia la posición del elemento i con la del padre si el valor del elemento i es menor.
        if (i!=1 && (items[i] < items[parent(i)])){
                swap(i,parent(i));
                heapifyUp(parent(i));
        }
    }

    private void heapify(int i) {
        // Adjust element i to the correspond pos
        // Sección implementada por sección del miércoles.
    }

    private void buildHeap() {
        // Given an array, get the heap
        for(int i = size/2; i >= 0; i--) {
            heapify(i);
        }
    }

    private int parent(int i) {
        return (i-1)/2;
    }
    private int leftChild(int i) {
        return 2*i+1;
    }
    private int rightChild(int i) {
        return 2*i+2;
    }
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
