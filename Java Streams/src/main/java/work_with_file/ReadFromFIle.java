package work_with_file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

import monitored_data.MonitoredData;
/**
 * This class is used to read from file using streams
 * @author Alex
 *
 */
public class ReadFromFIle {
	
		
  /**
   * method used for reading from file
   * for each line we separate the string and add it to the list of Data
   */
	public static void readData() {
		String fileName = "Activity.txt";
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			 
			stream.forEach(item->MonitoredData.add(item));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
