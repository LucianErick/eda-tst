package ArrayList;

public class Aluno {
    private String nome;
    private String cpf;
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.format("NOME: %s - CPF: %s - MATRICULA: %s", getNome(), getCpf(), getMatricula());
    }
}
