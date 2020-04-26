import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class EmployeeManager {
	private HashMap<String, Employee> employeeMap;
	private ArrayList<Employee> orderedEmployees;
	
	public EmployeeManager() {
		try {
			this.generateEmployeeMap();
			this.setOrderedEmployees();
			System.out.println(employeeMap);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public ArrayList<Employee> getOrderedEmployees() {
		return this.orderedEmployees;
	}
	
	public Employee getNextAvailableEmployee() {
		Employee nextEmployee = orderedEmployees.get(0);
		
		// Move the employee to the end of the list
		orderedEmployees.add(nextEmployee);
		orderedEmployees.remove(0);
		return nextEmployee;
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
	
	private void setOrderedEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>(this.employeeMap.values());
		Collections.sort(employees);
		this.orderedEmployees = employees;
	}
}
