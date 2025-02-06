package boink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import boink.exceptions.BoinkException;
import boink.exceptions.TaskInputException;

public class ParserTest {

    @Test
    public void testInvalidDateFormat() {
        BoinkException exception = assertThrows(TaskInputException.class, () -> {
            Parser.parse("deadline /by 01/01/01 1234");
        });

        String output = "The input format for adding tasks is invalid. Error: Date Format";
        assertEquals(output, exception.getMessage());
    }

    @Test
    public void testEmptyInput() {
        BoinkException exception = assertThrows(BoinkException.class, () -> {
            Parser.parse("");
        });

        String output = "Empty input. Please enter a valid command!";
        assertEquals(output, exception.getMessage());
    }
}
