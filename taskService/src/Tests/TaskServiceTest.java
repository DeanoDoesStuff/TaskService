package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

class TaskServiceTest {
	private TaskService taskService;
	
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();  // Initialize TaskService before each test
    }
	
    @Test
    public void testAddTask() {
        Task task = new Task("123456", "Task Name", "Task Description");
        taskService.addTask(task);  // Add the task to the service

        // Check that the task was added by verifying that it's retrievable via task ID
        Task retrievedTask = taskService.getTaskID("123456");
        assertNotNull(retrievedTask, "Task should be added successfully");
        assertEquals("123456", retrievedTask.getTaskID());
        assertEquals("Task Name", retrievedTask.getTaskName());
        assertEquals("Task Description", retrievedTask.getTaskDescription());
    }
    
    @Test
    public void testAddDuplicateTask() {
        Task task = new Task("123456", "Task Name", "Task Description");
        taskService.addTask(task);

        // Attempt to add a task with the same ID, should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(new Task("123456", "Duplicate Task Name", "Duplicate Description"));
        });
    }
    
    @Test
    public void testDeleteTask() {
    	// Attempt to delete a valid task
        Task task = new Task("123456", "Task Name", "Task Description");
        taskService.addTask(task);
        
        taskService.deleteTask("123456");
        
        // Ensure the task was deleted
        assertNull(taskService.getTaskID("123456"), "Task should be deleted successfully");
    }
    
    @Test
    public void testDeleteNonExistentTask() {
        // Attempt to delete a non-existent task, should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("999999");
        });
    }
    
    @Test
    public void testUpdateTask() {
        Task task = new Task("123456", "Old Task Name", "Old Task Description");
        taskService.addTask(task);
        
        taskService.updateTask("123456", "Updated Task Name", "Updated Task Description");
        
        Task updatedTask = taskService.getTaskID("123456");
        assertEquals("Updated Task Name", updatedTask.getTaskName());
        assertEquals("Updated Task Description", updatedTask.getTaskDescription());
    }
    
    @Test
    public void testUpdateNonExistentTask() {
        // Attempt to update a non-existent task, should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("999999", "New Task Name", "Updated Task Description");
        });
    }
}











