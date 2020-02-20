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
        assertFalse(b.find(7+8+6+2));
    }
    @Test
    void BaseTest2() {
        BinaryThree b = new BinaryThree(4);
        b.append(2);
        b.append(1);
        b.append(3);
        b.append(8);
        b.append(6);
        b.append(9);
        b.append(7);
        // https://jsonformatter.curiousconcept.com/
        System.out.println(b.toJSON());
        b = b.remove(8);
        System.out.println(b.toJSON());
        assertTrue(b.find(6));
        assertFalse(b.find(8));
    }
    @Test
    void DeleteTest(){
        BinaryThree b = new BinaryThree(5);
        b.append(3);
        b.append(2);
        b.append(4);
        b.append(8);
        b.append(7);
        b.append(6);
        b.append(10);
        b.append(9);
        b.append(11);
        System.out.println(b.toJSON());
        b.remove(8);
        System.out.println(b.toJSON());
    }
    @Test
    void EqualsTest1(){
        BinaryThree a = new BinaryThree(4);
        BinaryThree a2 = a;
        BinaryThree b = new BinaryThree(4);
        BinaryThree c = new BinaryThree(5);
        assertEquals(a, a2);
        assertNotEquals(a, c);
        assertEquals(a, b);
    }
    @Test
    void EqualsTest2(){
        BinaryThree a = new BinaryThree(4);
        a.append(2);
        a.append(6);

        BinaryThree b = new BinaryThree(4);
        b.append(2);
        b.append(6);

        assertEquals(a,b);

        b.append(42);

        assertNotEquals(a,b);
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
}