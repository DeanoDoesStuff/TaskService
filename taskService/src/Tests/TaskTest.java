package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {

	@Test
	void testTaskConstructor() {
		// Test a valid task
		Task task = new Task("12345", "Test Task", "Test task description.");
		assertEquals("12345", task.getTaskID());
		assertEquals("Test Task", task.getTaskName());
		assertEquals("Test task description.", task.getTaskDescription());
	}
		
    // Test invalid task ID (null)
    @Test
    void testInvalidTaskIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Valid Task Name", "Valid Description");
        });
    }
    
    // Test invalid task ID (too large)
    @Test
    void testInvalidTaskIDLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890123456", "Valid Task Name", "Valid Description");
        });
    }
    
    // Test invalid task name (null)
    @Test
    void testInvalidTaskNameNull() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Task("12345678", null, "Valid Description");
    	});
    }
    
    // Test invalid task name (too large)
    @Test
    void testInvalidTaskNameLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", "This Task Name is Far too Large", "Valid Description");
        });
    }
    
    // Test invalid task name (null)
    @Test
    void testInvalidTaskDescriptionNull() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Task("12345678", "Valid Task Name", null);
    	});
    }
    
    // Test invalid task description (too large)
    @Test
    void testInvalidTaskDescriptionLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", "Valid Task Name", "If too much is written about the task,"
            		+ " the Description Name will be on multiple lines and therefore far too large");
        });
    }
    
    // Test the setter methods
    
    @Test
    void testSetTaskNameValid() {
        Task task = new Task("12345", "Initial Task Name", "Valid Description");
        task.setTaskName("Updated Task Name");
        assertEquals("Updated Task Name", task.getTaskName());
    }
    
    @Test
    void testSetTaskNameInvalid() {
        Task task = new Task("12345", "Initial Task Name", "Valid Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null); // Invalid case
        });
    }
    
    @Test
    void testSetTaskNameLarge() {
    	Task task = new Task("12345", "Initial Task Name", "Valid Description");
    	assertThrows(IllegalArgumentException.class, () -> {
    		task.setTaskName("This Task Name Will Be Far Too Large");
    	});
    }
    
    @Test
    void testSetTaskDescriptionValid() {
        Task task = new Task("12345", "Valid Task Name", "Initial Description");
        task.setTaskDescription("Updated Description");
        assertEquals("Updated Description", task.getTaskDescription());
    }
    
    @Test
    void testSetTaskDescriptionLarge() {
    	Task task = new Task("12345", "Initial Task Name", "Valid Description");
    	assertThrows(IllegalArgumentException.class, () -> {
    		task.setTaskDescription("If too much is written about the task,"
            		+ " the Description Name will be on multiple lines and therefore far too large");
    	});
    }

    @Test
    void testSetTaskDescriptionInvalid() {
        Task task = new Task("12345", "Valid Task Name", "Initial Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null); // Invalid case
        });
    }
}


