import java.util.ArrayList;
import java.util.HashMap;

public class WorkStation implements Comparable<WorkStation> {
    private String name;
    private Long numEmployees;
    private Boolean isDefault;
    private Long priorityLevel;
    private HashMap<String, Employee> employeeAssignmentMap;

    public WorkStation(String name, Long numEmployees, Boolean isDefault, Long priorityLevel) {
    	this.name = name;
    	this.numEmployees = numEmployees;
    	this.isDefault = isDefault;
    	this.priorityLevel = priorityLevel;
    	employeeAssignmentMap = new HashMap<String, Employee>();
    }

    public String getName() {
        return this.name;
    }

    public Long getNumEmployees() {
        return this.numEmployees;
    }
    
    public Boolean IsDefault() {
    	return this.isDefault;
    }
    
    public Long getPriorityLevel() {
    	return this.priorityLevel;
    }

    public HashMap<String, Employee> getEmployeeAssignmentMap() {
        return this.employeeAssignmentMap;
    }

    public static ArrayList<WorkStation> generateWorkStations() {
        return new ArrayList<WorkStation>();
    }

    public void assignEmployee(Employee employee) {
        if(employeeAssignmentMap.size() < numEmployees) {
        	employeeAssignmentMap.put(employee.getEmployeeId(), employee);
        }
    }
    
    public int compareTo(WorkStation otherWokStation) {
    	Long otherWSPriority = otherWokStation.getPriorityLevel();
    	
    	if(this.priorityLevel < otherWSPriority) {
    		return -1;
    	} else if(this.priorityLevel > otherWSPriority) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}