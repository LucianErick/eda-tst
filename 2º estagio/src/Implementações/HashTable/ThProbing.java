package HashTable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ThProbing {
    private Objeto[] tabela;
    private Set<Integer> chaves;
    private Set<String> valores;
    private int tamanho;
    private double fatorDeCarga;

    public ThProbing(int capacidade) {
        this.tabela = new Objeto[tamanho];
        this.chaves = new HashSet<Integer>();
        this.valores = new HashSet<String>();
        this.tamanho = 0;
        this.fatorDeCarga = 0.75;
    }

    private int hash(int chave){
        int tamanhoTabela = this.tabela.length;
        return chave % tamanhoTabela;
    }

    public String put(Integer chave, String valor) {
        if (this.tamanho / this.tabela.length >= this.fatorDeCarga ||
                this.tamanho == this.tabela.length) {
            // Criando uma nova e reiniciando a tabela.
            Objeto[] novaTabela = new Objeto[this.tabela.length * 2];
            this.tamanho = 0;
            this.chaves = new HashSet<Integer>();
            this.valores = new HashSet<String>();
            //
            for (Objeto objeto : this.tabela) {
                if (objeto != null) {
                    put()
                }
            }
        }

    }

    private void put(Objeto[] tabela, Integer chave, String valor) {
        int sondagem = 0;
        int hash;
        while (sondagem < this.tabela.length) {
            hash = (hash(chave) + sondagem) % this.tabela.length;
            Objeto auxObj = this.tabela[hash];
            if (auxObj == null) {

            }
        }
    }

    public Set<Integer> getChaves() {
        return chaves;
    }

    public Set<String> getValores() {
        return valores;
    }
}

class Objeto {
    int numero;
    String texto;

    public Objeto(int numero, String texto) {
        this.numero = numero;
        this.texto = texto;
    }

    public int getNumero() {
        return numero;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objeto objeto = (Objeto) o;
        return numero == objeto.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
