package TST.BuildHeap;

import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Heap heap = new Heap();
        String[] input = scan.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        heap.toArray();
        heap.Heap(array);
        System.out.println(Arrays.toString(heap.getHeap()));
    }
}

class Heap {
    private int[] heap;
    private int tail;

    public Heap() {
        this.heap = new int[30];
        this.tail = -1;
    }

    public int[] getHeap() {
        return heap;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * (index + 1);
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }

            return index;

        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            }

            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private boolean isEmpty() {
        return this.tail == -1;
    }

    private boolean isFull() {
        return this.tail == this.heap.length - 1;
    }

    private void resize() {
        int[] aux = new int[this.heap.length * 2];
        for (int i = 0; i < this.heap.length; i++) {
            aux[i] = this.heap[i];
        }
        this.heap = aux;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) {return; }
        int index_max = max_index(index, left(index), right(index));
        if (index_max != index) {
            swap(index, index_max);
            heapify(index_max);
        }
    }

    public void Heap(int [] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0 ; i--) {
            heapify(i);
        }
    }

    public void toArray() {
        int[] aux = new int[this.tail + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = this.heap[i];
        }
        this.heap = aux;
    }
}
