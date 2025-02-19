package boink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import boink.tasks.ToDoTask;
import boink.exceptions.InvalidIndexException;

public class TaskListTest {
    @Test
    public void testLoadTask() {
        TaskList tasks = new TaskList();
        ToDoTask todo = new ToDoTask("Test");
        tasks.addTask(todo);
        assertEquals(tasks.getSize(), 1);
    }

    @Test
    public void testDeleteTask() throws InvalidIndexException {
        TaskList tasks = new TaskList();
        ToDoTask todo = new ToDoTask("Test");
        tasks.addTask(todo);
        assertEquals(tasks.getSize(), 1);
        InvalidIndexException exception = assertThrows(InvalidIndexException.class, () -> {
            tasks.deleteTask(-1);
        });
        String output = "Index does not match to a task!";
        assertEquals(output, exception.getMessage());
        tasks.deleteTask(0);
        assertEquals(tasks.getSize(), 0);
    }
}
