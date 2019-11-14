package HashTable;
import Fila.Aluno;

import java.util.ArrayList;
import java.util.Iterator;

public class HashTableOpen {

    private Aluno[] tabela;

    public HashTableOpen() {
        this.tabela = new Aluno[20];
    }

    public HashTableOpen(int capacidade) {
        this.tabela = new Aluno[capacidade];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    public void put(int chave, Aluno valor) {
        int sondagem = 0;
        int hash;
        while (sondagem < this.tabela.length) {
            hash = (hash(chave) + sondagem) % this.tabela.length;
            if (this.tabela[hash] == null || this.tabela[hash].getMatricula() == chave) {
                this.tabela[hash] = valor;
                return;
            }
            sondagem++;
        }
        throw new IllegalArgumentException("Tabela Cheia!");
    }

}

