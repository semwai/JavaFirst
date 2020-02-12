import com.sbpstu.semwai.javafirst.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void Test1() {
        BinaryThree b = new BinaryThree(5);
        b.append(7);
        b.append(8);
        b.append(6);
        b.append(2);
        assertTrue(b.find(7));
        assertFalse(b.find(7+8+6+2));
    }
    @Test
    void Test2() {
        BinaryThree b = new BinaryThree(4);
        b.append(2);
        b.append(1);
        b.append(3);
        b.append(8);
        b.append(6);
        b.append(9);
        b.append(7);

        b.remove(8);

        assertTrue(b.find(6));
        assertFalse(b.find(8));
    }
}