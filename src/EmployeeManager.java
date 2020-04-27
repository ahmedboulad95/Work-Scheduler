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
	private ArrayList<Employee> currentWorkingEmployees;
	private int nextEmployeeIndex;
	
	public EmployeeManager() {
		try {
			this.generateEmployeeMap();
			this.setOrderedEmployees();
			nextEmployeeIndex = 0;
			System.out.println(employeeMap);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Employee getNextAvailableEmployee() {
		if(this.nextEmployeeIndex >= this.currentWorkingEmployees.size()) {
			return null;
		}
		
		Employee nextEmployee = this.currentWorkingEmployees.get(this.nextEmployeeIndex);
		long nextOrderPosition = this.getNextOrderPosition(nextEmployee);
		nextEmployee.setOrderPosition(nextOrderPosition);
		this.nextEmployeeIndex++;
		
		return nextEmployee;
	}
	
	public void setWorkingEmployees(Week.Weekdays day) {
		this.setOrderedEmployees();
		this.currentWorkingEmployees = new ArrayList<Employee>();
		
		for(Employee employee: this.orderedEmployees) {
			if(employee.isWorkingOn(day)) {
				this.currentWorkingEmployees.add(employee);
			}
		}
		this.nextEmployeeIndex = 0;
	}
	
	private void generateEmployeeMap() throws Exception {
		employeeMap = new HashMap<String, Employee>();
		JSONArray employeeArray = (JSONArray) new JSONParser().parse(new FileReader("src/data/employee_datasheet.json"));
		
		for(Object obj: employeeArray) {
			JSONObject jsonObject = (JSONObject) obj;
			
			String employeeId = (String)jsonObject.get("employeeId");
			String name = (String)jsonObject.get("name");
			Long orderPosition = (Long)jsonObject.get("orderPosition");
			
			HashMap<Week.Weekdays, Boolean> workingDaysMap = new HashMap<Week.Weekdays, Boolean>();
			JSONObject workingDayJson = (JSONObject)jsonObject.get("workingDays");
			workingDaysMap.put(Week.Weekdays.MONDAY, (Boolean)workingDayJson.get("MONDAY"));
			workingDaysMap.put(Week.Weekdays.TUESDAY, (Boolean)workingDayJson.get("TUESDAY"));
			workingDaysMap.put(Week.Weekdays.WEDNESDAY, (Boolean)workingDayJson.get("WEDNESDAY"));
			workingDaysMap.put(Week.Weekdays.THURSDAY, (Boolean)workingDayJson.get("THURSDAY"));
			workingDaysMap.put(Week.Weekdays.FRIDAY, (Boolean)workingDayJson.get("FRIDAY"));
			
			Employee employee = new Employee(employeeId, name, orderPosition, workingDaysMap);
			employeeMap.put(employeeId, employee);
		}
	}
	
	private void setOrderedEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>(this.employeeMap.values());
		Collections.sort(employees);
		this.orderedEmployees = employees;
	}
	
	private long getNextOrderPosition(Employee employee) {
		long orderPosition = employee.getOrderPosition();
		orderPosition--;
		
		if(orderPosition <= 0) {
			orderPosition = this.orderedEmployees.size();
		}
		
		return orderPosition;
	}
}
