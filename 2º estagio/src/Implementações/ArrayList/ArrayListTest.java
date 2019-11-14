package ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList arrayList;
    ArrayList arrayList1;
    Aluno aluno;
    Aluno aluno1;
    @BeforeEach
    void setUp() {
        arrayList = new ArrayList();
        arrayList1 = new ArrayList(15);
        aluno = new Aluno("Luciano", "092.491.584-67", "118110400");
        aluno1 = new Aluno("Pedro", "235.687.744-21", "124110321");
    }

    @Test
    void add() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno);
        arrayList.add(aluno1);
        assertEquals(2, arrayList.getSize());
        assertNotEquals(0, arrayList.getSize());
    }

    @Test
    void testAdd() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(0, aluno1);
        arrayList.add(0, aluno);
        assertEquals(2, arrayList.getSize());
        assertNotEquals(0, arrayList.getSize());
    }

    @Test
    void set() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno);
        arrayList.set(0, aluno1);
        assertEquals(1, arrayList.getSize());
        assertNotEquals(0, arrayList.getSize());
        assertEquals("NOME: Pedro - CPF: 235.687.744-21 - MATRICULA: 124110321", arrayList.get(0).toString());

    }

    @Test
    void remove() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno);
        arrayList.set(0, aluno1);
        assertEquals(1, arrayList.getSize());
        arrayList.remove(0);
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno1);
        arrayList.add(aluno);
        arrayList.remove(aluno1);
        assertEquals(aluno.toString(), arrayList.get(0).toString());
    }

    @Test
    void indexOff() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno);
        arrayList.set(0, aluno1);
        assertEquals(1, arrayList.getSize());
        arrayList.remove(0);
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno1);
        arrayList.add(aluno);
        arrayList.remove(aluno1);
        assertEquals(aluno.toString(), arrayList.get(0).toString());
        arrayList.add(aluno);
        assertEquals(0,arrayList.indexOff(aluno));
        assertEquals(-1, arrayList.indexOff(aluno1));
    }

    @Test
    void contains() {
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno);
        arrayList.set(0, aluno1);
        assertEquals(1, arrayList.getSize());
        arrayList.remove(0);
        assertEquals(0, arrayList.getSize());
        arrayList.add(aluno1);
        arrayList.add(aluno);
        arrayList.remove(aluno1);
        assertEquals(aluno.toString(), arrayList.get(0).toString());
        arrayList.add(aluno);
        assertEquals(0,arrayList.indexOff(aluno));
        assertEquals(-1, arrayList.indexOff(aluno1));
        assertTrue(arrayList.contains(aluno));
        assertFalse(arrayList.contains(aluno1));

    }
}