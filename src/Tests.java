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
        assertFalse(b.find(17));
    }
}