package Implementações.HeapImpl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class HeapImpl {
    private int[] heap;
    private int tail;

    public HeapImpl(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public HeapImpl() {
        this.heap = new int[20];
        this.tail = -1;
    }

    public int[] getHeap() {
        return heap;
    }

    public int getTail() {
        return tail;
    }

    private boolean isEmpty() {
        return this.tail == -1;
    }

    private boolean isFull() {
        return this.tail == this.heap.length - 1;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * (index + 1);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void resize() {
        int[] aux = new int[this.heap.length * 2];
        for (int i = 0; i < this.heap.length; i++) {
            aux[i] = this.heap[i];
        }
        this.heap = aux;
    }

    public void add(int value) {
        if (isFull()) {
            resize();
        }
        this.tail++;
        this.heap[tail] = value;

        int index = this.tail;
        while (index > 0 && this.heap[parent(index)] < this.heap[index]) {
            int aux = this.heap[index];
            this.heap[index] = this.heap[parent(index)];
            this.heap[parent(index)] = aux;
            index = parent(index);
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A Árvore está vazia!");
        }
        int aux = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.heap[tail] = aux;
        this.tail--;

        this.heapify(0);
        return aux;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) {
            return;
        }

        int index_max = max_index(index, left(index), right(index));

        if (index_max != index) {
            int aux = this.heap[index];
            this.heap[index] = this.heap[index_max];
            this.heap[index_max] = aux;

            heapify(index_max);
        }
    }

    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right]) {
                    return right;
                }
            }
            return index;
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right]) {
                    return right;
                }
            }
            return left;
        }
    }

    public HeapImpl(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i++) {
            heapify(i);
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HeapImpl heap = new HeapImpl();
        int entrada = 0;
        while (true) {
            System.out.println("Digite aqui um número a ser adicionado na Heap:");
            entrada = teclado.nextInt();
            if (entrada == 123456) {
                break;
            }
            heap.add(entrada);
        }

        System.out.println(Arrays.toString(heap.getHeap()));
    }
}