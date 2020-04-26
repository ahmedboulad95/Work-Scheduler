import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WorkStationManager {
	private HashMap<String, WorkStation> workStationMap;
	
	public WorkStationManager() {
		try {
			generateWorkstationMap();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	private void generateWorkstationMap() throws Exception {
		workStationMap = new HashMap<String, WorkStation>();
		JSONArray workStationArray = (JSONArray) new JSONParser().parse(new FileReader("src/data/workstations.json"));
		
		for(Object obj: workStationArray) {
			JSONObject jsonObject = (JSONObject) obj;
			
			String name = (String)jsonObject.get("name");
			Long numEmployees = (Long)jsonObject.get("numEmployees");
			Boolean isDefault = (Boolean)jsonObject.get("isDefault");
			Long priorityLevel = (Long)jsonObject.get("priorityLevel");
			
			WorkStation workStation = new WorkStation(name, numEmployees, isDefault, priorityLevel);
			workStationMap.put(name, workStation);
		}
	}
	
	public ArrayList<WorkStation> getWorkStationListByPriority() {
		ArrayList<WorkStation> workStations = new ArrayList<WorkStation>(this.workStationMap.values());
		Collections.sort(workStations);
		return workStations;
	}
}
