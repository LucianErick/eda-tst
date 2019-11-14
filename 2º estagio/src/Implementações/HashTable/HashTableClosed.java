package HashTable;
import Fila.Aluno;

import java.util.ArrayList;
import java.util.Iterator;

public class HashTableClosed {

    private ArrayList<Aluno>[] tabela;

    public HashTableClosed() {
        this.tabela = new ArrayList[20];
    }

    public HashTableClosed(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    private int hashMultiplication(int chave) {

    }

    public Aluno get(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null) return null;

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == chave) {
                return aluno;
            }
        }
        return null;
    }

    public void put(int chave, Aluno valor) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getMatricula() == chave) {
                    alunos.set(i, valor);
                    return;
                }
            }
            alunos.add(valor);
        }
    }

    public Aluno remove(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        Iterator<Aluno> iterator = alunos.iterator();
        Aluno atual = null;

        while (iterator.hasNext()) {
            atual = iterator.next();
            if (atual.getMatricula() == chave) {
                iterator.remove();
                return atual;
            }
        }
        return atual;
    }

}
