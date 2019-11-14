package Implementações.HeapImpl;

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

    private boolean isEmpty() {
        return this.tail == -1;
    }

    private boolean isFull() {
        return this.tail == this.heap.length - 1;
    }

    private void resize() {
        int[] array = new int[this.heap.length * 2];
        for (int i = 0; i < this.heap.length; i++) {
            array[i] = this.heap[i];
        }
        this.heap = array;
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

    public void add(int value) {
        if (isFull()) {
            resize();
        }
        else {
            // Faz a adicao normal, no final
            this.tail++;
            this.heap[this.tail] = value;

            // Verifica se o novo no tem valor maior que seu pai e se nao eh raiz.
            int i = this.tail;
            while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
                // Enquanto essa condicao for satisfeita, troca-se o elemento pelo seu pai

                /**
                 * Equivalente ao metodo auxiliar SWAP
                 */
                int aux = this.heap[i];
                this.heap[i] = this.heap[parent(i)];
                this.heap[parent(i)] = aux;
                i = parent(i);
            }
        }
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

    // Remove sempre a raiz
    public int remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        int element = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail--;

        heapify(0);
        return element;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) {
            return;
        }
        int index_max = max_index(index, left(index), right(index));
        if (index_max != index) {
            swap(index, index_max);
            heapify(index_max);
        }
    }

    public HeapImpl(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0 ; i--) {
            heapify(i);
        }
    }
}
