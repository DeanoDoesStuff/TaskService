package taskService;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDescription;
	 
	
	// Constructor
	public Task(String taskID, String taskName, String taskDescription) {
		// Validate taskID
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
		this.taskID = taskID;
		
		// Validate Task Name
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		this.taskName = taskName;
		
		// Validate Task Description
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.taskDescription = taskDescription;
	}
	
	// Getters
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	// Setters with validation
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.taskDescription = taskDescription;
	}
}
