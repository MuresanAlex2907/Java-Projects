package monitored_data;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
/*
 * class which represent the data read form file
 * we have start time, end time and the activity done in this interval
 */
public class MonitoredData {
	private String startTime;
	private String endTime;
	private String activity;

	private static ArrayList<MonitoredData> data = new ArrayList<MonitoredData>();

	public MonitoredData() {

	}

	
	/**
	 * this method splits a line into start time, end time and activity and assign them to monitored data attributes
	 * @param data the hole line of data
	 */
	public MonitoredData(String data) {
		this.startTime = data.split("\t\t")[0];
		this.endTime = data.split("\t\t")[1];
		this.activity = data.split("\t\t")[2];

	}

	/**
	 * 
	 * @return the start time of selected activity
	 */
	public String getStartTime() {
		return startTime;
	}

	
	/**
	 *sets the start time 
	 * @param startTime value of start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 
	 * @return end time of selected data
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 *sets the end time 
	 * @param endTime value of end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 
	 * @return activity of selected data
	 */
	
	public String getActivity() {
		return activity;
	}

	/**
	 *sets the activity 
	 * @param activity value of activity
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * 
	 * @return all data
	 */
	public static ArrayList<MonitoredData> getData() {
		return data;
	}

	@SuppressWarnings("static-access")
	public void setData(ArrayList<MonitoredData> data) {
		this.data = data;
	}

	
	/**
	 *adds a new data in the arraylist of monitored data
	 * @param toAdd data to be added
	 */
	public static void add(String toAdd) {
		MonitoredData aux = new MonitoredData(toAdd);
		data.add(aux);

	}

	/**
	 * method used to get the total duration of an activity
	 * @param activity 
	 * @return total duration of the activity given as parameter
	 */
	public static Duration getDuration(String activity) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
		LocalDateTime startDate = null;
		LocalDateTime endDate = null;
		Duration duration=Duration.ZERO;
		
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getActivity().equals(activity)) {
				
				startDate = LocalDateTime.parse(data.get(i).getStartTime(), dtf);
				endDate = LocalDateTime.parse(data.get(i).getEndTime(), dtf);
	
				duration=duration.plus(Duration.between(startDate, endDate));
                 
			}

		}
		return duration;
	}
	
	/**
	 * method used to get the duration between two time periods
	 * @param start start of the time period
	 * @param end end of the time period
	 * @return difference of time between start and end
	 */
	public static Duration localDuration(String start,String end) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
		LocalDateTime startDate = null;
		LocalDateTime endDate = null;
		
		
		startDate = LocalDateTime.parse(start, dtf);
		endDate = LocalDateTime.parse(end, dtf);

		return Duration.between(startDate, endDate);
         
		
		
	}

	public String getStartSub() {
		
		return startTime.substring(8, 10);
	}

	/**
	 * 
	 * @return number of distinct days in monitored data
	 */
	public static int nrDays() {
		List<String> dates = data.stream().
				map(MonitoredData::getStartSub).distinct().collect(Collectors.toList());

		return dates.size();

	}

	
	/**
	 * method used to find all the activities in the monitored data and how often they are made
	 * @return distinct activities and their occurance number
	 */
	public static HashMap<String, Integer> distinctActivities() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		List<String> activities = data.stream().map(MonitoredData::getActivity).distinct().collect(Collectors.toList());

		
		activities.stream().forEach(Activity->{;	
		int size = data.stream().filter(d -> d.getActivity().equals(Activity)).collect(Collectors.toList()).size();
			result.put(Activity, size);
		});
		return result;
	}

	
	/**
	 * method used to find all the activities made in each day find in monitored data
	 * @return the day with a list of all activities done in that day
	 */
	public static HashMap<Integer, HashMap<String, Integer>> activityCountDiffDays() {
		List<String> activities = data.stream().map(MonitoredData::getActivity).distinct().collect(Collectors.toList());
		List<String> dates = data.stream().map(MonitoredData::getStartSub).distinct().collect(Collectors.toList());

		HashMap<Integer, HashMap<String, Integer>> result = new HashMap<Integer, HashMap<String, Integer>>();
		int dataIndex = 1;
		
		for (String currDate : dates) {
			HashMap<String, Integer> actInDay = new HashMap<String, Integer>();
			for (String aux1 : activities) {
				int size = data.stream().filter(d -> d.getActivity().equals(aux1) && d.getStartSub().equals(currDate))
						.collect(Collectors.toList()).size();
				actInDay.put(aux1, size);
			}
			result.put(dataIndex, actInDay);
			dataIndex++;
		}

		return result;

	}
	
	/**
	 * method used to calculate the activities that last more than 10 hours
	 * @return the activities with a total duration bigger than 10 hours
	 */
	public static HashMap<String,Duration> activityByTime(){
		HashMap<String,Duration> result=new HashMap<String,Duration>();
		
		List<String> activitiesMoreTen=null;
		List<String> activities = data.stream().map(MonitoredData::getActivity).
				distinct().collect(Collectors.toList());
		
		activitiesMoreTen=activities.stream().filter(a->MonitoredData.getDuration(a).toHours()>10).collect(Collectors.toList());
		
			activitiesMoreTen.stream().forEach(Activity->{
			result.put(Activity, MonitoredData.getDuration(Activity));
		});
		return result;
	}
	
	/**
	 * method used to calculate the activities that have 90% of their duration less than 5 minutes
	 * @return the activities that have 90% of their duration less than 5 minutes
	 */
	public static List<String> durationLessFive(){
		List<String> result=new ArrayList<String>();
		
		HashMap<String,Integer> goodActivities=new HashMap<String,Integer>();
		
		HashMap<String, Integer> allActivities=MonitoredData.distinctActivities();
		List<String> activities = data.stream().map(MonitoredData::getActivity).
				distinct().collect(Collectors.toList());
		
	
			activities.stream().forEach(Activity->{
			int size = data.stream().filter(d -> d.getActivity().equals(Activity) && MonitoredData.
					localDuration(d.getStartTime(), d.getEndTime()).toMinutes()<5).
					collect(Collectors.toList()).size();
			goodActivities.put(Activity, size);
		});

			activities.forEach(Activity->{
			if(goodActivities.get(Activity)>0){
				if((float)(goodActivities.get(Activity)/allActivities.get(Activity))>=0.9)
					result.add(Activity);
			}
			//System.out.println(aux+ " "+goodActivities.get(aux));
		});
		
		return result;
		
	}

}
