package dk.tec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
	
	
	
	private String taskName;
	private String taskDescription;
	private String taskImage;
	private String roomLocation;
	private String createdBy;
	private String completedBy = "";
	private Long createDate;
	private Long completedDate = 0l;
	private Long deadlineDate;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}	
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskImage() {
		return taskImage;
	}
	public void setTaskImage(String taskImage) {
		this.taskImage = taskImage;
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCompletedBy() {
		return completedBy;
	}
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public Long getCompletedDate() 
	{
		return completedDate;
	}
	public void setCompletedDate(Long completedDate) 
	{
		this.completedDate = completedDate;
	}
	public Long getDeadlineDate() 
	{
		return deadlineDate;
	}
	public void setDeadlineDate(Long deadlineDate) 
	{
		this.deadlineDate = deadlineDate;
	}  

	public Task() {}
	public Task(String taskName, String taskDescription, String taskImage, String roomLocation, String createdBy, Long createDate, Long deadlineDate)
	{
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		setTaskImage(taskImage);
		setRoomLocation(roomLocation);
		setCreatedBy(createdBy);
		setCreateDate(createDate);
		setDeadlineDate(deadlineDate);
	}


	public String toString() {
		Date date = new Date(this.getCreateDate());
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String sCreateDate = df.format(date);
		return String.format("Task name: %s \nCreated on: %s", this.getTaskName(), sCreateDate);
	}
	

	

	
}
