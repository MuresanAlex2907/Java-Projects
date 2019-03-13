package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.ExecutionView;

public class SimulationManager implements Runnable {

	public int timeLimit;
	public int minProcessingTime;
	public int maxProcessingTime;
	public int nrOfServers;
	public int nrOfTasks;
	
	public int minATime;
	public int maxAtime;
	//public String text;

	private ExecutionView ev;
	private ArrayList<Task> tasks;
	public Server[] servers;

	public SimulationManager(int timeLimit, int nrOfServers, int nrOfTasks, int minPTime, int maxPTime,
				int minATime, int maxATime, ExecutionView ev) {

		this.timeLimit = timeLimit;

		this.nrOfServers = nrOfServers;
		this.nrOfTasks = nrOfTasks;
		this.minProcessingTime = minPTime;
		this.maxProcessingTime = maxPTime;
		
		this.maxAtime = maxATime;
		this.minATime = minATime;
		this.ev = ev;
		tasks = this.generateRandomTasks();
		servers = new Server[nrOfServers];
		for (int i = 0; i < nrOfServers; i++) {
			servers[i] = new Server(i, ev);
			this.openServer(servers[i]);
		}
	}

	public ArrayList<Task> generateRandomTasks() {
		ArrayList<Task> taskuri = new ArrayList<Task>();
		Random random = new Random();
		for (int i = 0; i < this.nrOfTasks; i++) {
			int pt = random.nextInt(this.maxProcessingTime - this.minProcessingTime) + this.minProcessingTime;
			int nr = random.nextInt(200);
			int at = random.nextInt(this.maxAtime - this.minATime) + this.minATime;
			Task t = new Task(pt, nr, at);
			taskuri.add(t);

		}
		return taskuri;
	}

	public Task minArrTime() {
		int min = Integer.MAX_VALUE;
		Task t1 = new Task();
		for (Task t : tasks) {
			if (t.getArrivalTime() < min) {
				min = t.getArrivalTime();
				t1 = t;
			}
		}
		return t1;

	}

	public Server goodServer() {
		int min = Integer.MAX_VALUE;

		Server aux = new Server();
		for (Server s : servers) {
			if (s.getWaitingTime() < min) {
				min = s.getWaitingTime();
				aux = s;

			}
		}
		return aux;
	}

	public synchronized void openServer(Server s) {
		Thread t = new Thread(s);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int currentTime = 0;
		int totalWaitingTime = 0;
		Task t = new Task();
		Server s = new Server();
		int max=0;
		int nrTask=0;
		int peakHour=0;

		try {
			while (currentTime < timeLimit && !tasks.isEmpty()) {

				t = this.minArrTime();
				s = this.goodServer();
				s.setText();
				t.setWaitingTime(s.getWaitingTime());
				totalWaitingTime += t.getWaitingTime();

				s.addTask(t);
				nrTask++;
				s.setText();
                if(s.getNrTasks()>max) {
                	max=s.getNrTasks();
                	peakHour=currentTime;
                }
				// System.out.println("tasks size " + tasks.size());
               
				ev.t1.append("Task: " + t.getTaskNo() + " was added at server " + (s.getId() + 1) + " arrival time "
						+ t.getArrivalTime() + "\n");
				// Thread.sleep(1000);
				currentTime += 1000;
				// System.out.println(currentTime+ " "+timeLimit);
				Thread.sleep(t.getArrivalTime());

				tasks.remove(t);

			}

		} catch (InterruptedException e) {
			System.out.print("Wrong thread");
		}
//		for (Server s1 : servers) {
//			if (s1.getNrTasks() == 0)
//				s1.stopThread(currentTime, timeLimit);
//		}
		ev.t1.append("Total waiting time is: " + totalWaitingTime / 1000 + "s \n"+
				"Average waiting tims is: "+(float)(totalWaitingTime/nrTask)/1000+"s \n"+
				"Peak hour is after:"+ peakHour/1000+"s\n");
		//ev.t1.append("Average waiting tims is: "+(float)(totalWaitingTime/this.nrOfTasks)/1000+"s \n");
	}
	

}
