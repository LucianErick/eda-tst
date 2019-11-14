package ArrayList;

public class ArrayList {
    private Aluno[] array;
    private int size;

    public ArrayList(int capacidade) {
        this.array = new Aluno[capacidade];
        this.size = 0;
    }

    public ArrayList() {
        this.array = new Aluno[20];
        this.size = 0;
    }

    public Aluno[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    // Métodos de Adicionar um novo elemento no ArrayList.

    // Adiciona um novo elemento no final.
    public boolean add(Aluno aluno) {
        assegureCapacity(this.size + 1);
        this.array[this.size++] = aluno;
        return true;
    }

    // Adiciona um novo elemento na posição desejada.
    public boolean add(int index, Aluno aluno) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        assegureCapacity(this.size + 1);
        shiftRight(index);
        this.array[index] = aluno;
        this.size++;
        return true;
    }

    // Muda o valor de uma determinada posição.
    public void set(int index, Aluno aluno) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index] = aluno;
    }

    // Métodos de Remover um elemento no Array.

    // Remove um objeto pelo índice.
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        shiftLeft(index);
        this.size--;
        return true;
    }

    // Remove um objeto pelo valor.
    public boolean remove(Aluno target) {
        if (target == null) {
            return false;
        }

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(target)){
                remove(i);
                this.size--;
                return true;
            }
        }
        return false;
    }

    // Métodos de busca de um elemento no Array.

    // Procura um objeto pelo seu indice.
    public Aluno get(int index) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    // Retorna o indice de um determinado objeto.
    public int indexOff(Aluno aluno) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(aluno)) {
                return i;
            }
        }
        return -1;
    }

    // Retorna se existe o objeto desejado no Array.
    public boolean contains(Aluno aluno) {
        return indexOff(aluno) != -1;
    }


    private void assegureCapacity(int capacityRequired) {
        if (capacityRequired > this.array.length) {
            resize(this.array.length * 2);
        }
    }

    private void resize(int newCapacity) {
        Aluno[] newArray = new Aluno[newCapacity];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    private void shiftLeft(int index) {
        if (index > this.array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
    }
    private void shiftRight(int index) {
        if (index > this.array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = this.size; i > index ; i--) {
            this.array[i] = this.array[i - 1];
        }
    }
}