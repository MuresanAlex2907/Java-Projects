package model;

public class Task {
	
	
	private int processingTime;
	private int taskNo;
	private int waitingTime;
	private int arrivalTime;
	
	public Task() {
		
	}
	
	public Task(int processingTime,int taskNo,int arrivalTime) {
		this.arrivalTime=arrivalTime;
		this.processingTime=processingTime;
		this.taskNo=taskNo;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getWaitingTime() {
		return this.waitingTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}

	
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}


	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

}
