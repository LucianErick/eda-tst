package Fila;

import java.util.Arrays;
import java.util.Scanner;

public class Fila {
    private int head;
    private int tail;
    private int capacity;
    private Aluno[] array;

    public Fila(int capacity) {
        this.head = -1;
        this.tail = -1;
        this.capacity = capacity;
        this.array = new Aluno[capacity];
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        return (this.tail + 1) % this.capacity == this.head;
    }

    public void enqueue(Aluno aluno) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full!");
        }
        else if (isEmpty()) {
            this.head++;
            this.tail = this.head;
            this.array[this.head] = aluno;
        }
        else {
            this.tail++;
            this.array[this.tail] = aluno;
        }
    }

    public Aluno dequeue() {
        Aluno target;
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        if (this.head == this.tail) {
            target = this.array[this.head];
            this.array[this.head] = null;
            this.head = -1;
            this.tail = -1;
        }
        else {
            target = this.array[this.head];
            this.array[this.head] = null;
            this.head = (this.head + 1) % this.capacity;
        }
        return target;
    }

    public Aluno peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        else {
            return this.array[this.head];
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public Aluno[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite a capacidade da fila:");
        int siz = sc.nextInt();
        Fila fila = new Fila(siz);

        System.out.println(Arrays.toString(fila.array));
        fila.enqueue(new Aluno("luciano", "1", "1"));
        System.out.println(Arrays.toString(fila.array));
        fila.enqueue(new Aluno("eu", "nao", "sei"));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        System.out.println(Arrays.toString(fila.array));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        fila.enqueue(new Aluno("oi", "chama", "zap"));
        System.out.println(Arrays.toString(fila.array));
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(Arrays.toString(fila.array));
        System.out.println(fila.dequeue());
        System.out.println(Arrays.toString(fila.array));
        fila.enqueue(new Aluno("Luciano", "13254", "aaaaaaaa"));
        fila.enqueue(new Aluno("Ana Carolina","15050", "118110388"));
        System.out.println(fila.peek());
        System.out.println(fila.dequeue());
        System.out.println(fila.peek());
        System.out.println(fila.dequeue());
    }
}