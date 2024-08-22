import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testMainExceptionHandling() {
        // Перенаправить System.out для захвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Имитировать исключение в основном методе
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            // Этого не должно произойти
            fail("Исключение должно обрабатываться в основном методе.");
        }

        // Проверьте, содержит ли вывод ожидаемое сообщение об ошибке.
        String expectedMessage = "Произошла ошибка: ";
        assertTrue(outContent.toString().contains(expectedMessage));

        // Сбросить System.out
        System.setOut(System.out);
    }
}