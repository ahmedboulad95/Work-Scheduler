import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class EmployeeManager {
	private HashMap<String, Employee> employeeMap;
	
	public EmployeeManager() {
		try {
			this.generateEmployeeMap();
			System.out.println(employeeMap);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void generateEmployeeMap() throws Exception {
		employeeMap = new HashMap<String, Employee>();
		JSONArray employeeArray = (JSONArray) new JSONParser().parse(new FileReader("src/data/employee_datasheet.json"));
		
		for(Object obj: employeeArray) {
			JSONObject jsonObject = (JSONObject) obj;
			
			String employeeId = (String)jsonObject.get("employeeId");
			String name = (String)jsonObject.get("name");
			Long orderPosition = (Long)jsonObject.get("orderPosition");
			
			Employee employee = new Employee(employeeId, name, orderPosition);
			employeeMap.put(employeeId, employee);
		}
	}
	
	public Collection<Employee> getOrderedEmployees() {
		return this.employeeMap.values();
	}
}
