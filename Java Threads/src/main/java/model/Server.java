package model;

import java.util.ArrayList;

import view.ExecutionView;

public class Server implements Runnable {
    private boolean ok;
	private ArrayList<Task> tasks;
	private int waitingTime;
	private int id;
	private ExecutionView ev;
	private String answer;

	public Server(int id, ExecutionView ev) {
		this.waitingTime = 0;
		this.id = id;
		tasks = new ArrayList<Task>();
		this.ev = ev;
		this.answer = "";
		this.ok=true;
	}

	public Server() {

	}

	public int getId() {
		return id;
	}
    public void setOk() {
    	this.ok=false;
    }
	public void stopThread(int a,int b) {
		//System.out.println(tasks.size());
		while(tasks.size()>0 && a<b);
		if(tasks.size()==0)
		   this.ok=false;
	}
	public void setId(int id) {
		this.id = id;
	}

	public synchronized void addTask(Task newTask) {
		this.tasks.add(newTask);
		// this.waitingTime=newTask.getProcessingTime()+this.waitingTime;
	}

	public int getNrTasks() {
		return this.tasks.size();
	}

	public synchronized int getWaitingTime() {
		int time = 0;
		for (Task t : tasks) {
			time = time + t.getProcessingTime();
		}

		return time;
	}

	public synchronized void setText() {

		//System.out.println("Setez pt " + (this.id + 1));
		for (Task t1 : tasks) {
			this.answer = this.answer + Integer.toString(t1.getTaskNo()) + " ";
		}
		if (this.id == 0) {
			//System.out.println("1");
			ev.setTf1(answer);
			this.answer = "";
		}
		if (this.id == 1) {
			//System.out.println("2");
			ev.setTf2(answer);
			this.answer = "";
		}
		if (this.id == 2) {
			ev.setTf3(answer);
			this.answer = "";
		}
		if (this.id == 3) {
			ev.setTf4(answer);
			this.answer = "";
		}
		
		if (this.id == 4) {
			ev.setTf5(answer);
			this.answer = "";
		}
		if (this.id == 5) {
			ev.setTf6(answer);
			this.answer = "";
		}
		if (this.id == 6) {
			ev.setTf7(answer);
			this.answer = "";
		}
		if (this.id == 7) {
			ev.setTf8(answer);
			this.answer = "";
		}
	}

	@Override
	public void run() {

		try {
			while (ok) {
				System.out.println();
				
				if (tasks.size() > 0) {
					
					Task t = tasks.get(0);
					//System.out.println(t.getTaskNo());
					int time = t.getProcessingTime();
					t.setWaitingTime(this.getWaitingTime()-t.getArrivalTime());
					 this.setText();
					Thread.sleep(time);
					ev.t1.append(
							"Task: " + t.getTaskNo()+ " with processing time " + t.getProcessingTime() + " exited the queue\n");
					tasks.remove(t);
					this.setText();
				}
//				if(tasks.size()==0)
//					 this.ok=false;
//				else this.ok=true;
			}
		} catch (InterruptedException e) {
			System.out.println("Tasks was not done");
		}

	}

}
