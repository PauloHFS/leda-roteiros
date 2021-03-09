package recursao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetodosRecursivosTest {

    private MetodosRecursivos mr;

    @Before
    public void setUp() throws Exception {
        this.mr = new MetodosRecursivos();
    }

    @Test
    public void calcularSomaArray() {
        assertEquals(0, this.mr.calcularSomaArray(new int[]{0}));
        assertEquals(15, this.mr.calcularSomaArray(new int[]{1,2,3,4,5}));
    }

    @Test
    public void calcularFatorial() {
        assertEquals(1, this.mr.calcularFatorial(0));
        assertEquals(1, this.mr.calcularFatorial(1));
        assertEquals(120, this.mr.calcularFatorial(5));
    }

    @Test
    public void calcularFibonacci() {
        assertEquals(1, this.mr.calcularFibonacci(1));
        assertEquals(1, this.mr.calcularFibonacci(2));
        assertEquals(8, this.mr.calcularFibonacci(6));
    }

    @Test
    public void countNotNull() {
        assertEquals(3, this.mr.countNotNull(new Object[]{null, "Alou", 123, null, 'a', null}));
    }

    @Test
    public void potenciaDe2() {
        assertEquals(1, this.mr.potenciaDe2(0));
        assertEquals(2, this.mr.potenciaDe2(1));
        assertEquals(16, this.mr.potenciaDe2(4));
    }

    @Test
    public void progressaoAritmetica() {
        assertEquals(10, this.mr.progressaoAritmetica(2,2,5),0.1);
        assertEquals(71, this.mr.progressaoAritmetica(26,5,10),0.1);
    }

    @Test
    public void progressaoGeometrica() {
        assertEquals(32, this.mr.progressaoGeometrica(2,2,5),0.1);
        assertEquals(81, this.mr.progressaoGeometrica(1,3,5), 0.1);
    }
}