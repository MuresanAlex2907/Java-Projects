package Assignment5.Assignment5;

import java.time.Duration;

import java.util.HashMap;
import java.util.List;

import monitored_data.MonitoredData;
import work_with_file.ReadFromFIle;

/**
 * here we call all the created methods and print the result
 *
 */
public class App {
	public static void main(String[] args) {
		ReadFromFIle.readData();
		//ArrayList<MonitoredData> data = new ArrayList<MonitoredData>();

		// print number of distinct days

		//data = MonitoredData.getData();
		System.out.println("Number of distinct days is: " + MonitoredData.nrDays());

		// print distinct activities
		System.out.println();
		System.out.println("Activities and number of occurences:");
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		result = MonitoredData.distinctActivities();

		result.entrySet().stream().forEach(Activity -> {
			System.out.println(Activity.getKey().trim() + " " + Activity.getValue());
		});

		//Activity in each day
		System.out.println();
		System.out.println("Activities in each day");

		HashMap<Integer, HashMap<String, Integer>> eachDay = MonitoredData.activityCountDiffDays();
         
		for(int i=1;i<=eachDay.size();i++) {
			HashMap<String,Integer> aux=new HashMap<String,Integer>();
			System.out.println("Day "+i);
			aux=eachDay.get(i);
			aux.entrySet().stream().forEach(Activity->{
				System.out.print(Activity.getKey().trim()+" "+Activity.getValue()+"   ");
			});
			System.out.println();	
		}
	//Activity duration
		System.out.println();
		System.out.println("Activity duration");
		HashMap<String,Duration> activityDuration=new HashMap<String,Duration>();
		activityDuration=MonitoredData.activityByTime();
		activityDuration.entrySet().stream().forEach(Activity->{
			System.out.println(Activity.getKey().trim()+" "+Activity.getValue());
		});
	//90% activities
		System.out.println();
		List<String> lessThanFive=MonitoredData.durationLessFive();
		System.out.println("Activities with 90%");
		lessThanFive.stream().forEach(Activity->{
			System.out.println(Activity);
		});
	}
}
