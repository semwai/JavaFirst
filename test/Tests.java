import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.sbpstu.semwai.javafirst.BinaryThree;

class Tests {
    @Test
    void BaseTest1() {
        BinaryThree b = new BinaryThree(5);
        b.append(7);
        b.append(8);
        b.append(6);
        b.append(2);
        assertTrue(b.find(7));
        assertFalse(b.find(7 + 8 + 6 + 2));
    }

    @Test
    void DeleteTest1() {
        BinaryThree b = new BinaryThree(8);
        b.append(3);
        b.append(10);
        b.append(1);
        b.append(6);
        b.append(4);
        b.append(7);
        b.append(14);
        b.append(13);
        assertTrue(b.find(3));
        b.remove(3);
        assertFalse(b.find(3));
    }

    @Test
    void EqualsTest1() {
        BinaryThree a = new BinaryThree(4);
        BinaryThree a2 = a;
        BinaryThree b = new BinaryThree(4);
        BinaryThree c = new BinaryThree(5);
        assertEquals(a, a2);
        assertNotEquals(a, c);
        assertEquals(a, b);

        BinaryThree n1 = null;
        BinaryThree n2 = null;
        assertEquals(n1, n2);
    }

    @Test
    void EqualsTest2() {
        BinaryThree a = new BinaryThree(4);
        a.append(2);
        a.append(6);
        BinaryThree b = new BinaryThree(4);
        b.append(2);
        b.append(6);
        assertEquals(a, b);
        b.append(42);
        assertNotEquals(a, b);
    }

    @Test
    void FriendTest1() throws Exception {
        BinaryThree a = new BinaryThree(4);
        a.append(6);
        a.append(5);
        a.append(7);
        BinaryThree[] p = a.friends(6);
        assertEquals(p[0].getValue(), 4);
        assertEquals(p[1].getValue(), 5);
        assertEquals(p[2].getValue(), 7);
    }

    @Test
    void FriendTest2() throws Exception {
        BinaryThree b = new BinaryThree(4);
        b.append(3);
        BinaryThree[] p = b.friends(4);
        assertNull(p[0]);
        assertEquals(p[1].getValue(), 3);
        assertNull(p[2]);
        assertThrows(Exception.class, () -> b.friends(232));
    }

    @Test
    void hashTest1() {
        BinaryThree a = new BinaryThree(4);
        a.append(6);
        a.append(5);
        int h1 = a.hashCode();
        a.append(10);
        int h2 = a.hashCode();
        assertNotEquals(h1, h2);
    }
}