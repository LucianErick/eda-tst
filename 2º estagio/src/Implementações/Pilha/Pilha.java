package Pilha;
import Fila.Aluno;
import java.util.Arrays;
import java.util.Scanner;

public class Pilha {
    private int top;
    private int capacidade;
    private Aluno[] array;

    public Pilha(int capacidade) {
        this.top = -1;
        this.top = -1;
        this.capacidade = capacidade;
        this.array = new Aluno[capacidade];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == (this.capacidade - 1);
    }

    public void push(Aluno aluno) {
        if (isFull()) {
            throw new IllegalArgumentException("Stack is full!");
        }
        this.top++;
        this.array[this.top] = aluno;
    }

    public Aluno pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        Aluno target;
        target = this.array[this.top];
        this.array[this.top] = null;
        this.top--;

        return target;
    }

    public Aluno peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        Aluno target;
        target = this.array[this.top];
        return target;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho desejado:");
        int size = sc.nextInt();
        Pilha pilha = new Pilha(size);

        pilha.push(new Aluno("Luciano", "11", "23"));
        System.out.println(Arrays.toString(pilha.array));
        pilha.push(new Aluno("Oi", "123", "5216"));
        System.out.println(Arrays.toString(pilha.array));
        pilha.push(new Aluno("Oi", "123", "5216"));
        pilha.push(new Aluno("Oi", "123", "5216"));
        pilha.push(new Aluno("Oi", "123", "5216"));
        pilha.push(new Aluno("Oi", "123", "5216"));
        pilha.push(new Aluno("Oi", "123", "5216"));
        pilha.push(new Aluno("Oi", "123", "5216"));
        System.out.println(Arrays.toString(pilha.array));
        System.out.println(pilha.pop());
        System.out.println(pilha.peek());
        System.out.println(Arrays.toString(pilha.array));
        System.out.println(pilha.pop());
        System.out.println(pilha.peek());
        System.out.println(Arrays.toString(pilha.array));
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        System.out.println(Arrays.toString(pilha.array));
    }
}
