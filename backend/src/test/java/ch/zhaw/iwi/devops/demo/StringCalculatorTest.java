package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
   
    @Test
    void StringCalculatorAdd() {
        StringCalculator calculator = new StringCalculator();

        assertEquals(5, calculator.add("2,3"));
        assertEquals(15, calculator.add("10,5"));
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        assertEquals(3, calculator.add("1,2"));
        assertEquals(11, calculator.add("5,6"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(5, calculator.add("//;\n2;3"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("Negatives not allowed: [-2, -4]", exception.getMessage());

        assertEquals(1002, calculator.add("1000,2"));
        assertEquals(1002, calculator.add("2,1000"));
        assertEquals(2, calculator.add("1001,2"));
        assertEquals(1002, calculator.add("1001,1000,2"));
        assertEquals(1005, calculator.add("1000,1005,0,5"));

    }
}
