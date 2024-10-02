package taskService;

import java.util.ArrayList;
import java.util.List;
/*
 * The task service shall be able to add tasks with a unique ID.
The task service shall be able to delete tasks per task ID.
The task service shall be able to update task fields per task ID. The following fields are updatable:
Name
Description
 * */
public class TaskService {
	// Create a list for tasks to be stored as final so the ID can't be updated
	private final List<Task> taskList = new ArrayList<>();
	
	// Adds a new task to the list
	public void addTask(Task task) {
		if (task != null && getTaskID(task.getTaskID()) == null) {
			taskList.add(task);
		} else {
			throw new IllegalArgumentException("Task ID already exists or is null");
		}
	}
	
	// Deletes a task by its unique ID
	public void deleteTask(String taskID) {
		Task task = getTaskID(taskID);
		if (task != null) {
			taskList.remove(task);
		} else {
			throw new IllegalArgumentException("Task with that ID was not found");
		}
	}
	
	// Update task name and description fields by Unique ID
	public void updateTask(String taskID, String taskName, String taskDescription) {
		Task task = getTaskID(taskID);
		if (task != null) {
			task.setTaskName(taskName);
			task.setTaskDescription(taskDescription);
		} else {
			throw new IllegalArgumentException("Task with that ID was not found");
		}
	}
	
	// Helper method to find a task by its unique ID
	public Task getTaskID(String taskID) {
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				return task;
			}
		}
		return null;
	}
}
